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
@Table(name="members")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Members {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
    private Long memberId;

    @Column(name = "role")
    private String role="M";
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "middle_name")
    private String middleName;
	
	@Column(name = "last_name")
    private String lastName;
	
	@Column(name = "gender")
    private String gender;
	
	@Transient
    private String male;
	@Transient
    private String female;

    @Column(name = "birth_date")
    private Date birthDate;
    
    @Column(name = "group_id")
    private long groupId;

    //contact information
    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "zip_code")
    private String zipCode;
    
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;

    //physical information
    @Column(name = "weight")
    private String weight;
    
    @Column(name = "height")
    private String height;
    
    @Column(name = "chest")
    private String chest;
    
    @Column(name = "waist")
    private String waist;
    
    @Column(name = "thigh")
    private String thigh;
    
    @Column(name = "arms")
    private String arms;
    
    @Column(name = "fat")
    private String fat;

    //login information
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "confirm_password")
    private String confirmPassword;

    @Lob
	@Column(name = "image_data")
	private byte[] imageData;
	
	@Column(name = "image_name")
	private String imageName;
}
