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

import group.li.thread.ChatClient;

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
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;

public class UI extends JFrame{
	//存放每一项好友对话面板
	static public ArrayList<ListPanel> list=new ArrayList<ListPanel>();
	//当前页数
	static int currentPage=1;
	//对话框或联系人所对应的面板
	static public JPanel panel;
	//左侧对话按钮
	static JButton chatButton;
	//左侧联系人按钮
	static JButton contactButton;
	//联系人面板
	public static ContactPanel CP;
	//移动至。。
	static JComboBox MOVE;
	
	//聊天实现
	static public ChatPanel panel_2;
	
	//设置
	static SettingPanel SP=new SettingPanel();
	
	//保存当前账号ID
	public static String ID;
	
	static JLabel label;
	static ChatClient thread;
	
	//为每一个对话项实现选中效果
	public static void addMouseListener(int i)
	{
		
		//System.out.println("listener:"+i);
				list.get(i).addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						for(int k=0;k<list.size();k++)
								list.get(k).setBackground(new Color(228,228,228));
						
						list.get(i).setBackground(new Color(200, 200, 200));
						
						//System.out.println(list.get(i).namelabel.getText());
						boolean exist2=false;
						int n = 0;
						int ii=0;
						for(ii=0;ii<UI.panel_2.list.size();ii++)
						{
							//System.err.println("UI.panel_2.list.get(ii).ID:"+UI.panel_2.list.get(ii).ID+"   list.get(i).namelabel.getText()"+list.get(i).namelabel.getText());
							if(UI.panel_2.list.get(ii).ID.equals(list.get(i).namelabel.getText()))
								{exist2=true;n=ii;}
						}
						UI.panel_2.nameTitle.setText(list.get(i).namelabel.getText());
						//UI.panel_2.textPane.setDocument(UI.panel_2.list.get(n).getDocument().);
						//System.out.println(UI.panel_2.list.get(n).getText());
						
						
						UI.panel_2.textPane.setText(UI.panel_2.list.get(n).getText());
						UI.panel_2.setVisible(true);
						UI.panel_2.textPane.revalidate();
						UI.panel_2.textPane.repaint();
						
						//是否为群组，是否有显示成员
					
						boolean belong=false;
					if(UI.CP.Grprecord!=null)
					{
					for(int p=0;p<UI.CP.Grprecord.length;p++)
						if(UI.CP.Grprecord[p][1].equals(list.get(i).namelabel.getText()))
							{
							System.out.println("i="+p+"      UI.CP.Grprecord[i][1]:"+UI.CP.Grprecord[p][1]);
							UI.panel_2.showButton.setVisible(true);belong=true;
							}
					
					if(belong==false)
						UI.panel_2.showButton.setVisible(false);
					
					}
						
						
					//	UI.panel_2.nameTitle.setText(UI.CP.tree.getLastSelectedPathComponent().toString());
					UI.panel_2.nameTitle.setText(list.get(i).namelabel.getText());
						
						
					}
				});
		
		
	}
	
	public static int computePage()
	{
		
		return list.size()/10+1;
		
			
		
	}
	
	//翻页效果
	static public void pageSwitch(int k)
	{
		
		
		
		
		
		
		panel.removeAll();
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		panel.setBackground(new Color(228,228,228));//这里修改第二面板的背景色
		currentPage+=k;
		int total=list.size();
		 if(list.size()-(currentPage-1)*10>10)
			 total=10+(currentPage-1)*10;
		 else
			 total=list.size();
		

		for(int i=(currentPage-1)*10;i<total;i++)
		{
			
			//list.get(i).setName("好友"+i);
			list.get(i).setU(new ImageIcon(UI.class.getResource("/icon/"+i+".png")));
			panel.add(list.get(i));
			addMouseListener(i);
					}
		
		panel.revalidate();//必须有֤
		panel.repaint();
		
		
	}
	
	//聊天框切换
	static public void chatSwitch(JLabel jp)
	{
		panel_2.setBackground(new Color(25,25,25));
		
		
	}
	
	
	
	
	public UI(String ID) {
		
		
		UI.ID=ID;//记录ID
	
		
		CP=new ContactPanel(ID);
		//System.out.println("用户"+UI.ID+"登陆");
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(55, 0, 245, 500);
		
		getContentPane().add(panel);

		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton lastPage = new JButton("<<");
		lastPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPage==1)
						return;
				
				
				pageSwitch(-1);
				
			}
		});
		lastPage.setBounds(55, 499, 45, 23);
		getContentPane().add(lastPage);
		
		JButton nextPage = new JButton(">>");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPage>=computePage())				
					return;
			
				pageSwitch(1);
				
			}
		});
		nextPage.setBounds(256, 499, 45, 23);
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
				panel_2.setVisible(false);

				
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
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SP.setSize(200, 200);
				//SP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				SP.setLocale(null);
				SP.setVisible(true);
				
				
				
			}
		});
		button_1.setIcon(new ImageIcon(UI.class.getResource("/tab/10.png")));
		button_1.setBounds(0, 435, 55, 55);
		panel_1.add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UI.class.getResource("/tab/11.png")));
		lblNewLabel.setBounds(0, 5, 55, 55);
		panel_1.add(lblNewLabel);
		
		//panel_2 = new ChatPanel();
		//panel_2.setBounds(300, 0, 550, 500);
		
		panel_2=new ChatPanel(this.ID);
		
		panel_2.setBounds(300, 0, 550, 500);
		panel_2.setVisible(false);
		getContentPane().add(panel_2);
		
		
		
		JButton delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTreeModel tmp=(DefaultTreeModel)CP.tree.getModel();
				tmp.removeNodeFromParent((DefaultMutableTreeNode)CP.tree.getLastSelectedPathComponent());
		
			}
		});
		delButton.setBounds(178, 499, 81, 23);
		getContentPane().add(delButton);
		
		label = new JLabel("移动到：");
		label.setBounds(329, 503, 54, 15);
		getContentPane().add(label);
		
		
		
		
		CP.tree.setBackground(new Color(228,228,228));
		TreeNode node = (TreeNode)CP.tree.getModel().getRoot();
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
		
		JButton addContactGroupbutton = new JButton("添加分组");
		addContactGroupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactGroupAdd fa=new ContactGroupAdd();
				fa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				fa.setSize(500, 300);
				fa.setLocale(null);
				fa.setVisible(true);
				
			}
		});
		addContactGroupbutton.setBounds(97, 499, 81, 23);
		getContentPane().add(addContactGroupbutton);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i=0;i<UI.panel_2.list.size();i++)
						System.out.println("ID:"+UI.panel_2.list.get(i).ID+"    content:" +UI.panel_2.list.get(i).getText());
					
					
					
				
				
				
				
			}
		});
		btnNewButton.setBounds(495, 499, 93, 23);
		getContentPane().add(btnNewButton);

		//System.out.println(CP.tree.getRowCount());
	
		/*
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
		*/
		
		
		
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

	
		
		pageSwitch(0);//使panel显形
		
		thread=new ChatClient();
		try {
			thread.main(null);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
	
	
	
	
	
	public static void main(String[] args) {
		UI T2=new UI("Kiux");
		T2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		T2.setSize(970,550);
		T2.setVisible(true);

	}
}
