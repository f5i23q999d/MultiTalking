package group.li.thread;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import group.lin.dao.GroupsInfoDAO;

public class ChatThread implements Runnable {

	private List<Socket> socketList;
	private Socket socket;
	private BufferedReader bufferedReader;
	private String IDname;

	public ChatThread(Socket socket, List<Socket> socketList) {
		this.socket = socket;
		this.socketList = socketList;
	}

	private void sendFile(Socket socket) throws IOException {
		// TODO Auto-generated method stub
		byte[] inputByte = null;
		int length = 0;
		DataInputStream din = null;
		DataOutputStream dout = null;
		try {
			din = new DataInputStream(this.socket.getInputStream());
			dout = new DataOutputStream(socket.getOutputStream());
			inputByte = new byte[1024];
			String tmp = new String(inputByte);
			
			dout.writeUTF(din.readUTF());			
			System.out.println("7.S开始接收数据...");
			
			while (true) {
				
				if (din != null) {
					length = din.read(inputByte, 0, inputByte.length);
				}
				/*
				if (tmp.equals("!@#$")) {
					break;
				}
				*/
				
				if(length==-1)
					break;
				
				/*
				tmp = new String(inputByte);
				System.err.println(tmp);
				if(inputByte.toString().equals("!@#$"))
					break;
				*/
				
				System.out.println(length);
				dout.write(inputByte, 0, length);
				dout.flush();
			}
			dout.write("!@#$".getBytes());
			System.out.println("10.S完成接收");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
//			socket.shutdownOutput();
//			if (dout != null)
//				dout.close();
//			if (din != null)
//				din.close();
//			if (socket != null)
//				socket.close();
		}
		
	}

	private void checkIDUpLine() {

		// synchronized(ChatServer.news) {

		if (ChatServer.news.containsKey(IDname)) {
			List<String> chartList = (List<String>) ChatServer.news.get(IDname);
			PrintWriter pw = this.getSocketPrintWriter(socket);
			for (String chart : chartList) {
				pw.println(getContext(chart));
			}
			ChatServer.news.remove(IDname);
		} else {
			/*
			 * PrintWriter pw = this.getSocketPrintWriter(socket);
			 * pw.println("NONE MISSING MESSAGE TO YOU");
			 */
		}

		// }

	}

	private void saveChat(String msg) {
		// synchronized(ChatServer.news) {
		String id = getDest(msg);
		List<String> chartList = null;
		// System.out.println("已保存消息:"+msg);
		if (ChatServer.news.containsKey(id)) {
			chartList = (List<String>) ChatServer.news.get(id);
			chartList.add(msg);
		} else {
			chartList = new ArrayList<String>();
			chartList.add(msg);
		}

		ChatServer.news.put(id, chartList);
		// }

	}

	private void preRun() {
		// System.out.println("INpreRUn");
		InputStreamReader r = null;
		try {
			r = new InputStreamReader(this.socket.getInputStream());
			this.bufferedReader = new BufferedReader(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void prepreRun() {
		// System.out.println("INprepreRUn");
		InputStreamReader r = null;
		try {

			r = new InputStreamReader(this.socket.getInputStream());
			this.bufferedReader = new BufferedReader(r);
			IDname = bufferedReader.readLine();
			ChatServer.map.put(IDname, this.socket);
			Socket t = (Socket) ChatServer.map.get(IDname);
			// System.out.println("用户："+bufferedReader.readLine()+"已连接，socket为"+t.getInetAddress().getHostAddress()+"
			// port:"+t.getPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private PrintWriter getSocketPrintWriter(Socket socket) {
		OutputStream os = null;
		try {
			os = socket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		return new PrintWriter(bw, true);
	}

	private void broadcast(String msg) {
		for (Socket s : socketList) {
			PrintWriter pw = this.getSocketPrintWriter(s);
			pw.println(msg);
		}
	}

	// 私聊
	private void broadcastTo(String msg) {
		System.out.println(msg);
		String id = getDest(msg);
		Socket s = (Socket) ChatServer.map.get(id);

		GroupsInfoDAO GI = new GroupsInfoDAO();
		String[][] groupM = GI.queryForUser(id);
		if (groupM != null)// 如果是群聊的话
		{

			for (int k = 0; k < groupM.length; k++) {
				if (!groupM[k][0].equals(getContextID(msg)))// 防止直接发给自己
				{
					Socket s2 = (Socket) ChatServer.map.get(groupM[k][0]);// 获取所有群成员的SOCKET
					if (s2 == null) {
						saveChat(id + ":" + getContext(msg) + "@" + groupM[k][0]);
					} // 如果对方未上线则先保存好信息
					else {
						PrintWriter pw2 = this.getSocketPrintWriter(s2);

						pw2.println(id + ":" + getContext(msg));// 不然直接发送
						// System.err.println("已发送消息: "+id+":"+getContext(msg)+"
						// 到"+groupM[k][0]);
					}
				}
			}
			return;
		}

		if (s == null) {
			Socket s1 = (Socket) ChatServer.map.get(IDname);
			PrintWriter pw1 = this.getSocketPrintWriter(s1);
			pw1.println("对方没上线");

			//
			saveChat(msg);
			return;
		} else if (getContext(msg).equals("FF")) {
			PrintWriter pw = this.getSocketPrintWriter(s);
			pw.println(getContext(msg));

		} else {
			PrintWriter pw = this.getSocketPrintWriter(s);
			pw.println(getContext(msg));

		}

	}

	// 获取@之前的字段
	public String getContext(String jj)

	{

		String tmp = "";
		int i = 0;
		for (; i < jj.length() - 1; i++) {
			if (jj.charAt(i + 1) != '@')
				tmp += jj.charAt(i);
			else
				break;

		}
		tmp += jj.charAt(i);
		return tmp;

	}

	// 获取第一个:之前的字段
	public String getContextID(String jj)

	{

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

	// 获取@后字段
	public String getDest(String jj) {
		String tmp = "";
		for (int i = 0; i < jj.length(); i++)
			if (jj.charAt(i) == '@')
				for (int j = i + 1; j < jj.length(); j++)
					tmp += jj.charAt(j);

		return tmp;

	}

	public void run() {
		String msg = "";
		String tmp = "";
		this.prepreRun();
		this.preRun();

		//
		checkIDUpLine();

		while (true) {
			try {
				tmp = this.bufferedReader.readLine();

				msg.replaceAll("\r\n", "");
				if (tmp.substring(0,tmp.length()>2?2:tmp.length()).equals("FF")) {
					System.out.println("2");
					msg = IDname + ":" + tmp;
					this.broadcastTo(msg);
					System.out.println("3");
					
					String id = getDest(msg);
					Socket s = (Socket) ChatServer.map.get(id);
					this.sendFile(s);
				} else {
					msg = IDname + ":" + tmp;
					this.broadcastTo(msg);
				}
			} catch (IOException e) {
				try {
					System.out.println(IDname+" socket close.");
					this.bufferedReader.close();
					this.socket.close();
					ChatServer.map.remove(IDname);
					/*
					 * this.broadcast("somebody exist....people size :"
					 * +socketList.size());
					 */
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				return;
			}
		}
	}
}
