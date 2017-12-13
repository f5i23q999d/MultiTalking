package group.li;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import group.lin.dao.QueryApplyDAO;
import group.lin.dao.QueryInfoDAO;
import group.lin.entity.UserDAO;

import javax.swing.AbstractListModel;
import java.awt.GridLayout;

public class MessageManager extends JFrame{
	public MessageManager() {
		setResizable(false);
		getContentPane().setLayout(new GridLayout(10, 1, 0, 0));
		
		String record[][];
		UserDAO u=new UserDAO();
		u.setUserId(UI.ID);//冗余
		QueryApplyDAO QA=new QueryApplyDAO();
		record=QA.queryApply(u);
		if(record==null)
			return;
		for(int i=0;i<record.length;i++)
		{
			//System.out.println("applicant:"+record[i][0]);
		
		
			add(new MessagePanel(record[i][0]));
		}
	}

}
