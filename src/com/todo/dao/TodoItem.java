package com.todo.dao;

import java.util.Date;

//할일들의 멤버를 관리하는 class 
public class TodoItem {
	//제목, 내역, 입력한 시간 3개의 멤버. 
    private String title;
    private String desc;
    private Date current_date; 

    //생성자, title, decs 받는다. 
    public TodoItem(String title, String desc){
        this.title=title;
        this.desc=desc;
        this.current_date=new Date(); //현재시간을 그대로 date 로 넣는다. 자동으로. 
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

    public Date getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(Date current_date) {
        this.current_date = current_date;
    }

	@Override
	public String toString() {
		return  "[" + title + "]" + desc + " - " + current_date;
	}
}
