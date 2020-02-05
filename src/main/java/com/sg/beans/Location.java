package com.sg.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="location")

/**
 * @author Amit
 *
 * 02-Feb-2020
 */

public class Location {
	
	@Id
	@Column(name="location_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long locationId;
	
	String locationName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="location_id",referencedColumnName = "location_id", insertable = false, updatable = false)
	private List<Post> PostList;


	public List<Post> getPostList() {
		return PostList;
	}

	public void setPostList(List<Post> postList) {
		PostList = postList;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + "]";
	}
	
	

}
