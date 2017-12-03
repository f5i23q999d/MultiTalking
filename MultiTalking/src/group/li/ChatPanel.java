package group.li;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ChatPanel extends JPanel{
	String name;
	JPanel NameTitle;
	JLabel nameTitle;
	JPanel textType;
	JButton emoji;
	JButton sendFile;
	JButton ChatRecord;
	JButton sendButton;
	JTextPane textField;
	IDTextPane textPane;
	SimpleAttributeSet Friend = new SimpleAttributeSet();
	SimpleAttributeSet Yourself = new SimpleAttributeSet();
	static ArrayList<IDTextPane> list=new ArrayList<IDTextPane>();
	
	public ChatPanel(String name) {
		setLayout(null);
		this.name=name;
		NameTitle = new JPanel();
		NameTitle.setBounds(0, 0, 550, 50);
		NameTitle.setBackground(new Color(245,245,245));
		add(NameTitle);
		NameTitle.setLayout(null);
		
		nameTitle = new JLabel(name);
		nameTitle.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		nameTitle.setBounds(30, 10, 99, 30);
		NameTitle.add(nameTitle);
		
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
		ChatRecord.setIcon(new ImageIcon(ChatPanel.class.getResource("/tab/18.png")));
		ChatRecord.setBounds(106, 10, 23, 23);
		textType.add(ChatRecord);
		
		sendButton = new JButton("发送");
		
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				for(int i=0;i<UI.panel_2.list.size();i++)
					System.out.println("listID："+list.get(i).ID);
				
				System.out.println(nameTitle.getText());
				*/
				
				//textPane.setText(textPane.getText()+"\r\n"+textField.getText());
				//textPane.getDocument().insertString(textPane.getDocument().getLength(), textField.getText()+"\n", Yourself);
				//System.out.println(textPane.getDocument().getText(0,textPane.getDocument().getLength() ));
				
				
//下面这段为找到相应的ID
				
int n = 0;
for(int i=0;i<list.size();i++)
{	
				
				if(list.get(i).ID.equals(nameTitle.getText()))
				{
					
					n=i;
					//System.err.println("找到相同名字"+nameTitle.getText()+n);
				}
}
//list.get(n).getDocument().insertString(list.get(n).getDocument().getLength(),textField.getText(),Yourself);
			//这里的点击按钮和按回车产生的顺序有所不同，语句略有差别
		textPane.setText(textPane.getText()+"我说:"+textField.getText()+"\r\n");
		list.get(n).setText(textPane.getText());
		
		//下面的for循环实现实时更新对话内容信息
		for(int i=0;i<UI.list.size();i++)
			if(UI.list.get(i).namelabel.getText().equals(nameTitle.getText()))
			{
					UI.list.get(i).contextlabel.setText(textField.getText());
					UI.list.get(i).timelabel.setText(TimeGet.time());
					
			}
		////////////////////////////
		
		
//System.out.println("listID:"+list.get(n).ID+"   context:"+list.get(n).getDocument().getText(0, list.get(n).getDocument().getLength()));
/////////////////
				
				
				
				textField.setText("");
				
				
				
				
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
				//textPane.getDocument().insertString(textPane.getDocument().getLength(), textField.getText()+"-", Yourself);
				textPane.setText(textPane.getText()+"我说:"+textField.getText());
				//下面的for循环实现实时更新对话内容信息
				for(int i=0;i<UI.list.size();i++)
					if(UI.list.get(i).namelabel.getText().equals(nameTitle.getText()))
					{
							UI.list.get(i).contextlabel.setText(textField.getText());
							UI.list.get(i).timelabel.setText(TimeGet.time());
					}
				////////////////////////////
				textField.setText("");
				int n = 0;
				for(int i=0;i<list.size();i++)
				{	
					if(list.get(i).ID.equals(nameTitle.getText()))								
								n=i;
								
				}
				list.get(n).setText(textPane.getText());
			
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
		textPane.setFont(new Font("宋体", Font.PLAIN, 16));

		textPane.setBackground(new Color(245,245,245));
	
		JScrollPane scl =new JScrollPane(textPane);
		scl.setBounds(0, 50, 550, 300);
		scl.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scl);
	}
}
