package group.li;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import group.lin.dao.ContactListDAO;
import group.lin.dao.GroupsInfoDAO;
import group.lin.entity.UserDAO;
import group.lin.util.DBUtil;


public class ContactPanel extends JScrollPane{
	
	JScrollPane scrollPane;//创建滚动条方便同一panel内显示
	static JTree tree= new JTree();//好友列表
	static String selectedID;
	static int number;
	String ID;
	public static String Frirecord[][];
	public static String Grprecord[][];
	
	public ContactPanel(String ID)
	{
		
	super(tree);//tree作为形参调入滚动条中，组合
	this.ID=ID;
	
	tree.setModel(new DefaultTreeModel(
		new DefaultMutableTreeNode("JTree") {
			{
				
				
				UserDAO t=new UserDAO();
				//System.out.println(ID);
				t.setUserId(ID);
				ContactListDAO r=new ContactListDAO();
				//先从数据库中查找好友信息并且存入record中，其中每项里，[0]值接受方，[1]值对应组名
				Frirecord=r.queryForContactList(t);
				
				
				DefaultMutableTreeNode node_1;
			if(Frirecord!=null)//防止新用户会报错
			{
				number=Frirecord.length;
				for(int i=0;i<Frirecord.length;i++)
				{
					//System.out.println("receiver:"+record[i][0]+"  i="+i);
					boolean exist=false;
					int num=0;
					for(int j=0;j<this.getRoot().getChildCount();j++)
						if(Frirecord[i][1].equals(this.getRoot().getChildAt(j).toString()))
							{
							
							exist=true;
							num=j;
							//寻找是否有相同分组并且记录下其对应的位置
							}
					
					if(!exist)
					{
					node_1=new DefaultMutableTreeNode(Frirecord[i][1]);
					node_1.add(new DefaultMutableTreeNode(Frirecord[i][0]));
					add(node_1);
					//不存在相同分组时先新建组名，再插入好友
					}
					else
					{
					DefaultTreeModel tmp=new DefaultTreeModel(this.getRoot().getChildAt(num));
					
					tmp.insertNodeInto(new DefaultMutableTreeNode(Frirecord[i][0]), (DefaultMutableTreeNode)this.getRoot().getChildAt(num), this.getRoot().getChildAt(num).getChildCount());
					//存在相同分组时，先定位其位置，再插入好友
					}
				}
				
				node_1=new DefaultMutableTreeNode("群组");
				add(node_1);
			}
			else
			{
				//避免没有好友分组的情况下不能添加好友分组，存在BUG
				node_1=new DefaultMutableTreeNode("我的好友");
				add(node_1);
				node_1=new DefaultMutableTreeNode("群组");
				add(node_1);
				
			}
			
			
			
			GroupsInfoDAO r1=new GroupsInfoDAO();
			
			Grprecord=r1.queryForGroup(t);
			if(Grprecord!=null)
			{
			number=Grprecord.length;
			
			for(int i=0;i<Grprecord.length;i++)
			{
				
				int num=0;
				for(int j=0;j<this.getRoot().getChildCount();j++)
					if(this.getRoot().getChildAt(j).toString().equals("群组"))
						num=j;
					
				DefaultTreeModel tmp=new DefaultTreeModel(this.getRoot().getChildAt(num));
				
				tmp.insertNodeInto(new DefaultMutableTreeNode(Grprecord[i][1]), (DefaultMutableTreeNode)this.getRoot().getChildAt(num), this.getRoot().getChildAt(num).getChildCount());
			
			}
		
			}
			
			
				/*
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
				*/
			}
		}
	));
	
	this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	this.setBounds(0, 0, 245, 500);
	tree.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e){
		 DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();  
		if(e.getClickCount()==2&&node.getLevel()==2)//鼠标点击两下并且是子节点
		{
			
			//Object obj=UI.panel_2.getComponent(0);
			//JLabel a=(JLabel)obj;
			
			selectedID=tree.getLastSelectedPathComponent().toString();
			
			//检查是否存在，添加两次
			boolean exist=false;
			for(int i=0;i<UI.list.size();i++)
				if(tree.getLastSelectedPathComponent().toString().equals(UI.list.get(i).name))
					exist=true;
		
			if(!exist)
			{
			UI.list.add(new ListPanel(tree.getLastSelectedPathComponent().toString()));
			
				
					//UI.chatSwitch(UI.list.get(i).ulabel);
					
	
				
			
			}
			
			
			//是否为群组，是否有显示成员
			TreeNode tn=(TreeNode)tree.getLastSelectedPathComponent();
			if(tn.getParent().toString().equals("群组"))
				UI.panel_2.showButton.setVisible(true);
			else
				UI.panel_2.showButton.setVisible(false);
			
			UI.panel_2.nameTitle.setText(tree.getLastSelectedPathComponent().toString());
			
			
			//下面这段为新建对话内容
			boolean exist2=false;
			int n = 0;
			for(int i=0;i<UI.panel_2.list.size();i++)
				if(UI.panel_2.list.get(i).ID.equals(tree.getLastSelectedPathComponent().toString()))
					{exist2=true;n=i;}
			
			if(!exist2)
			{
				
				UI.panel_2.list.add(new IDTextPane(tree.getLastSelectedPathComponent().toString()));
				UI.panel_2.textPane.setText("");
			}
			else			
				UI.panel_2.textPane.setText(UI.panel_2.list.get(n).getText());
				//UI.panel_2.textPane.setDocument(UI.panel_2.list.get(n).getDocument());
			
			//UI.panel_2.textPane.add(UI.panel_2.list.get(n));
			
			UI.panel_2.textPane.revalidate();
			UI.panel_2.textPane.repaint();
			
			/*
			for(int i=0;i<UI.panel_2.list.size();i++)
				try {
					System.out.println("listID："+UI.panel_2.list.get(i).getDocument().getText(0, UI.panel_2.list.get(i).getDocument().getLength()));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			*/
			
			
			
			
			UI.panel_2.setVisible(true);
			
			UI.pageSwitch(0);//切换页面并刷新
			UI.contactButton.setIcon(new ImageIcon(UI.class.getResource("/tab/8.png")));//调整按钮样式
			UI.chatButton.setIcon(new ImageIcon(UI.class.getResource("/tab/7.png")));//调整按钮样式
			
			for(int i=0;i<UI.list.size();i++)
				if(tree.getLastSelectedPathComponent().toString().equals(UI.list.get(i).name))
					UI.list.get(i).setBackground(new Color(200,200,200));
				else
					UI.list.get(i).setBackground(new Color(228,228,228));
			//切换背景色		
	
			//a.setText("正在和"+tree.getLastSelectedPathComponent().toString()+"对话");			
			
			
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
