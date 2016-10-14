package com.zhao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 等级实体类
 * @author 赵翔  项目4组
 * @lastModfiy 2016/10/10 15:50
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="level")
public class Level implements Serializable{

	//等级表ID
	@Id
	@Column(name="lid",unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int lid;
	
	//会员卡等级
	@Column(name="level",unique=true,nullable=false)
	private String level;
	
	//该等级需要的积分
	@Column(name="needMark",unique=true,nullable=false)
	private int needMark;
	
	public Level() {}
	public Level(String level, int needMark) {
		this.level = level;
		this.needMark = needMark;
	}

	public Level(int lid, String level, int needMark) {
		this.lid = lid;
		this.level = level;
		this.needMark = needMark;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getNeedMark() {
		return needMark;
	}

	public void setNeedMark(int needMark) {
		this.needMark = needMark;
	}
	
	
	
}
