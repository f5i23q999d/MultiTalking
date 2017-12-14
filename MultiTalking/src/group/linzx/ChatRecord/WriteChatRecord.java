package group.linzx.ChatRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import group.li.UI;

public class WriteChatRecord {
	public static String fileUrl="C://Multitalking123_207_117_122/ChatRecord/"+UI.ID+"2"+UI.panel_2.nameTitle.getText()+".txt";
	public static void  write2ChatFile(String record1) {
		try {
			if(!(new File("C://Multitalking123_207_117_122/ChatRecord").isDirectory())) {
				new File("C://Multitalking123_207_117_122/ChatRecord").mkdirs();
			}
			FileWriter f=new FileWriter(fileUrl);
			BufferedWriter bw=new BufferedWriter(f);
			bw.write(record1);
			bw.newLine();
			bw.close();
			
		}catch(IOException e){
			System.out.println("保存聊天记录错误");
		}
	}
	
}
