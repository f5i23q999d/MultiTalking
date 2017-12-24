package group.li;

import javax.swing.JFrame;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import group.lin.util.DBUtil;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class selectDest extends JFrame{
	
	ArrayList<JCheckBox> JB=new ArrayList<JCheckBox>();
	JCheckBox chckbxNewCheckBox;
	
	
	public selectDest() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				RaiseMission.dest.setText(" ");
	
					
					for(int i=0;i<JB.size();i++)
						if(JB.get(i).isSelected()==true)
						{
													
							RaiseMission.dest.setText(RaiseMission.dest.getText()+JB.get(i).getText()+" ");
						}
			
					dispose();
			}
		});
		
		btnNewButton.setBounds(200, 83, 93, 23);
		getContentPane().add(btnNewButton);
		
		
		//System.out.println("UI.CP.record.length:"+UI.CP.Frirecord.length);
		int i=0;
		//自己也加上

		
		for(i=1;i<=UI.CP.Frirecord.length;i++)
		{
					chckbxNewCheckBox = new JCheckBox(UI.CP.Frirecord[i-1][0]);
					chckbxNewCheckBox.setBounds(0, 25*i, 100, 25);
					JB.add(chckbxNewCheckBox);
					getContentPane().add(chckbxNewCheckBox);
					
		}
		
		
		
		
		
	}
}
