package com.argil.core.models;

import java.util.Calendar;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
@Model(adaptables = { Resource.class })
public class DateFormatter2 {
	
	 @Self
	   private Resource resource;
	   public String value;

	   public String getDate() throws ValueFormatException, IllegalStateException, PathNotFoundException, RepositoryException {
	       Node map = resource.adaptTo(Node.class);
	       return map.getProperty("jcr:created").getValue().getString();
	   }

	}