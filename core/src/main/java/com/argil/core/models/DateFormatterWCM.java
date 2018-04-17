package com.argil.core.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.adobe.cq.sightly.WCMUsePojo;

public class DateFormatterWCM extends WCMUsePojo {

	private String userDate;
	
	@Override
	public void activate() throws Exception 
	{
		// TODO Auto-generated method stub
		Resource resource=getResource();
		 Node node = resource.adaptTo(Node.class);
	       Calendar calendar = node.getProperty("name").getValue().getDate();
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	       simpleDateFormat.setCalendar(calendar);
	       userDate = simpleDateFormat.format(calendar.getTime());
	}
	
	public String getDate()
	{
		return userDate;
	}
//	@Self
//	private Resource resource;
//	   
//	public String value;
//    public Calendar c;
//    
//    @PostConstruct
//	public String getDate() throws ValueFormatException, IllegalStateException, PathNotFoundException, RepositoryException {
//	       Node map = resource.adaptTo(Node.class);
//	       c=(Calendar) map.getProperty("name").getValue();
//	        return map.getProperty("name").getValue().toString();
//	   }
//	 
//    public String dayOfTheWeek() throws ParseException {
//			Date d;
//			
//			//List<String> list =new ArrayList<String>();
//			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YY");
//			String s=formatter.format(c.getTime());
//			
//			d=formatter.parse(s);
//			Calendar c = Calendar.getInstance();
//			c.setTime(d);
//			
//			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//
//			String[] arr= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
//			
//			return arr[dayOfWeek];
//			
//		}
//		
//		public List<Date> nextSameDay() throws ParseException {
//			SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/YY");
//			String s=formatter.format(c.getTime());
//			
//			Date d=formatter.parse(s);
//			Calendar c = Calendar.getInstance();
//			c.setTime(d);
//			c.add(Calendar.DATE, 7);
//			List<Date> dates=new ArrayList<Date>();
//			
//			//List<String> dates = new ArrayList();
//			
//			for(int i=0;i<5;i++) {
//				c.add(Calendar.DATE, 7);
//				d = c.getTime();
//				dates.add(d);
//		
//		}
//			return dates;
	}
	 

	 
	   


