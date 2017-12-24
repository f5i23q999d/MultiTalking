package group.li;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import group.lin.util.DBUtil;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mission extends JFrame{
	
	
	String []X;
	
	public Mission(String []X) {
		
		
//		result[j][0] = cr.getSender();
//		result[j][1] = cr.getReceiver();
//		result[j][2] = cr.getTime();
//		result[j][3] = cr.getContext();
//		result[j][4] = cr.getAttachment();
//		result[j][5] = cr.getTitle();
//		result[j][6] = String.valueOf(cr.getState());	
		this.X=X;
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("发送人：");
		label.setBounds(32, 62, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("接收人：");
		label_1.setBounds(32, 87, 54, 15);
		getContentPane().add(label_1);
		
		JLabel Sender = new JLabel(X[0]);
		Sender.setBounds(84, 62, 54, 15);
		getContentPane().add(Sender);
		
		JLabel Receiver = new JLabel(X[1]);
		Receiver.setBounds(84, 87, 54, 15);
		getContentPane().add(Receiver);
		
		JLabel lblNewLabel_1 = new JLabel("任务概述：");
		lblNewLabel_1.setBounds(32, 126, 65, 15);
		getContentPane().add(lblNewLabel_1);
		
		JTextPane txtpnSdasdasd = new JTextPane();
		txtpnSdasdasd.setText(X[3]);
		JScrollPane scrollBar = new JScrollPane(txtpnSdasdasd);
		scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollBar.setBounds(32, 172, 328, 197);
		getContentPane().add(scrollBar);
		System.err.println(X[3]);
		
		JLabel label_2 = new JLabel("附件：");
		label_2.setBounds(32, 379, 65, 15);
		getContentPane().add(label_2);
		
		JButton btnNewButton = new JButton("关闭");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.setBounds(400, 410, 109, 54);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("上传回复附件");
		btnNewButton_1.setBounds(384, 62, 125, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查看已上传附件");
		btnNewButton_2.setBounds(384, 122, 125, 39);
		getContentPane().add(btnNewButton_2);
		
		JButton applyComplete = new JButton("申请完成");
		applyComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBUtil db=DBUtil.getDBUtil();
				String sql="insert into TaskConfirm values (null,?,?,?,?)";
				Object[] obj = {X[1],X[0],X[5],0};
				db.executeUpdate(sql, obj);
				JOptionPane.showMessageDialog(null,"已发送申请!");
				
			}
		});
		applyComplete.setBounds(384, 194, 125, 45);
		getContentPane().add(applyComplete);
		
		
	
	}
}
