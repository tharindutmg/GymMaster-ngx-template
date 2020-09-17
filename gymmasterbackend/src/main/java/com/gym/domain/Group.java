package com.gym.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author tharindu
 *
 * Jun 4, 2019
 */

@Entity
@Table(name="group_tb")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Group {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long groupId;
	
	@Column(name = "group_name")
	private String group_name;
	
	@Column(name = "group_code")
	private String groupCode;
	
	@Lob
	@Column(name = "image_data")
	private byte[] imageData;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Transient
	private String base64Image;
	
	//@Transient
	//private Blob imageBlobObject;

}
