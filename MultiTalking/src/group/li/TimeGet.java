package group.li;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGet {
	static public String time()
	{
	Date date=new Date();
	DateFormat format=new SimpleDateFormat("HH:mm");
	String time=format.format(date);
	return time;
	}
	
	static public String FullTime()
	{
	Date date=new Date();
	String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);

	return dateStr;
	}
	
	static public String dayTime()
	{
	Date date=new Date();
	String dateStr = new SimpleDateFormat("MMdd").format(date);

	return dateStr;
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(TimeGet.time());
		
		
	}
}
