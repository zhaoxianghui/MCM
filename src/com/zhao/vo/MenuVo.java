package com.zhao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="v_menu")
public class MenuVo implements Serializable{
	
	@Id
	@Column(name="mid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int mid;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="url",unique=true,nullable=false)
	private String url;
	
	@Column(name="isshow",nullable=false)
	private int isshow;
	
	@Column(name="level",nullable=false)
	private int level;
	
	@Column(name="parentiname",unique=true)
	private String parentiname;
	
	public String toString(){
		return "{\"mid\":"+mid+",\"name\":"+name+",\"url\":"+url+",\"isshow\":"+isshow+",\"level\":"+level+",\"parentiname\":"+parentiname+"}";
	}
	
	public MenuVo() {}
	public MenuVo(String name, String url, int isshow, int level,
			String parentiname) {
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentiname = parentiname;
	}

	public MenuVo(int mid, String name, String url, int isshow, int level,
			String parentiname) {
		this.mid = mid;
		this.name = name;
		this.url = url;
		this.isshow = isshow;
		this.level = level;
		this.parentiname = parentiname;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getParentiname() {
		return parentiname;
	}
	public void setParentiname(String parentiname) {
		this.parentiname = parentiname;
	}
	

	
	
}
