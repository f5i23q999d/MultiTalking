package group.li;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;

import group.lin.util.DBUtil;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ShowCheckIn extends JFrame{
	public ShowCheckIn() {
		getContentPane().setLayout(null);
		
		
		
		JTextPane textPane = new JTextPane();
		textPane.setText("");
		textPane.setBounds(10, 52, 414, 199);
		getContentPane().add(textPane);
		
		
		JButton Button1 = new JButton("查看今天已签到人员");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
				DBUtil db=DBUtil.getDBUtil();
				String sql="select User from 12CheckIn where day=? ";
				Object[] obj = {TimeGet.dayTime().substring(2,4)};
				ResultSet rs=db.executeQuery(sql,obj);
				try {
					while(rs.next())
					{
						
						
						try {
							textPane.setText(textPane.getText()+rs.getString("User")+"\r\n");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
			}

		});
		Button1.setBounds(73, 5, 141, 23);
		getContentPane().add(Button1);
		
		JButton Button2 = new JButton("查看今天未签到人员");
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textPane.setText("");
				DBUtil db=DBUtil.getDBUtil();
				String sql="       select userId from USER   where not exists  (  select User from 12CheckIn  where day=? and userId=User) ";
				Object[] obj = {TimeGet.dayTime().substring(2,4)};
				ResultSet rs=db.executeQuery(sql,obj);
				try {
					while(rs.next())
					{
						
						
						try {
							textPane.setText(textPane.getText()+rs.getString("userId")+"\r\n");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		Button2.setBounds(219, 5, 141, 23);
		getContentPane().add(Button2);

	}
}
