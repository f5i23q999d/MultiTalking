package group.linzx.ChatRecord;

import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import group.li.UI;

import javax.swing.JList;

public class ShowChatRecord {

	public JFrame recordframe;
	public static String fileUrl="C://Multitalking123_207_117_122/ChatRecord/"+UI.ID+"2"+UI.panel_2.nameTitle.getText()+".txt";
 
	public static  JTextArea textArea;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowChatRecord window = new ShowChatRecord();
					window.recordframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowChatRecord() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		recordframe = new JFrame();
		recordframe.setBounds(100, 100, 714, 446);
		//recordframe.setDefaultCloseOperation(recordframe.EXIT_ON_CLOSE);
		recordframe.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入查找关键字：");
		label.setBounds(35, 13, 161, 45);
		recordframe.getContentPane().add(label);
		
		JTextArea ChatKeyWord = new JTextArea();
		ChatKeyWord.setBounds(193, 24, 346, 24);
		recordframe.getContentPane().add(ChatKeyWord);
		
		JButton search = new JButton("查找");
		search.setBounds(564, 23, 104, 24);
		recordframe.getContentPane().add(search);
		
		
		
	    textArea = new JTextArea();
	    getRecordChat(textArea);
		textArea.setEnabled(false);
		textArea.setBounds(14, 56, 682, 345);
		recordframe.getContentPane().add(textArea);
	}
	
	/*
	 * 自动获得往期的聊天记录
	 */
	public static void getRecordChat( JTextArea textArea) {
         
   		try {
   			LineNumberReader br=new LineNumberReader(new FileReader(fileUrl));
   			String Record="";
   			String s;
   			for(s=br.readLine();s!=null;s=br.readLine()) {
   				System.out.println(br.getLineNumber()+":"+s);
   				Record=Record+"\n"+br.getLineNumber()+":"+s;
   				ShowChatRecord.textArea.setText(Record);
   			}
   			br.close();
   		}catch(IOException e){
   			System.out.println("读取聊天记录错误");
   			ShowChatRecord.textArea.setText("读取聊天记录错误");
   		}
   	}
}
