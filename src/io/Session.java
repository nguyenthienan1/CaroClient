package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

import javax.swing.JOptionPane;

import client.CaroClient;
import client.HandleMessage;

public class Session {
	public Socket socket;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	public boolean connected;
	private final BlockingQueue<Message> DataQueue = new ArrayBlockingQueue<>(64);

	public Session() {
	}

	public void Connect(String ip, int port) throws IOException {
		if (!connected) {
			socket = new Socket(ip, port);
			connected = true;
			if (socket != null) {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			}
			startThread();
		}
	}

	public void startThread() {
		sendMessageThread();
		receiveMessageThread();
	}

	public void sendMessage(Message m) {
		if (connected) {
			try {
				DataQueue.put(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void sendMessageThread() {
		new Thread(() -> {
			Message m;
			try {
				while (connected) {
					m = DataQueue.poll(5, TimeUnit.SECONDS);
					if (m != null) {
						doSendMessage(m);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			disconnect();
			DataQueue.clear();
			dos = null;
		}).start();
		//System.out.println("Finish Send Thread");
	}

	private void receiveMessageThread() {
		new Thread(() -> {
			Message message;
			try {
				while (connected) {
					message = readMessage();
					HandleMessage.gI().processMessage(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			disconnect();
			dis = null;
		}).start();
		//System.out.println("Finish Receive Thread");
	}

	private void doSendMessage(Message m) throws Exception {
		dos.writeInt(m.command);
		byte[] data = m.getData();
		if (data != null) {
			int size = data.length;
			dos.writeInt(size);
			dos.write(data);
			//System.out.println("Send message: command (" + m.command + ") size [" + size + "]");
		} else {
			dos.writeInt(0);
		}
		dos.flush();
	}

	private Message readMessage() throws Exception {
		int cmd = dis.readInt();
		int size = dis.readInt();
		byte[] data = new byte[size];
		int len = 0;
		int byteRead = 0;
		while (len != -1 && byteRead < size) {
			len = dis.read(data, byteRead, size - byteRead);
			if (len > 0) {
				byteRead += len;
			}
		}
		//System.out.println("Receive message: command (" + cmd + ") size [" + size + "]");
		return new Message(cmd, data);
	}

	public void disconnect() {
		if (connected) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Error connect to server");
			CaroClient.window.setContentPane(CaroClient.connectUI);
			connected = false;
		}
	}
}
