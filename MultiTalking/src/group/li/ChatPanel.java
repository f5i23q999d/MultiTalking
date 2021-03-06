package group.li;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import group.lin.dao.GroupsInfoDAO;
import group.linzx.ChatRecord.ShowChatRecord;
import group.linzx.ChatRecord.WriteChatRecord;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatPanel extends JPanel{
	String name;
	JPanel NameTitle;
	public JLabel nameTitle;
	JPanel textType;
	JButton emoji;
	JButton sendFile;
	JButton ChatRecord;
	JButton sendButton;
	JTextPane textField;
	public IDTextPane textPane;
	public JButton showButton;
	SimpleAttributeSet Friend = new SimpleAttributeSet();
	SimpleAttributeSet Yourself = new SimpleAttributeSet();
	static public ArrayList<IDTextPane> list=new ArrayList<IDTextPane>();
	
	
	//添加字库方法
	public Font getFont(float size) {  
        String pathString = getClass().getClassLoader().getResource("HanYix.ttf").getFile();  
        try {  
            Font dynamicFont = Font.createFont(Font.PLAIN, new File(pathString));  
            
            dynamicFont = dynamicFont.deriveFont(size);  
            return dynamicFont;  
        } catch (FontFormatException ex) {  
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);  
        } catch (IOException ex) {  
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);  
        }  
          
        return null;  
}
	
	
	
	public ChatPanel(String name) {
		setLayout(null);
		this.name=name;
		NameTitle = new JPanel();
		NameTitle.setBounds(0, 0, 550, 50);
		NameTitle.setBackground(new Color(245,245,245));
		add(NameTitle);
		NameTitle.setLayout(null);
		
		nameTitle = new JLabel(name);
		nameTitle.setFont(this.getFont(24));
		nameTitle.setBounds(30, 10, 100, 30);
		NameTitle.add(nameTitle);
		
		showButton = new JButton("查看成员");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMember fa=new showMember();
				fa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				fa.setSize(400, 550);
				fa.setLocale(null);
				fa.setVisible(true);
				
				
				
			}
		});
		showButton.setVisible(false);
		showButton.setBounds(412, 19, 128, 23);
		NameTitle.add(showButton);
		
		textType = new JPanel();
		textType.setBackground(Color.WHITE);
		textType.setBounds(0, 350, 550, 150);
		add(textType);
		textType.setLayout(null);
		
		emoji = new JButton("");
		emoji.setIcon(new ImageIcon(ChatPanel.class.getResource("/tab/16.png")));
		emoji.setBounds(21, 10, 23, 23);
		textType.add(emoji);
		
		sendFile = new JButton("");
		sendFile.setIcon(new ImageIcon(ChatPanel.class.getResource("/tab/17.png")));
		sendFile.setBounds(65, 10, 23, 23);
		textType.add(sendFile);
		
		ChatRecord = new JButton("");
		ChatRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowChatRecord window = new ShowChatRecord();
				window.recordframe.setVisible(true);
				
			}
		});
		ChatRecord.setIcon(new ImageIcon(ChatPanel.class.getResource("/tab/18.png")));
		ChatRecord.setBounds(106, 10, 23, 23);
		textType.add(ChatRecord);
		
		sendButton = new JButton("发送");
		
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Send();
				
				
			}
		});
		sendButton.setBounds(443, 115, 70, 25);
		sendButton.setBackground(new Color(245,245,245));
		textType.add(sendButton);
		
		textField = new JTextPane();
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//回车发送的触发监听必须卸载打字框里，若设置在按钮，着必须先点击按钮，监听才开始生效
				
			
				//getKeyCode()错误用法
				if (e.getKeyCode()==KeyEvent.VK_F)
					System.out.println("F");
					
					
				if (e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					//Send(); 有严重BUG
				}
				
			}
		});
		
		
		
		textField.setBounds(10, 44, 516, 61);
		textType.add(textField);
		
		textPane = new IDTextPane("");
		//System.err.println(textPane.getText());
		//textPane.setText("\r\n");
		textPane.setEditable(false);
		//textPane.setContentType("text/plain");
	    StyleConstants.setFontSize(Friend, 18);
	    StyleConstants.setFontSize(Yourself, 18);
	    StyleConstants.setAlignment(Yourself, StyleConstants.ALIGN_RIGHT);
	    	
		    
		    
		
		
		
		
			//textPane.getDocument().insertString(textPane.getDocument().getLength(), "dick\n", Friend);
			//textPane.getDocument().insertString(textPane.getDocument().getLength(), "right\n", Yourself);
			//textPane.getDocument().insertString(textPane.getDocument().getLength(), "OK\n", Friend);

			
		
		textPane.setBorder(null);
		textPane.setFont(this.getFont(16));

		textPane.setBackground(new Color(245,245,245));
	
		JScrollPane scl =new JScrollPane(textPane);
		scl.setBounds(0, 50, 550, 300);
		scl.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scl);
	}
	
	
	public void Send()
	{

		
		UI.thread.SendAMessage(nameTitle.getText(), textField.getText());

//下面这段为找到相应的ID
		
		int n = 0;
		for(int i=0;i<list.size();i++)	{									
						if(list.get(i).ID.equals(nameTitle.getText()))
						{								
							n=i;									
						}};
//list.get(n).getDocument().insertString(list.get(n).getDocument().getLength(),textField.getText(),Yourself);
	//这里的点击按钮和按回车产生的顺序有所不同，语句略有差别
						
						String [][]isGroup; 
						GroupsInfoDAO GI=new GroupsInfoDAO();
						isGroup=GI.queryForUser(nameTitle.getText());
						
		if(isGroup!=null)
			textPane.setText(textPane.getText()+"\r\n"+UI.ID+":"+textField.getText()+"\r\n");
		else
			textPane.setText(textPane.getText()+"\r\n我说:"+textField.getText()+"\r\n");
		
		list.get(n).setText(textPane.getText());

//下面的for循环实现实时更新对话内容信息
		for(int i=0;i<UI.list.size();i++)
			if(UI.list.get(i).namelabel.getText().equals(nameTitle.getText()))
			{
					UI.list.get(i).contextlabel.setText(textField.getText());
					UI.list.get(i).timelabel.setText(TimeGet.time());
					
			}

		
		
		textField.setText("");
		
		/*
		 * lzx:尝试获得聊天内容显示在控制台上 ，实现把对话内容写到文件中
		 */

		WriteChatRecord.write2ChatFile(UI.panel_2.nameTitle.getText() + " :  " + UI.panel_2.textPane.getText());
		
		
	}
}
