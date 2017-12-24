package group.li;

import javax.swing.JFrame;
import javax.swing.JPanel;

import group.lin.util.DBUtil;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class consentFinish extends JPanel{
	
	
//	result[j][0] = cr.getSender();
//	result[j][1] = cr.getReceiver();
//	result[j][2] = cr.getTitle();
//	result[j][3] = String.valueOf(cr.getConsent());	
	
	public consentFinish(String []X) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("申请完成任务：");
		lblNewLabel.setBounds(68, 9, 101, 36);
		add(lblNewLabel);
		
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("同意");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBUtil db=DBUtil.getDBUtil();
				String sql="update TaskConfirm set consent=1 where Sender=? and Title=?";
				Object[] obj = {X[0],X[2]};
				db.executeUpdate(sql, obj);
			
				sql="update Task set State=1 where Receiver=? and Title=?";
				Object[] obj2 = {X[0],X[2]};
				db.executeUpdate(sql, obj2);
				
				//JOptionPane.showMessageDialog(null,"已同意");
				btnNewButton.setText("已同意");
				btnNewButton.setEnabled(false);
				
			}
		});
		btnNewButton.setBounds(267, 14, 100, 26);
		add(btnNewButton);
		
		

		String tmp=X[3];
		if(tmp.equals("0"))
		{
			tmp="同意";
			btnNewButton.setText(tmp);
		}
		else
		{
			
			tmp="已同意";
			btnNewButton.setText(tmp);
			btnNewButton.setEnabled(false);
		}
		
		
		JLabel whoapply = new JLabel(X[0]);
		whoapply.setBounds(8, 16, 46, 21);
		add(whoapply);
		
		JLabel taskTitle = new JLabel(X[2]);
		taskTitle.setBounds(169, 20, 54, 15);
		add(taskTitle);
	}
	

}
