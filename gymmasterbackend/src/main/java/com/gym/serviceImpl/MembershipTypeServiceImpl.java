package com.gym.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.MembershipType;
import com.gym.exception.ResourceNotFoundException;
import com.gym.repo.MembershipTypeRepo;
import com.gym.service.MembershipTypeService;

/**
 * @author tharindu
 *
 * Sep 11, 2019
 */

@Service
@Transactional
public class MembershipTypeServiceImpl implements MembershipTypeService{
	
	@Autowired
	public MembershipTypeRepo membershipTypeRepo;

	@Override
	public MembershipType createAndUpdate(JSONObject json, MultipartFile file) {
		return null;
		/*
		 * MembershipType obj=new MembershipType(); obj=setData(json, file) ; return
		 * membershipTypeRepo.save(obj);
		 */
	}

	@Override
	public MembershipType save(MembershipType membershipType) {
		return membershipTypeRepo.save(membershipType);
	}

	@Override
	public List<MembershipType> getAll() {
		return membershipTypeRepo.findAll();
	}

	@Override
	public MembershipType getById(Long id) {
		return membershipTypeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("MembershipType", "accountentId", id));
	}

	@Override
	public void delete(Long id) {
		MembershipType membershipType = getById(id);
		membershipTypeRepo.delete(membershipType);
	}
	
	//this is a support method for save mainObj
	/*
	 * public Accountent setData(JSONObject json, MultipartFile file) { Accountent
	 * mainObj=new Accountent(); if(json.has("accountentId"))
	 * mainObj.setAccountentId(json.getLong("accountentId"));
	 * if(json.has("firstName")) mainObj.setFirstName(json.getString("firstName"));
	 * if(json.has("middleName") && !json.isNull("middleName"))
	 * mainObj.setMiddleName(json.getString("middleName")); if(json.has("lastName"))
	 * mainObj.setLastName(json.getString("lastName")); if(json.has("gender"))
	 * mainObj.setGender(json.getString("gender")); if(json.has("birthDate")) { Date
	 * date=null; try { date = new
	 * SimpleDateFormat("yyyy-MM-dd").parse(json.getString("birthDate")); } catch
	 * (JSONException | ParseException e) { e.printStackTrace(); }
	 * mainObj.setBirthDate(date); } if(json.has("homeTownAddress"))
	 * mainObj.setHomeTownAddress(json.getString("homeTownAddress"));
	 * if(json.has("city")) mainObj.setCity(json.getString("city"));
	 * if(json.has("mobileNumber"))
	 * mainObj.setMobileNumber(json.getString("mobileNumber")); if(json.has("phone")
	 * && !json.isNull("phone")) mainObj.setPhone(json.getString("phone"));
	 * if(json.has("email")) mainObj.setEmail(json.getString("email"));
	 * if(json.has("userName")) mainObj.setUserName(json.getString("userName"));
	 * if(json.has("password")) mainObj.setPassword(json.getString("password"));
	 * 
	 * mainObj.setImageName(file.getOriginalFilename()); try {
	 * mainObj.setImageData(file.getBytes()); } catch (IOException e) {
	 * e.printStackTrace(); } return mainObj; }
	 */

}
