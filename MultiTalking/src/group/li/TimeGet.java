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
	
	public static void main(String[] args)
	{
		
		System.out.println(TimeGet.time());
		
		
	}
}
