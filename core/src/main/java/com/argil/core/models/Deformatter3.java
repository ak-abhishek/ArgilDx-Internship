package com.argil.core.models;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;




import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = { Resource.class })
public class Deformatter3 {
	 
	 @Inject @Optional
	   public Calendar name;
	 
	 
 
	 private Date d;
	 private Calendar c;
	 
	   public String getName() {
		return name.toString();
	}


	public void setName(Calendar name) {
		this.name = name;
		
		
	}
	
//	@PostConstruct
//	public void init() throws ParseException
//	{
//		SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YY");
//		String s=formatter.format(name.getTime());
//		
//		d=formatter.parse(s);
//		c = Calendar.getInstance();
//		c.setTime(d);
//	}
	
	public String dayOfTheWeek() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YY");
		//String s=formatter.format(name.getTime());
		
		formatter.setCalendar(name);
		String s=formatter.format(name.getTime());
		
		
		/*d=formatter.parse(s);
		c = Calendar.getInstance();
		c.setTime(d);
		c.getTime();*/
		//List<String> list =new ArrayList<String>();
		
		SimpleDateFormat dayFormatter = new SimpleDateFormat("EEEE");
		String day;
		dayFormatter.setCalendar(name);
		day=dayFormatter.format(name.getTime());
		
		/*int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		String[] arr= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};*/
		
		//return arr[dayOfWeek];
		return day;
		
	}
	
	public List<Date> nextSameDay() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YY");
		//String s=formatter.format(name.getTime());
		String s;
		formatter.setCalendar(name);
		s=formatter.format(name.getTime());
		
		
		List<Date> dates=new ArrayList<Date>();
		
		SimpleDateFormat formatt = new SimpleDateFormat("DD");
		formatter.setCalendar(name);
		//int x=Integer.parseInt(formatter.format(name.getTime()));
		//List<String> dates = new ArrayList();
		
		d=formatter.parse(s);
		
		for(int i=0;i<5;i++) {
			c.add(Integer.parseInt(d.toString()), 7);
			d = c.getTime();
			dates.add(d);
	
			}
		return dates;
}
}