package com.gym.serviceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.SpecializedGroup;
import com.gym.domain.StaffMember;
import com.gym.exception.ResourceNotFoundException;
import com.gym.repo.SpecializedGroupRepo;
import com.gym.repo.StaffMemberRepo;
import com.gym.service.StaffMemberService;

/**
 * @author tharindu
 *
 * Aug 1, 2019
 */

@Service
@Transactional
public class StaffMemberServiceImpl implements StaffMemberService{
	
	@Autowired
	private StaffMemberRepo staffMemberRepo;
	
	@Autowired
	private SpecializedGroupRepo specializedGroupRepo;

	@Override
	public StaffMember createAndUpdate(JSONObject json, MultipartFile file) {
		StaffMember obj=new StaffMember(); 
		obj=setData(json, file) ;
		StaffMember staffMember=staffMemberRepo.save(obj);
		staffMember.setSpecializationList(saveSpecializedGroup(obj.getSpecializationList(),staffMember.getStaffMemberId()));
		return staffMember;
	}

	@Override
	public StaffMember saveStaffMember(StaffMember staffMember) {
		
		StaffMember staffMemberSv=staffMemberRepo.save(staffMember);
		staffMemberSv.setSpecializationList(saveSpecializedGroup(staffMember.getSpecializationList(),staffMemberSv.getStaffMemberId()));
		
		return staffMemberSv;
	}
	
	public List<SpecializedGroup> saveSpecializedGroup(List<SpecializedGroup> objList,long staffMemberId) {
		List<SpecializedGroup> groupList=getSpecializedGroupListById(staffMemberId);
		if(!groupList.isEmpty()) {
			specializedGroupRepo.deleteAll(groupList);
		}
		
		List<SpecializedGroup> main = new ArrayList<>();
		for(SpecializedGroup SpecializedGroup: objList) {
			  SpecializedGroup row=new SpecializedGroup();
			  row.setSpecializedGroupId(SpecializedGroup.getSpecializedGroupId());
			  row.setGroupId(SpecializedGroup.getItem_id());
			  //row.setItem_id(SpecializedGroup.getItem_id());
			  row.setItem_text(SpecializedGroup.getItem_text());
			  row.setStaffMemberId(staffMemberId);
		  
			  main.add(specializedGroupRepo.save(row));
		  }
		  return main;
	}

	@Override
	public List<StaffMember> getAll() {
		List<StaffMember> main= new ArrayList<>();
		for(StaffMember sm:staffMemberRepo.findAll()) {
			List<SpecializedGroup> spgroup=getSpecializedGroupListById(sm.getStaffMemberId());
			sm.setSpecializationList(spgroup);
			main.add(sm);
		}
		return main;
	}

	@Override
	public StaffMember getById(Long id) {
		StaffMember sm=staffMemberRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("StaffMember", "staffMemberId", id));
		List<SpecializedGroup> groupList=getSpecializedGroupListById(sm.getStaffMemberId());
		
		sm.setSpecializationList(groupList);
		return sm;
	}
	
	public List<SpecializedGroup> getSpecializedGroupListById(long id) {
		return specializedGroupRepo.findByStaffMemberId(id);
	}
	

	@Override
	public void delete(Long id) {
		StaffMember obj = getById(id);
		staffMemberRepo.delete(obj);
		
		for(SpecializedGroup specializedGroup:obj.getSpecializationList()) {
			
			SpecializedGroup sgObjList= specializedGroupRepo.findById(specializedGroup.getSpecializedGroupId()).orElseThrow(() -> new ResourceNotFoundException("StaffMember", "staffMemberId", id));
			
			specializedGroupRepo.delete(sgObjList);
		}
		
	}
	
	
	
	//this is a support method for save mainObj
	public StaffMember setData(JSONObject json, MultipartFile file) {
		StaffMember obj=new StaffMember(); 
		if(json.has("staffMemberId")) 
			obj.setStaffMemberId(json.getLong("staffMemberId"));
		if(json.has("firstName"))
			obj.setFirstName(json.getString("firstName"));
		if(json.has("middleName") && !json.isNull("middleName")) 
			obj.setMiddleName(json.getString("middleName"));
		if(json.has("lastName"))
			obj.setLastName(json.getString("lastName"));
		if(json.has("gender"))
			obj.setGender(json.getString("gender"));
		if(json.has("birthDate")) {
			 Date date=null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(json.getString("birthDate"));
			} catch (JSONException | ParseException e) {
				e.printStackTrace();
			} 
			 obj.setBirthDate(date);
		}
		if(json.has("assignRole") && !json.isNull("assignRole"))
			obj.setAssignRole(json.getString("assignRole"));
		
		if(json.has("specializationList") && !json.isNull("specializationList")) {
			List<SpecializedGroup> main = new ArrayList<>();
			JSONArray array = (JSONArray)json.get("specializationList");
			
			for (int i = 0; i < array.length(); i++) {
			      JSONObject object = array.optJSONObject(i);
			      SpecializedGroup row = new SpecializedGroup();
			      
			      if(object.has("item_id") && !object.isNull("item_id"))
			    	  row.setItem_id(object.getLong("item_id"));
			      if(object.has("item_text") && !object.isNull("item_text"))
			    	  row.setItem_text(object.getString("item_text"));
			      if(json.has("staffMemberId")) 
			    	  row.setStaffMemberId(json.getLong("staffMemberId"));
			    	  
			      main.add(row);
			 }
			obj.setSpecializationList(main);
		}
		  
		 
		
		if(json.has("homeTownAddress"))
			obj.setHomeTownAddress(json.getString("homeTownAddress"));
		if(json.has("city"))
			obj.setCity(json.getString("city"));
		if(json.has("mobileNumber"))
			obj.setMobileNumber(json.getString("mobileNumber"));
		if(json.has("phone") && !json.isNull("phone"))
			obj.setPhone(json.getString("phone"));
		if(json.has("email"))
			obj.setEmail(json.getString("email"));
		
		
		if(json.has("userName"))
			obj.setUserName(json.getString("userName"));
		if(json.has("password"))
			obj.setPassword(json.getString("password"));
		
		
		obj.setImageName(file.getOriginalFilename()); 
		try {
			obj.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return obj;
		
	}

}
