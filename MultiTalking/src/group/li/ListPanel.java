package group.li;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListPanel extends JPanel{
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
		System.out.println(context);
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
	String name="3";//用户昵称
	String context="[动画表情]";//对话内容
	String time="14:46";//时间
	ImageIcon u;//头像
	JLabel ulabel;
	JLabel namelabel;
	JLabel contextlabel;
	JLabel timelabel;
	
	public ListPanel()
	{
		
		
		setLayout(null);
		setBackground(Color.WHITE);
		
		
		ulabel = new JLabel("");
		ulabel.setIcon(new ImageIcon(ListPanel.class.getResource("/icon/1.png")));
		ulabel.setBounds(10, 0, 50, 50);
		add(ulabel);
		
		namelabel = new JLabel(name);
		namelabel.setBounds(74, 10, 54, 15);
		Font font1 = new java.awt.Font("黑体", Font.BOLD,12);
		namelabel.setFont(font1);
		add(namelabel);
		
		contextlabel = new JLabel(context);
		contextlabel.setBounds(74, 33, 69, 15);
		add(contextlabel);
		
		timelabel = new JLabel(time);
		timelabel.setBounds(168, 10, 54, 15);
		add(timelabel);
		System.out.println("luo");
		
	}
	
	
	
	

}
