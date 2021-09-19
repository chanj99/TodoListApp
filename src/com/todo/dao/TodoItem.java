package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

//할일들의 멤버를 관리하는 class 
public class TodoItem {
	//제목, 내역, 입력한 시간 3개의 멤버. 
    private String title;
    private String desc;
    private String current_date; 

    //생성자, title, decs 받는다. 
    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        SimpleDateFormat f = new SimpleDateFormat("yyy/MM/dd kk:mm:ss");
        this.current_date= f.format(new Date()); //현재시간을 그대로 date 로 넣는다. 자동으로. 
    }
    
    public TodoItem(String title2, String desc2, String current_date2) {
		// TODO Auto-generated constructor stub
    	this.title=title2;
        this.desc=desc2;
        this.current_date = current_date2;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

	@Override
	public String toString() {
		return  "[" + title + "]" + desc + " - " + current_date;
	}
	
	/*
	 * file에 저장하기 위한 string 함수 추
	 * */
	public String toSaveString() {
		return title + "##" + desc + "##" + current_date + "\n";
	}
}
