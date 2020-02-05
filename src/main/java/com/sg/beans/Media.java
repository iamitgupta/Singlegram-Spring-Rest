package com.sg.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="media")

/**
 * @author Amit
 *
 * 02-Feb-2020
 */

public class Media {
	
	@Id
	@Column(name="media_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mediaId;
//	
//	@Column(unique = true)
//	private String mediaName;
//	
//	private String mediaUrl;
//	
//	private String mediaType;
//	
////	@OneToOne(cascade = CascadeType.ALL)
////	@JoinColumn(name = "media_id")
////	private Post post;
//
//	public Long getMediaId() {
//		return mediaId;
//	}
//
//	public void setMediaId(Long mediaId) {
//		this.mediaId = mediaId;
//	}
//
//	public String getMediaName() {
//		return mediaName;
//	}
//
//	public void setMediaName(String mediaName) {
//		this.mediaName = mediaName;
//	}
//
//	public String getMediaUrl() {
//		return mediaUrl;
//	}
//
//	public void setMediaUrl(String mediaUrl) {
//		this.mediaUrl = mediaUrl;
//	}
//
//	public String getMediaType() {
//		return mediaType;
//	}
//
//	public void setMediaType(String mediaType) {
//		this.mediaType = mediaType;
//	}
//
//	
//
//	@Override
//	public String toString() {
//		return "Media [mediaId=" + mediaId + ", mediaName=" + mediaName + ", mediaUrl=" + mediaUrl + ", mediaType="
//				+ mediaType +  "]";
//	}
	
	
	/*
	 * foreign key
	 * userId
	 * 
	*/
	
	
	
	
	
	

}
