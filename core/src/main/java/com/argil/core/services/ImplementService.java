package com.argil.core.services;

import java.util.Arrays;
import java.util.Dictionary;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyOption;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;

import org.apache.felix.scr.annotations.PropertyUnbounded;

@Service(value = ImplementService.class)
@Component(metatype=true, immediate=true)
public class ImplementService implements TestService{
	
	
	String arr[];
	@Reference 
	private SlingRepository repository;

	@Property(name = "author",
            options = {
                    @PropertyOption(name = "Abhishek", value = "Abhishek"),
                    @PropertyOption(name = "Unauthorised user", value = "New_User"
                    		+ "")
                }
             )
    private String AUTHOR_NAME = "author";
	String authorNameNew;
	
	@Property(name="status" , value="status")
	private String status="status";
	String statusnew;
	
	 @Property(value= {"Singing","Dancing", "Reading"}, unbounded=PropertyUnbounded.ARRAY, name="multi" ,label="Multi String", cardinality=50, description="Example for Multi field config")
	  private static final String MULTI_FIELD = "multi";
	
	
	 @Activate
	 public void activate(ComponentContext ctx) { 
		 
		 this.statusnew = PropertiesUtil.toString(ctx.getProperties().get(status),status);
		 this.arr=PropertiesUtil.toStringArray(ctx.getProperties().get(MULTI_FIELD));
		 this.authorNameNew=PropertiesUtil.toString(ctx.getProperties().get(AUTHOR_NAME),AUTHOR_NAME);
		 	 
	 }
	
	public String getRepository() {
		
		return repository.getDescriptor (Repository.REP_NAME_DESC);
		
	}
	
	public String[] getField() {
		for(int i=0;i<arr.length;i++)
			for(int j=i+1;j<arr.length;j++) {
				
				if (arr[i].compareTo(arr[j])<0)
				{
					String temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
		return arr;
	}
	
	public String getStatus() {
		return statusnew;
	}
	
	public String getAuthor() {
		return authorNameNew;
	}
}
