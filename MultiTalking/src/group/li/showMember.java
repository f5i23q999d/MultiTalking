package group.li;

import javax.swing.JFrame;

import group.lin.dao.GroupsInfoDAO;

import java.awt.GridLayout;
import javax.swing.JButton;

public class showMember extends JFrame{
	public showMember() {
		//System.err.println(UI.panel_2.nameTitle.getText());
		JButton btnNewButton;
		getContentPane().setLayout(new GridLayout(10, 1, 0, 0));
		String record[][];
		GroupsInfoDAO r=new GroupsInfoDAO();
		record=r.queryForUser(UI.panel_2.nameTitle.getText());
		
		for(int i=0;i<record.length;i++)
		{
				btnNewButton= new JButton(record[i][0]);
				getContentPane().add(btnNewButton);
		
		}
	}
	
	

}
