package com.boot.api.thumbsup.domains.Service.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    
    public String strSplitData(String data) {

    	String dataFirst = data.substring(1);
    	data = dataFirst.substring(0, dataFirst.length()-1);
    	
    	System.out.println("API dataFirst  :::::   "+dataFirst);
    	System.out.println("API data  :::::   "+data);
    	
    	return data;
    }

}