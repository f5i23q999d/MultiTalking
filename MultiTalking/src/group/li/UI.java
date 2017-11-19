package group.li;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class UI extends JFrame{
	//存放每一项好友对话面板
	ArrayList<ListPanel> list=new ArrayList<ListPanel>();
	//当前页数
	int currentPage=1;
	//对话框或联系人所对应的面板
	JPanel panel;
	//左侧对话按钮
	JButton chatButton;
	//左侧联系人按钮
	JButton contactButton;
	//联系人面板
	static ContactPanel CP=new ContactPanel();
	//移动至。。
	static JComboBox MOVE;
	
	//聊天实现
	public static JPanel panel_2;
	
	
	
	//未每一个对话项实现选中效果
	public void addMouseListener(int i)
	{
		
		System.out.println("listener:"+i);
				list.get(i).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						for(int k=0;k<list.size();k++)
								list.get(k).setBackground(Color.white);
						
						list.get(i).setBackground(new Color(200, 200, 200));
						
					}
				});
		
		
	}
	
	public static void test(int k)
	{
		
		//pageSwitch(0);
		
		
	}
	
	//翻页效果
	public void pageSwitch(int k)
	{
		
		panel.removeAll();
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		currentPage+=k;
		int total=list.size();
		 if(list.size()-(currentPage-1)*10>10)
			 total=10+(currentPage-1)*10;
		 else
			 total=list.size();
		

		for(int i=(currentPage-1)*10;i<total;i++)
		{
			
			list.get(i).setName("好友"+i);
			list.get(i).setU(new ImageIcon(UI.class.getResource("/icon/"+i+".png")));
			panel.add(list.get(i));
			addMouseListener(i);
					}
		
		panel.revalidate();//必须有֤
		panel.repaint();
		
		
	}
	
	
	public UI() {
		
		
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(55, 0, 245, 500);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton lastPage = new JButton("\u4E0A\u4E00\u9875");
		lastPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pageSwitch(-1);
				
			}
		});
		lastPage.setBounds(55, 499, 68, 23);
		getContentPane().add(lastPage);
		
		JButton nextPage = new JButton("\u4E0B\u4E00\u9875");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pageSwitch(1);
				
			}
		});
		nextPage.setBounds(233, 499, 68, 23);
		getContentPane().add(nextPage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(0, 0, 55, 500);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		chatButton = new JButton("");
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contactButton.setIcon(new ImageIcon(UI.class.getResource("/tab/8.png")));
				chatButton.setIcon(new ImageIcon(UI.class.getResource("/tab/7.png")));
				pageSwitch(0);
				
			}
		});
		chatButton.setIcon(new ImageIcon(UI.class.getResource("/tab/7.png")));
		chatButton.setBounds(0, 80, 55, 55);
		panel_1.add(chatButton);
		
		contactButton = new JButton("");
		contactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contactButton.setIcon(new ImageIcon(UI.class.getResource("/tab/9.png")));
				chatButton.setIcon(new ImageIcon(UI.class.getResource("/tab/6.png")));

				
				panel.removeAll();
				panel.setLayout(null);
				panel.add(CP);
				
				panel.revalidate();//ˢ��ҳ�棬������֤
				panel.updateUI();
				panel.repaint();
				
				
			}
			
			
		});
	
		contactButton.setIcon(new ImageIcon(UI.class.getResource("/tab/8.png")));
		contactButton.setBounds(0, 145, 55, 55);
		panel_1.add(contactButton);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(UI.class.getResource("/tab/10.png")));
		button_1.setBounds(0, 435, 55, 55);
		panel_1.add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UI.class.getResource("/tab/11.png")));
		lblNewLabel.setBounds(0, 5, 55, 55);
		panel_1.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBounds(300, 0, 600, 500);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel teatLabel = new JLabel("\u6B63\u5728\u4E0E   \u5BF9\u8BDD");
		teatLabel.setFont(new Font("宋体", Font.PLAIN, 26));
		teatLabel.setBounds(112, 166, 186, 157);
		panel_2.add(teatLabel);
		
		JButton delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTreeModel tmp=(DefaultTreeModel)CP.tree.getModel();
				tmp.removeNodeFromParent((DefaultMutableTreeNode)CP.tree.getLastSelectedPathComponent());
		
			}
		});
		delButton.setBounds(128, 499, 68, 23);
		getContentPane().add(delButton);
		
		JLabel label = new JLabel("移动到：");
		label.setBounds(329, 503, 54, 15);
		getContentPane().add(label);
		
		
		
		TreeNode node = (TreeNode) CP.tree.getModel().getRoot();
		//node.getChildAt(i).toString()
		
		MOVE = new JComboBox();
		MOVE.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				
				if(arg0.getStateChange()==ItemEvent.SELECTED)
					
				{
				TreeNode node = (TreeNode) CP.tree.getModel().getRoot();
				DefaultTreeModel tmp=(DefaultTreeModel)CP.tree.getModel();
				
				int index=-1;
				for(int i=0;i<node.getChildCount();i++)
				{
					
					if(ContactPanel.tree.getLastSelectedPathComponent().toString().equals(node.getChildAt(i).toString()))
					{
						//如果选的是父节点就退出操作
						return;
						
					}
					
					
					if(node.getChildAt(i).toString().equals(MOVE.getSelectedItem().toString()))
							{
							index=i;
							
							//记录移动目的组的index
						
							
							}
					
				
					
				}
				DefaultMutableTreeNode getSelect=(DefaultMutableTreeNode)ContactPanel.tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode getTo=(DefaultMutableTreeNode)node.getChildAt(index);
				DefaultMutableTreeNode newNode=new DefaultMutableTreeNode(ContactPanel.tree.getLastSelectedPathComponent());
				
				System.out.println(getSelect);
				System.out.println(getTo);
				System.out.println(getTo.getChildCount());
				tmp.insertNodeInto(newNode, getTo,getTo.getChildCount());
				tmp.removeNodeFromParent((DefaultMutableTreeNode)CP.tree.getLastSelectedPathComponent());
				
				CP.tree.revalidate();
				//CP.tree.updateUI();  不能updateUI，不然失去对其效果
				
				CP.tree.repaint();
					
				}
				
				
			}
		});
		
		DefaultComboBoxModel CB=new DefaultComboBoxModel();
		for(int i=0;i<node.getChildCount();i++)
			CB.addElement(node.getChildAt(i).toString());
		MOVE.setModel(CB);
		MOVE.setBounds(375, 500, 94, 21);
		
		
		getContentPane().add(MOVE);

System.out.println(CP.tree.getRowCount());
	
		
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		
		
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		
		
		list.add(new ListPanel());
		list.add(new ListPanel());
		list.add(new ListPanel());
		int total;
		
		
 if(list.size()>10)
	 total=10;
 else
	 total=list.size();
		
		for(int i=0;i<total;i++)
		{
			list.get(i).setName("好友"+i);
			list.get(i).setU(new ImageIcon(UI.class.getResource("/icon/"+i+".png")));
			panel.add(list.get(i));
			addMouseListener(i);
		//	System.out.println(list.get(i));

		}

	
		
		
		
}
	
	
	
	
	
	public static void main(String[] args) {
		UI T2=new UI();
		T2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		T2.setSize(970,550);
		T2.setVisible(true);

	}
}
