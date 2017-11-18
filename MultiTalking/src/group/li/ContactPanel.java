package group.li;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ContactPanel extends JScrollPane{
	
	JScrollPane scrollPane;
	static JTree tree= new JTree();
	
	
	public ContactPanel()
	{
	super(tree);
	
	
	tree.setModel(new DefaultTreeModel(
		new DefaultMutableTreeNode("JTree") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("阿三");
					node_1.add(new DefaultMutableTreeNode("去"));
					node_1.add(new DefaultMutableTreeNode("我"));
					node_1.add(new DefaultMutableTreeNode("额"));
					node_1.add(new DefaultMutableTreeNode("吖"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("下");
					node_1.add(new DefaultMutableTreeNode("个"));
					node_1.add(new DefaultMutableTreeNode("亲"));
					node_1.add(new DefaultMutableTreeNode("和"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("盘");
					node_1.add(new DefaultMutableTreeNode("要"));
					node_1.add(new DefaultMutableTreeNode("呃"));
					node_1.add(new DefaultMutableTreeNode("从"));
					node_1.add(new DefaultMutableTreeNode("为"));
				add(node_1);
			}
		}
	));
	
	this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	this.setBounds(0, 0, 245, 500);
	tree.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){
		
		if(e.getClickCount()==2)
		{
			
			Object obj=UI.panel_2.getComponent(0);
			JLabel a=(JLabel)obj;
			
			a.setText("正在与"+tree.getLastSelectedPathComponent().toString()+"对话");
			
			
		}
		
		
	}});
	tree.setRootVisible(false);
	tree.setRowHeight(50);
	tree.setCellRenderer(new JTreeRender());
	tree.setUI(new JTreeUI());
	tree.putClientProperty("JTree.lineStyle", "None");
	tree.setBounds(0, 0, 245, 500);
	tree.expandRow(0);
	tree.repaint();
	
	}
	
	
	
}
