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
		getContentPane().setLayout(new GridLayout(5, 1, 0, 0));
		
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
		
		JButton createGroup = new JButton("创建群聊");
		createGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectFriends sf=new selectFriends();
				sf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				sf.setSize(500, 500);
				sf.setLocale(null);
				sf.setVisible(true);
				
			}
		});
		getContentPane().add(createGroup);
	
		
		JButton MManager = new JButton("消息管理");
		MManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageManager SM=new MessageManager();
				SM.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				SM.setSize(400, 550);
				SM.setLocale(null);
				SM.setVisible(true);
				
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
