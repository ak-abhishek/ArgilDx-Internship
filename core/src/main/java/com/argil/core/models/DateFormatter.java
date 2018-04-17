package com.argil.core.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.social.calendar.client.api.Calendar;


@Model(adaptables=SlingHttpServletRequest.class)
public class DateFormatter {
		//@Inject public Calendar date; 
	@Inject public GregorianCalendar date; 
	@Inject private String format; 
			//@Inject String values;
	public String value; 
	
	@PostConstruct 
	public List<String> init() {
		//Date date = new Date();
		List<String> arr =new ArrayList<String>();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		//String strDate= formatter.format(date);
		value = formatter.format(date.getTime());
		
		StringTokenizer st = new StringTokenizer(value,"/");  
	     while (st.hasMoreTokens()) { 
	    	 arr.add(st.nextToken());
	     }
		return arr;
		}
	
	public List<String> fun() {
		//Date date = new Date();
		List<String> arr =new ArrayList<String>();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		//String strDate= formatter.format(date);
		value = formatter.format(date.getTime());
		
		StringTokenizer st = new StringTokenizer(value,"/");  
	     while (st.hasMoreTokens()) { 
	    	 String s = st.nextToken();
	    	 arr.add(s);
	     }
		return arr;
		} 
}
