package group.li;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import group.linzx.AttendanceSystem.PermanentCalendar;
import group.linzx.personInfo.showPersonInfo;

public class SettingPanel extends JFrame{
	public SettingPanel() {
		
		System.err.println(UI.rights);
		setResizable(false);
		getContentPane().setLayout(new GridLayout(7, 1, 0, 0));
		
		JButton createGroup = new JButton("创建讨论组");
		createGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectFriends sf=new selectFriends();
				sf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				sf.setSize(500, 500);
				sf.setLocale(null);
				sf.setVisible(true);
				
			}
		});
		
		JButton button = new JButton("签到打卡");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 PermanentCalendar check=new PermanentCalendar();
			 check.setVisible(true);
					}
		});
		getContentPane().add(button);
		getContentPane().add(createGroup);
	
		
		JButton MManager = new JButton("任务中心");
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
		SetInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				showPersonInfo a=new showPersonInfo();
				a.Personframe.setVisible(true);
			}
		});
		
		JButton About = new JButton("文件传输系统");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(About);
		getContentPane().add(SetInfo);
		
		
		if(UI.rights==1)
		{
		JButton btnNewButton = new JButton("账号分配");
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("账号信息修改");
		getContentPane().add(btnNewButton_1);
		}
	}

}
