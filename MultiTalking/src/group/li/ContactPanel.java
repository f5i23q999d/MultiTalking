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
	
	JScrollPane scrollPane;//创建滚动条方便同一panel内显示
	static JTree tree= new JTree();//好友列表
	
	
	public ContactPanel()
	{
		
	super(tree);//tree作为形参调入滚动条中，组合
	
	
	tree.setModel(new DefaultTreeModel(
		new DefaultMutableTreeNode("JTree") {
			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("123");
					node_1.add(new DefaultMutableTreeNode("456"));
					node_1.add(new DefaultMutableTreeNode("789"));
					node_1.add(new DefaultMutableTreeNode("aɫ"));
					node_1.add(new DefaultMutableTreeNode("b"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("阿斯顿");
					node_1.add(new DefaultMutableTreeNode("阿斯达"));
					node_1.add(new DefaultMutableTreeNode("青蛙大全"));
					node_1.add(new DefaultMutableTreeNode("从VS"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("怕");
					node_1.add(new DefaultMutableTreeNode("ASCA"));
					node_1.add(new DefaultMutableTreeNode("D133"));
					node_1.add(new DefaultMutableTreeNode("啊手动阀"));
					node_1.add(new DefaultMutableTreeNode("㽶"));
				add(node_1);
			}
		}
	));
	
	this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	this.setBounds(0, 0, 245, 500);
	tree.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){
		
		if(e.getClickCount()==2)//鼠标点击两下
		{
			
			Object obj=UI.panel_2.getComponent(0);
			JLabel a=(JLabel)obj;
			
			a.setText("正在和"+tree.getLastSelectedPathComponent().toString()+"对话");			
			
		}
		
		
	}});
	tree.setRootVisible(false);//最根部不可视
	tree.setRowHeight(50);//设置距离
	tree.setCellRenderer(new JTreeRender());//重写渲染类
	tree.setUI(new JTreeUI());//重写UI类
	tree.putClientProperty("JTree.lineStyle", "None");//消除左边竖线
	tree.setBounds(0, 0, 245, 500);
	tree.expandRow(0);//默认展开第一个好友列表
	tree.repaint();
	
	}
	
	
	
}
