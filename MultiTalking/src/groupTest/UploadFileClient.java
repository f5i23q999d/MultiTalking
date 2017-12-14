package groupTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UploadFileClient {
	private Socket socket;
	private String id;
	private String fileName;
	private File file;
	
	public UploadFileClient(Socket socket,String id,String fileName) {
		this.socket  = socket;
		this.id      = id;
		this.fileName= fileName;
				
	}
	
	public void send() {
		
		file = new File(fileName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			
			pw.println(file.getName()+"@"+id+"@file");
			String tmp = null;
			while ((tmp=bf.readLine()) != null) {
				pw.println(tmp);
			}
			socket.shutdownOutput();
			
			pw.close();			
			bf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Client can't found file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not logical exit.");
		}
	}
	
	public void receive() {
		int counter = 1;
		String tmp = null;
		FileWriter fr = null;
		this.fileName = fileName.split("@")[0];
		
		// let the new not cover	 the old
		file = new File(fileName);
		String[] F = fileName.split(".");
		while (file.exists()) {
			file = new File(F[0]+counter+"."+F[1]);
			counter++;
		}
		
		try {
			InputStreamReader r = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(r);
			fr = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fr,true);
			
			while ((tmp = br.readLine()) != null) {
				pw.println(tmp);
			}
			
			pw.close();
			br.close();
			r.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Receive file can't logical");
		}
		
	}
	
	

}
