package com.gym.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author tharindu
 *
 * Sep 11, 2019
 */

@Entity
@Table(name="membership_type")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class MembershipType {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "membership_type_id")
	private Long membershipTypeId;
	
	@Column(name = "membership_name")
	private String membershipName;
	
	@Column(name = "membership_category_id")
	private Long membershipCategoryId;
	
	@Column(name = "membership_period")
	private String membershipPeriod;
	
	@Column(name = "membership_limit")
	private String membershipLimit;
	
	@Column(name = "membership_amount")
	private double membershipAmount;
	
	@Column(name = "selectted_class")
	private String selecttedClass;
	
	@Column(name = "installment_plan")
	private double installmentPlan;
	
	@Column(name = "signup_fee")
	private double signupFee;
	
	@Column(name = "membership_description")
	private String membershipDescription;
	
	@Lob
	@Column(name = "image_data")
	private byte[] imageData;
	
	@Column(name = "image_name")
	private String imageName;
	
	
	

}
