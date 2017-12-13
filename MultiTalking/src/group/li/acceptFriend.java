package group.li;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.tree.TreeNode;

import group.lin.util.DBUtil;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class acceptFriend extends JFrame{
	public acceptFriend(String dest) {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("选择分组");
		lblNewLabel.setBounds(29, 33, 54, 15);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		TreeNode node = (TreeNode)UI.CP.tree.getModel().getRoot();
		DefaultComboBoxModel CB=new DefaultComboBoxModel();
		for(int i=0;i<node.getChildCount();i++)
			CB.addElement(node.getChildAt(i).toString());
		comboBox.setModel(CB);
		comboBox.setBounds(93, 23, 139, 35);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBUtil db=DBUtil.getDBUtil();
				String sql="insert into CONTACT values (?,?,1,?)";
				Object[] obj = {UI.ID,dest,comboBox.getSelectedItem().toString()};
				db.executeUpdate(sql, obj);
				System.out.println("已同意"+UI.ID+" "+dest+" "+comboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"已同意好友申请!");
				
				MessagePanel.btnNewButton.setText("已同意");
				MessagePanel.btnNewButton.setEnabled(false);
				dispose();
				
				//好友
				UI.thread.SendAMessage(dest, "*");
				
				UI.CP=new ContactPanel(UI.ID);//刷新好友面板
				/*BUG 不能立即刷新
				UI.CP.revalidate();
				UI.CP.repaint();
				UI.CP.tree.revalidate();
				UI.CP.tree.repaint();
				*/
				
			}
		});
		btnNewButton.setBounds(259, 29, 93, 23);
		getContentPane().add(btnNewButton);
	}
}
