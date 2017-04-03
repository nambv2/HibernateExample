/**
 * 
 */
package com.vaio.common;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author nambv
 *
 * Mar 30, 2017
 */
@Entity
@Table(name="games")
public class Games implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	int id ;
	String nameid=""; 
	String name="" ;
	@Column(name = "[DESC]", nullable = false)
	String desc="" ;
	int time =0; 
	int width =700;
	int height=467;
	String cat =""; 
	String type="SWF";
	int playcount=0 ;
	int weeklyplays=0 ;
	int instructions =0;
	int keywords=0;
	String active="" ;
	String source_image="";
	String source_fileurl="" ;
	String source_url="";
	String imgname;
	String swfname ;
	int getswf=0;
	int getimg=0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameid() {
		return nameid;
	}
	public void setNameid(String nameid) {
		this.nameid = nameid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPlaycount() {
		return playcount;
	}
	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}
	public int getWeeklyplays() {
		return weeklyplays;
	}
	public void setWeeklyplays(int weeklyplays) {
		this.weeklyplays = weeklyplays;
	}
	public int getInstructions() {
		return instructions;
	}
	public void setInstructions(int instructions) {
		this.instructions = instructions;
	}
	public int getKeywords() {
		return keywords;
	}
	public void setKeywords(int keywords) {
		this.keywords = keywords;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getSource_image() {
		return source_image;
	}
	public void setSource_image(String source_image) {
		this.source_image = source_image;
	}
	public String getSource_fileurl() {
		return source_fileurl;
	}
	public void setSource_fileurl(String source_fileurl) {
		this.source_fileurl = source_fileurl;
	}
	public String getSource_url() {
		return source_url;
	}
	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getSwfname() {
		return swfname;
	}
	public void setSwfname(String swfname) {
		this.swfname = swfname;
	}
	public int getGetswf() {
		return getswf;
	}
	public void setGetswf(int getswf) {
		this.getswf = getswf;
	}
	public int getGetimg() {
		return getimg;
	}
	public void setGetimg(int getimg) {
		this.getimg = getimg;
	}
	
}
