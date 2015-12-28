package com.example.yueme;

public class Request {
	
	private String userName,theme,activity,time;
	
	int userPhoto,actPhoto;
	
    public String getUserName(){
    	return userName;
    }
    
    public void setUserName(String userName){
    	this.userName = userName;
    }
    
    public String getTheme(){
    	return theme;
    }
    
    public void setTheme(String theme){
    	this.theme = theme;
    }
    
    public String getActivity(){
    	return activity;
    }
    
    public void setActivity(String activity){
    	this.activity = activity;
    }
    
    public String getTime(){
    	return time;
    }
    
    public void setTime(String time){
    	this.time = time;
    }
    
    public int getUserPhoto(){
    	return userPhoto;
    }
    
    public void setUserPhoto(int userPhoto){
    	this.userPhoto = userPhoto;
    }
    
    public int getActPhoto(){
    	return actPhoto;
    }
    
    public void setActPhoto(int actPhoto){
    	this.actPhoto = actPhoto;
    }
    
}
