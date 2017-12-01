package group.li;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingPanel extends JFrame{
	public SettingPanel() {
		setResizable(false);
		getContentPane().setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton AddFriend = new JButton("添加好友");
		AddFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FriendAdd fa=new FriendAdd(UI.ID);
				fa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				fa.setSize(500, 300);
				fa.setLocale(null);
				fa.setVisible(true);
			}
		});
		getContentPane().add(AddFriend);
		
		JButton MManager = new JButton("消息管理");
		MManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageManager fa=new MessageManager();
				fa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				fa.setSize(400, 550);
				fa.setLocale(null);
				fa.setVisible(true);
				
				
				
				
				
			}
		});
		getContentPane().add(MManager);
		
		JButton SetInfo = new JButton("个人信息设置");
		getContentPane().add(SetInfo);
		
		JButton About = new JButton("关于");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(About);
	}

}
