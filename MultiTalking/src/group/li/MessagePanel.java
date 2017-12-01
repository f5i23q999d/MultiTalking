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

public class MessagePanel extends JPanel{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		namelabel.setText(name);
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
	JLabel namelabel;
	JLabel contextlabel;
	static JButton btnNewButton;
	
	public MessagePanel(String ID)
	{
		
		
		setLayout(null);
		setBackground(Color.WHITE);
		name=ID;
		
		ulabel = new JLabel("");
		ulabel.setIcon(new ImageIcon(MessagePanel.class.getResource("/icon/1.png")));
		ulabel.setBounds(10, 0, 50, 50);
		add(ulabel);
		
		namelabel = new JLabel(name);
		namelabel.setBounds(74, 10, 54, 15);
		Font font1 = new java.awt.Font("黑体", Font.BOLD,12);
		namelabel.setFont(new Font("黑体", Font.BOLD, 15));
		add(namelabel);
		
		contextlabel = new JLabel("申请加我为好友");
		contextlabel.setBounds(74, 33, 103, 15);
		add(contextlabel);
		
		btnNewButton = new JButton("接受");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUtil db=DBUtil.getDBUtil();
				String sql="update CONTACT set accept=1 where senderID =? and receiverID=?";
				Object[] obj={ID,UI.ID};
				db.executeUpdate(sql,obj);
				
				acceptFriend af=new acceptFriend(ID);
				af.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				af.setSize(500,100);
				af.setVisible(true);
				
				//btnNewButton.setText("已接受");
				//btnNewButton.setEnabled(false);
				
			}
		});
		btnNewButton.setBounds(231, 10, 93, 40);
		add(btnNewButton);
		
		
	}
	
	
	
	

}
