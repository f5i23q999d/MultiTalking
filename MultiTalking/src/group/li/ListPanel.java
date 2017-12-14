package group.li;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListPanel extends JPanel{
	
	
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
			
			
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		namelabel.setText(name);
		this.name = name;
		
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		//System.out.println(context);
		contextlabel.setText(context);
		this.context = context;
	
		
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		
		this.time = time;
		timelabel.setText(time);
	}
	public ImageIcon getU() {
		return u;
	}
	public void setU(ImageIcon u) {
		ImageIcon  u2=new ImageIcon();
		u2.setImage(u.getImage().getScaledInstance(40, 40,  Image.SCALE_DEFAULT));
		//System.out.println(u);
		this.u = u2;
		ulabel.setIcon(u2);
	}
	
	
	int id;
	String name="";//用户昵称
	String context="";//对话内容
	String time="";//时间
	ImageIcon u;//头像
	JLabel ulabel;
	JLabel namelabel;
	JLabel contextlabel;
	JLabel timelabel;
	JPanel chatpanel;
	
	public ListPanel(String ID)
	{
		
		
		setLayout(null);
		setBackground(new Color(228,228,228));
		
		chatpanel=new ChatPanel(ID);
		
		
		name=ID;
		
		ulabel = new JLabel("");
		ulabel.setIcon(new ImageIcon(ListPanel.class.getResource("/icon/1.png")));
		ulabel.setBounds(10, 0, 50, 50);
		add(ulabel);
		
		namelabel = new JLabel(name);
		namelabel.setBounds(60, 7, 55, 15);
		
		namelabel.setFont(this.getFont(14.5f));
		add(namelabel);
		
		contextlabel = new JLabel(context);
		contextlabel.setBounds(60, 30, 100, 15);
		contextlabel.setFont(this.getFont(11.5f));
		contextlabel.setForeground(new Color(153,153,153));
		add(contextlabel);
		
		timelabel = new JLabel(time);
		timelabel.setBounds(168, 10, 54, 15);
		timelabel.setForeground(new Color(153,153,153));
		add(timelabel);
		
		
	}
	
	
	
	

}
