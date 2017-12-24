package group.linzx.AttendanceSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import group.li.TimeGet;
import group.li.UI;
import group.lin.util.DBUtil;

public class PermanentCalendar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5939002611918837793L;
	private JPanel contentPane;
	private JTable table;
	private JLabel currentMonthLabel;
	private Calendar calendar = new GregorianCalendar();
	static String day="$";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PermanentCalendar frame = new PermanentCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PermanentCalendar() {
		setTitle("打卡考勤");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel YMPanel = new JPanel();
		contentPane.add(YMPanel, BorderLayout.NORTH);
		YMPanel.setLayout(new GridLayout(1, 3, 5, 10));

		JPanel lastMonthPanel = new JPanel();
		YMPanel.add(lastMonthPanel);

		JButton lastMonthButton = new JButton("\u4E0A\u4E2A\u6708");
		lastMonthButton.setHorizontalAlignment(SwingConstants.RIGHT);
		lastMonthButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lastMonthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_lastMonthButton_actionPerformed(e);
			}
		});
		lastMonthPanel.add(lastMonthButton);

		JPanel currentMonthPanel = new JPanel();
		YMPanel.add(currentMonthPanel);
		currentMonthPanel.setLayout(new BoxLayout(currentMonthPanel, BoxLayout.X_AXIS));

		currentMonthLabel = new JLabel("");
		currentMonthLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		currentMonthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentMonthPanel.add(currentMonthLabel);

		JPanel nextMonthPanel = new JPanel();
		YMPanel.add(nextMonthPanel);

		JButton nextMonthButton = new JButton("\u4E0B\u4E2A\u6708");
		nextMonthButton.setHorizontalAlignment(SwingConstants.LEFT);
		nextMonthButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		nextMonthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_nextMonthButton_actionPerformed(e);
			}
		});
		nextMonthPanel.add(nextMonthButton);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 20));
		table.setRowHeight(25);
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(table);

		currentMonthLabel.setText(updateLabel(0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton checkbutton = new JButton("今日签到");
		checkbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(TimeGet.dayTime().substring(2, 4));
				
				day=TimeGet.dayTime().substring(2, 4);
				
				for(int i=0;i<table.getRowCount();i++)
					for(int j=0;j<table.getColumnCount();j++)
						//System.out.println(table.getModel().getValueAt(i, j));
						
						if(table.getModel().getValueAt(i, j)!=null)
						{
						//	System.out.println("找到，"+i+"  "+j+"table.getModel().getValueAt(i, j):"+table.getModel().getValueAt(i, j)+"  TimeGet.dayTime().substring(2, 4):"+TimeGet.dayTime().substring(2, 4));
							if(table.getModel().getValueAt(i, j).toString().equals(TimeGet.dayTime().substring(2, 4)))
							{
								table.getModel().setValueAt(table.getModel().getValueAt(i, j)+" √",i,j);
								DBUtil db=DBUtil.getDBUtil();
								String sql="insert into 12CheckIn values (?,?)";
								Object[] obj = {UI.ID,TimeGet.dayTime().substring(2, 4)};
								db.executeUpdate(sql, obj);
								//System.out.println("已申请"+UI.ID+" "+dest+" "+comboBox.getSelectedItem().toString());
								
							}
				
						}


			}
		});
		checkbutton.setFont(new Font("微软雅黑", Font.BOLD, 21));
		panel.add(checkbutton);
		updateTable(calendar);
		
		
		//获取之前的打卡数据
		DBUtil db=DBUtil.getDBUtil();
		String sql="select day from 12CheckIn where user=?";
		Object[] obj = {UI.ID};
		ResultSet rs=db.executeQuery(sql, obj);
		try {
			while(rs.next())
			{
				String d=rs.getString("day");
				for(int i=0;i<table.getRowCount();i++)
					for(int j=0;j<table.getColumnCount();j++)
						//System.out.println(table.getModel().getValueAt(i, j));
						
						if(table.getModel().getValueAt(i, j)!=null)
						{
						
							if(table.getModel().getValueAt(i, j).toString().equals(d))
							{
								table.getModel().setValueAt(table.getModel().getValueAt(i, j)+" √",i,j);
							
							}
				
						}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void updateTable(Calendar calendar) {
		/*
		 * 获得表示星期的字符串数组，新建一个数组来保存截取后的字符串 weeks数组第一个元素是空字符串，因此从1开始循环， 获得字符串的最后一个字符
		 */
		String[] weeks = new DateFormatSymbols().getShortWeekdays();
		String[] realWeeks = new String[7];
		for (int i = 1; i < weeks.length; i++) {
			realWeeks[i - 1] = weeks[i].substring(2, 3);
		}

		int today = calendar.get(Calendar.DATE);// 获得当前日期
		int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 获得当前月的天数
		calendar.set(Calendar.DAY_OF_MONTH, 1); // 将时间设置为本月第一天
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);// 获得本月第一天是星期几
		int firstDay = calendar.getFirstDayOfWeek(); // 获得当前地区星期的起始日
		int whiteDay = weekday - firstDay; // 这个月第一个星期有几天被上个月占用
		Object[][] days = new Object[6][7];// 新建一个二维数组来保存当前月的各天
		for (int i = 1; i <= monthDays; i++) {// 遍历当前月的所有天并将其添加的二维数组中
			days[(i - 1 + whiteDay) / 7][(i - 1 + whiteDay) % 7] = i;
		} // 数组的第一维表示一个月中各个星期，第二位表示一个星期中各个天
		DefaultTableModel model = (DefaultTableModel) table.getModel();// 获得当前表格的模型
		model.setDataVector(days, realWeeks);// 给表格模型设置表头和表体
		table.setModel(model);// 更新表格模型
		/*
		 * 
		 */
		/*
		 * table.setCellSelectionEnabled(true);//设置表格单元格可选择 *****
		 * table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//*****
		 * table.setDefaultRenderer(table.getColumnClass(0),new TableCellRenderer(){
		 * public Component getTableCellRendererComponent(JTable table, Object
		 * value,boolean isSelected, boolean hasFocus,int row,int column) { String
		 * text=(value==null)?"":value.toString(); JLabel cell=new JLabel(text);
		 * cell.setOpaque(true);//绘制边界内的所有像素if(row==0){//第一行显示星期，设置为星期的前景色和背景
		 * if(row==0){//第一行显示星期，设置为星期的前景色和背景色
		 * cell.setForeground(headerForeground);cell.setBackground(headerBackground);}
		 * else{ if(isSelected){//日期单元格如果选中，则设置为日期选 中的前、背景色
		 * cell.setForeground(selectedForeground);cell.setBackground(selectedBackground)
		 * ;} else { cell.setForeground(foreground);cell.setBackground(background);} }
		 * return cell; } }); updateView();
		 */
	
		/*
		 * table.setDefaultRenderer(Object.class,new
		 * myTableCellRenderer(3,6,Color.yellow));//
		 * table.setDefaultRenderer(Object.class,new
		 * myTableCellRenderer(4,0,Color.blue));//
		 */
	//	table.setRowSelectionInterval(0, (today - 1 + whiteDay) / 7);// 设置选择的行
	//	table.setColumnSelectionInterval(0, (today - 1 + whiteDay) % 7);// 设置选择的列
		table.setDefaultRenderer(Object.class, new EvenOddRenderer());

		/*
		 * TableColumn tableColumn = table.getColumn("一"); DefaultTableCellRenderer
		 * backGroundColor = new DefaultTableCellRenderer();
		 * //DefaultTableCellRenderer类可以绘制单元格的背景、字体颜色等功能
		 * backGroundColor.setBackground(Color.yellow); //绘制类别列的背景为黄色
		 * tableColumn.setCellRenderer(backGroundColor);
		 */
	}

	private String updateLabel(int increment) {
		calendar.add(Calendar.MONTH, increment);// 将当前月份增加increment月
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");// 设置字符串格式
		return formatter.format(calendar.getTime());// 获得指定格式的字符串
	}

	protected void do_lastMonthButton_actionPerformed(ActionEvent e) {
		currentMonthLabel.setText(updateLabel(-1));
		updateTable(calendar);
	}

	protected void do_nextMonthButton_actionPerformed(ActionEvent e) {
		currentMonthLabel.setText(updateLabel(1));
		updateTable(calendar);
	}
}

