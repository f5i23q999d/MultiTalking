package group.li;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import group.lin.entity.UserDAO;
import group.lin.util.DBUtil;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class MessagePanel extends JPanel{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		TaskTitle.setText(name);
		this.name = name;
		
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
	JLabel TaskTitle;
	JLabel TaskTime;
	static JButton btnNewButton;
	
	public MessagePanel(String []X)
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
//		result[j][0] = cr.getSender();
//		result[j][1] = cr.getReceiver();
//		result[j][2] = cr.getTime();
//		result[j][3] = cr.getContext();
//		result[j][4] = cr.getAttachment();
//		result[j][5] = cr.getTitle();
//		result[j][6] = String.valueOf(cr.getState());	
		
		setLayout(null);
		setBackground(Color.WHITE);
		name="";
		
		ulabel = new JLabel("");
		ulabel.setIcon(new ImageIcon(MessagePanel.class.getResource("/tab/u1265.png")));
		ulabel.setBounds(10, 13, 35, 35);
		add(ulabel);
		
		TaskTitle = new JLabel(X[5]);
		TaskTitle.setBounds(74, 10, 125, 15);
		Font font1 = new java.awt.Font("黑体", Font.BOLD,12);
		TaskTitle.setFont(new Font("黑体", Font.BOLD, 15));
		add(TaskTitle);
		
		TaskTime = new JLabel(X[2]);
		TaskTime.setBounds(74, 33, 103, 15);
		add(TaskTime);
		
		btnNewButton = new JButton("查看详情");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Mission m=new Mission(X);
						m.setSize(700, 750);
						m.setLocale(null);
						m.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(370, 8, 93, 40);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("发送人：");
		lblNewLabel.setBounds(209, 10, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("状态：");
		lblNewLabel_1.setBounds(209, 33, 54, 15);
		add(lblNewLabel_1);
		
		JLabel whoSend = new JLabel(X[0]);
		whoSend.setBounds(265, 12, 54, 15);
		add(whoSend);
		
		
		String ST;
		if(Integer.valueOf(X[6])==0)
				ST="未完成";
			else
				ST="已完成";
				
		JLabel State = new JLabel(ST);
		State.setBounds(266, 35, 54, 15);
		add(State);
		
		
	}
}
