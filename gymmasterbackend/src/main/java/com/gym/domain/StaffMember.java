package com.gym.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author tharindu
 *
 * Jul 31, 2019
 */

@Entity
@Table(name="staff_member")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class StaffMember {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_member_id")
	public Long staffMemberId;

	@Column(name = "role")
    private String role="S";
	
	@Column(name = "first_name")
	public String firstName;
	
	@Column(name = "middle_name")
	public String middleName;
	
	@Column(name = "last_name")
	public String lastName;
	
	@Column(name = "gender")
	public String gender;
	
	@Column(name = "birth_date")
	public Date birthDate;
	
	@Column(name = "assign_role")
	public String assignRole;
	
	/*
	 * @Column(name = "specialization") public String specialization;
	 */
	/* @OneToMany(mappedBy="staff_member_id") */
	
	/*
	 * @OneToMany(mappedBy = "staffMember", cascade = CascadeType.ALL) private
	 * List<SpecializedGroup> specialization;
	 */
	 
	@Transient 
	public String specialization;
	
	@Transient 
	public List<SpecializedGroup> specializationList;
	 
	
	@Column(name = "home_town_address")
	public String homeTownAddress; 
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "mobile_number")
	public String mobileNumber;
	
	@Column(name = "phone")
	public String phone;
	
	@Column(name = "email")
	public String email;
	
	@Column(name = "user_name")
	public String userName;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "display_Image")
	public String displayImage;
	
	@Lob
	@Column(name = "image_data")
	private byte[] imageData;
	
	@Column(name = "image_name")
	private String imageName;
	
	
}
