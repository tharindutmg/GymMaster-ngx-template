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
 * Aug 13, 2019
 */

@Entity
@Table(name="accountent")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Accountent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountent_id")
    private Long accountentId;

    @Column(name = "role")
    private String role="A";
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "middle_name")
    private String middleName;
	
	@Column(name = "last_name")
    private String lastName;
	
	@Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private Date birthDate;

    //contact information
    @Column(name = "address")
    private String homeTownAddress;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;

    //login information
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "password")
    private String password;
    
    /* @Column(name = "confirm_password")
    private String confirmPassword; */

    @Lob
	@Column(name = "image_data")
	private byte[] imageData;
	
	@Column(name = "image_name")
	private String imageName;
	
}
