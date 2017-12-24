package group.li;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import group.lin.dao.QueryApplyDAO;
import group.lin.dao.QueryConsentDAO;
import group.lin.dao.QueryInfoDAO;
import group.lin.entity.UserDAO;

import javax.swing.AbstractListModel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageManager extends JFrame{
	public MessageManager() {
		setResizable(false);
		getContentPane().setLayout(new GridLayout(10, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("任务中心");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 23));
		lblNewLabel.setBounds(27, 10, 148, 22);
		panel.add(lblNewLabel);
		
		JButton raiseMission = new JButton("发起任务");
		raiseMission.setBackground(Color.GREEN);
		raiseMission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RaiseMission RM=new RaiseMission();
				RM.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				RM.setSize(600, 550);
				RM.setLocale(null);
				RM.setVisible(true);
				
			}
		});
		raiseMission.setBounds(337, 10, 81, 22);
		panel.add(raiseMission);
		
		String record[][];
		UserDAO u=new UserDAO();
		u.setUserId(UI.ID);//冗余
		QueryApplyDAO QA=new QueryApplyDAO();
		record=QA.queryApply(u);
		if(record!=null)
			for(int i=0;i<record.length;i++)
				{
					getContentPane().add(new MessagePanel(record[i]));
				}
		
		
		
		
		QueryConsentDAO QC =new QueryConsentDAO();
		record=QC.queryApply(u);
		if(record!=null)
			for(int i=0;i<record.length;i++)
			{
				getContentPane().add(new consentFinish(record[i]));
			}
		
		
		
	}
}
