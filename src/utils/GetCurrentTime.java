package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetCurrentTime {
	
	public static String getTime(){
		Calendar c=java.util.Calendar.getInstance();    //yyyy年MM月dd日hh时mm分ss秒
	    SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd");
	    String time=f.format(c.getTime());
	    
	    return time;
		
	}
	
	public static void main(String[] args) {
		System.out.println(GetCurrentTime.getTime());
	}

}
