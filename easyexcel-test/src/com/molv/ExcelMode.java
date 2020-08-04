package com.molv;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ExcelMode extends BaseRowModel {
    @ExcelProperty(value = "ÐÕÃû" ,index = 0)
    private  String  userName;
    @ExcelProperty(value = "ÄêÁä" ,index = 1)
    private String age;
    @ExcelProperty(value = "×¡Ö·" ,index = 2)
    private String address;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
