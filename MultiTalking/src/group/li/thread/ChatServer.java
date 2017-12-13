package group.li.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChatServer {
	
	static Map map = new HashMap();
	static Map news = new HashMap();
//公共聊天室	
	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(6666);
		
		List<Socket> socketList=new LinkedList<Socket>();
		
		
		while(true){
			Socket socket=ss.accept();
			socketList.add(socket);
			
			Thread t=new Thread(new ChatThread(socket,socketList));
			t.start();
			
		}
		
	}
}