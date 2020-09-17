package com.gym.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author tharindu
 *
 * Aug 6, 2019
 */
@Entity
@Table(name="specialized_group")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class SpecializedGroup {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "specialized_group_id")
	private Long specializedGroupId; 
	
	@Transient 
	private long item_id;
	
	@Column(name = "group_des")
	private String item_text;
	
	@Column(name = "group_id")
	private long groupId;
	
	
	  @Column(name = "staff_member_id") 
	  private Long staffMemberId;
	 
	
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="staff_member_id", nullable=false) private StaffMember
	 * staffMember;
	 */
	 
}