class EvenOddRenderer implements TableCellRenderer {

	public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);
		Color foreground, background;
		
		
		if(isSelected)
			renderer.setBackground(Color.BLACK);
		else
			renderer.setBackground(Color.WHITE);
		
		
		
	
/*
 * row=0~5(6)  column=0~6(7)
 */
		/*int[][] record=new int[6][7];
		record[3][4]=1;
		System.out.println(record[3][4]);
		for(int i=0;i<6;i++ ) {
			for(int j=0;j<7;j++) {
				if(record[i][j]==1) {
					row =i; column =j;
					foreground = Color.red;
					background = Color.BLUE;
				}else {
					row =i; column =j;
					foreground = Color.BLACK;
					background = Color.WHITE;
				}
				
			}
		}*/
		
	/*
		if (row ==4 && column == 4) {
			foreground = Color.red;
			background = Color.BLUE;
		} else if (row == 4 && column == 3) {
			foreground = Color.red;
			background = Color.BLUE;
		} else {
			foreground = Color.BLACK;
			background = Color.WHITE;
		}
		renderer.setForeground(foreground);
		renderer.setBackground(background);
		*/
		return renderer;
	}
}

class myTableCellRenderer implements TableCellRenderer {
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	int row, column;
	Color c;

	public myTableCellRenderer(int row, int column, Color c) {
		this.row = row;
		this.column = column;
		this.c = c;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component renderer = dtcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (row == this.row && column == this.column) {
			renderer.setBackground(c);
		}
		return renderer;
	}
}