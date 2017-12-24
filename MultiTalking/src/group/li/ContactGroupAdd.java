package group.li;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactGroupAdd extends JFrame{
	private JTextField inputName;
	public ContactGroupAdd() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入分组名字");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(40, 25, 211, 41);
		getContentPane().add(label);
		
		inputName = new JTextField();
		inputName.setBounds(30, 99, 186, 41);
		getContentPane().add(inputName);
		inputName.setColumns(10);
		
		JButton toAdd = new JButton("添加");
		toAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreeNode node = (TreeNode) UI.CP.tree.getModel().getRoot();
				DefaultTreeModel tmp=(DefaultTreeModel)UI.CP.tree.getModel();
				tmp.insertNodeInto(new DefaultMutableTreeNode(inputName.getText()), (DefaultMutableTreeNode)node, node.getChildCount());
				//唯一添加子节点方法
				//for(int i=0;i<node.getChildCount();i++)
				//	System.out.println("text:"+inputName.getText()+"	name:"+node.getChildAt(i));
				//UI.panel.revalidate();
				//UI.panel.repaint();
			//	DefaultComboBoxModel CB=(DefaultComboBoxModel)UI.MOVE.getModel();
			//	CB.addElement(inputName.getText());
				
				UI.CP.revalidate();
				UI.CP.repaint();
				dispose();
			}
		});
		toAdd.setBounds(271, 108, 93, 23);
		getContentPane().add(toAdd);
	}
}
