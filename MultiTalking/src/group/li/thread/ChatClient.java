package group.li.thread;

import java.awt.Color;
import java.io.*;

import java.net.*;
import java.nio.file.FileSystemException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import group.li.ContactPanel;
import group.li.IDTextPane;
import group.li.ListPanel;
import group.li.UI;
import group.lin.dao.GroupsInfoDAO;

public class ChatClient {

	static Socket socket;

	public void sendFile(String filePath) {
		int length = 0;
		byte[] sendByte = null;
		DataOutputStream dout = null;
		FileInputStream fin = null;
		File file;

		try {
			try {
				dout = new DataOutputStream(socket.getOutputStream());
				file = new File(filePath);
				fin = new FileInputStream(file);
				sendByte = new byte[1024];

				dout.writeUTF(file.getName());
				System.out.println("6");

				while ((length = fin.read(sendByte, 0, sendByte.length)) > 0) {
					dout.write(sendByte, 0, length);
					dout.flush();
				}
				//dout.write("!@#$".getBytes());
				dout.writeUTF("!@#$");
				System.out.println("9");
			} catch (Exception e) {

			} finally {
				if (fin != null)
					fin.close();
//				socket.shutdownOutput();
				// if (dout != null)
				// dout.close();
				// if (socket != null)
				// socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SendAMessage(String name, String context) {

		SendMessage t = new SendMessage(socket, name, context);
		Thread tt = new Thread(t);
		tt.start();
		// System.err.println("发送消息"+context);

	}

	public static void main(String[] args) throws Exception {

		socket = new Socket("127.0.0.1", 6666);
		// socket=new Socket("123.207.117.122", 6666);

		String name = UI.ID;
		System.out.println("客户端已经链接.....");

		CTSendID t = new CTSendID(socket, name);
		Thread tt = new Thread(t);
		tt.start();

		CTGetMessage g = new CTGetMessage(socket);
		CTSendMessage s = new CTSendMessage(socket, name);

		Thread gt = new Thread(g);
		Thread st = new Thread(s);

		gt.start();
		st.start();
	}
}

class CTGetMessage implements Runnable {
	private Socket socket;
	private BufferedReader bufferedReader;

	public void receiveFile() throws IOException {
		byte[] inputByte = null;
		int length = 0;
		DataInputStream din = null;
		FileOutputStream fout = null;
		try {
			inputByte = new byte[1024];
			String tmp = new String(inputByte);
			din = new DataInputStream(socket.getInputStream());
			File file = new File("E:/"+din.readUTF());
		
			fout = new FileOutputStream(file);
			System.out.println("收取路径："+file.getAbsolutePath());
			System.out.println("8.C开始接收数据...");
			while (true) {
				if (din != null) {
					length = din.read(inputByte, 0, inputByte.length);
				}
				tmp = new String(inputByte);
				System.err.println(tmp);
				if (tmp.indexOf("!@#$")!=-1) {
					break;
				}
				System.out.println(length);
				fout.write(inputByte, 0, length);
				fout.flush();
			}
			System.out.println("11.C完成接收");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.out.println(ex);
		} catch (FileSystemException ex) {
			System.out.println(ex);
		} finally {
			if (fout != null)
				fout.close();
//			if (din != null)
//				din.close();
//			if (socket != null)
//				socket.close();
		}
	}

	public CTGetMessage(Socket socket) {
		this.socket = socket;
		InputStreamReader r = null;
		try {
			r = new InputStreamReader(this.socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		this.bufferedReader = new BufferedReader(r);
	}

	public String getID(String jj) {

		String tmp = "";
		int i = 0;
		for (; i < jj.length() - 1; i++) {
			if (jj.charAt(i + 1) != ':')
				tmp += jj.charAt(i);
			else
				break;

		}
		tmp += jj.charAt(i);
		return tmp;

	}

	public String getContent(String jj) {

		String tmp = "";
		int i = 0;
		for (; i < jj.length() - 1; i++) {
			if (jj.charAt(i) == ':') {
				for (int j = i + 1; j < jj.length(); j++)
					tmp = tmp + jj.charAt(j);
				return tmp;

			}
		}

		return "没内容";

	}

	public void run() {
		String msg = null;
		while (true) {
			try {
				this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				msg = this.bufferedReader.readLine();
				System.out.println("收到信息:" + msg);

				if (getContent(msg).equals("FF")) {
					System.out.println("4");
					receiveFile();
				} else if (getContent(msg).equals("*")) {
					UI.CP = new ContactPanel(UI.ID);// 刷新好友面板
					JOptionPane.showMessageDialog(null, UI.ID + "已同意好友申请!");

				} else if (getContent(msg).equals("/")) {
					// System.err.println("收到信息:"+msg);
					UI.CP = new ContactPanel(UI.ID);// 刷新好友面板
					JOptionPane.showMessageDialog(null, "有人拉你入群!");

				} else if (!msg.equals("对方没上线")) {
					boolean exist = false;
					for (int i = 0; i < UI.list.size(); i++)
						if (UI.list.get(i).getName().equals(getID(msg))) {
							exist = true;
							UI.list.get(i).setContext(getContent(msg));// 及时刷新中间面板的聊天信息

							for (int k = 0; k < UI.list.size(); k++)
								UI.list.get(k).setBackground(new Color(228, 228, 228));

							UI.list.get(i).setBackground(new Color(200, 200, 200));// 颜色调整

							break;
						}

					if (!exist) {
						UI.list.add(new ListPanel(getID(msg)));
						UI.list.get(UI.list.size() - 1).setContext(getContent(msg));

						for (int k = 0; k < UI.list.size(); k++)
							UI.list.get(k).setBackground(new Color(228, 228, 228));

						UI.list.get(UI.list.size() - 1).setBackground(new Color(200, 200, 200));// 颜色调整
					}
					UI.pageSwitch(0);// 及时刷新中间面板

					// UI.panel_2.nameTitle.setText(getID(msg));

					// UI.panel_2.textPane.append(msg+"\r\n");

					exist = false;
					int tmp = 0;

					// System.err.println("getid:"+getID(msg));//谁发的

					UI.panel_2.nameTitle.setText(getID(msg));

					for (int i = 0; i < UI.panel_2.list.size(); i++)
						if (UI.panel_2.list.get(i).ID.equals(getID(msg))) {
							exist = true;
							tmp = i;
							break;
						}

					String[][] isGroup;
					GroupsInfoDAO GI = new GroupsInfoDAO();
					isGroup = GI.queryForUser(getID(msg));

					// 下面部分是聊天面板处理
					if (!exist) {
						UI.panel_2.list.add(new IDTextPane(getID(msg)));
						UI.panel_2.list.get(UI.panel_2.list.size() - 1).ID = getID(msg);
						if (isGroup != null)
							UI.panel_2.list.get(UI.panel_2.list.size() - 1).append(getContent(msg));
						else
							UI.panel_2.list.get(UI.panel_2.list.size() - 1).append(msg);

						UI.panel_2.textPane.setText(UI.panel_2.list.get(UI.panel_2.list.size() - 1).getText());
						UI.panel_2.textPane.getText();
						// System.out.println("1111111111");
					} else {
						// System.out.println("2222222222222");
						UI.panel_2.list.get(tmp).append("\r\n");
						if (isGroup != null)
							UI.panel_2.list.get(tmp).append(getContent(msg));
						else
							UI.panel_2.list.get(tmp).append(msg);
						UI.panel_2.textPane.setText(UI.panel_2.list.get(tmp).getText());
					}
				}

				System.out.println(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}

class CTSendMessage implements Runnable {
	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	private String name;

	public CTSendMessage(Socket socket, String name) {
		this.name = name;
		this.socket = socket;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			bufferedReader = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			this.printWriter = new PrintWriter(bw, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// System.out.println("in CTSendMessage");
		String msg = null;
		while (true) {
			try {
				msg = name + ":" + bufferedReader.readLine();
				printWriter.println(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

class CTSendID implements Runnable {
	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	private String name;

	public CTSendID(Socket socket, String name) {
		this.name = name;
		this.socket = socket;
		try {

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			this.printWriter = new PrintWriter(bw, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// System.out.println("in CTSendID");
		String msg = null;

		try {
			msg = name;
			printWriter.println(msg);
			// System.err.println("发送id:"+msg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class SendMessage implements Runnable {
	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;
	private String name;
	private String context;

	public SendMessage(Socket socket, String name, String context) {
		this.name = name;
		this.context = context;
		this.socket = socket;
		try {

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			this.printWriter = new PrintWriter(bw, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// System.out.println("in CTSendID");
		String msg = null;

		try {
			msg = name;

			printWriter.println(context + "@" + name);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}