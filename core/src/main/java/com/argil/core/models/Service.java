package com.argil.core.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= {Resource.class})
public class Service {
	@Inject 
	String[] playerInfo;
	
	
	
	
	List<Sling> arr=new ArrayList<Sling>();
	
	public List<Sling> getFun() throws JSONException {
JSONObject jsonObject;
		for(int i=0;i<playerInfo.length;i++) {
		jsonObject =new JSONObject(playerInfo[i]);
			
			//Iterator keys = (Iterator) json.keys();
	//
	//		while( ((java.util.Iterator<String>) keys).hasNext() ) {
	//			keys.iconTitle
			Sling obj=new Sling();
			//obj.image=json.getString("image");
			obj.setUserName(jsonObject.get("name").toString());
			obj.setDescription(jsonObject.get("desc").toString());
			obj.setImage(jsonObject.get("file").toString());
			
			arr.add(obj);
			
		}
	return arr;
	}
	
	public String[] getMsg() {
		return playerInfo;
	}
	
}

