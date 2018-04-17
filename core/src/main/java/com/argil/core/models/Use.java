package com.argil.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.argil.core.services.ImplementService;
import com.argil.core.services.TestService;

@Model(adaptables=Resource.class)
public class Use {
	
	
	@OSGiService
	ImplementService ts;
	
	public String getStatus() {
		String temp = ts.getStatus();
		return temp;
		}
	public String[] getField() { return ts.getField();}
	public String getAuthor() { return ts.getAuthor(); }
	
}
