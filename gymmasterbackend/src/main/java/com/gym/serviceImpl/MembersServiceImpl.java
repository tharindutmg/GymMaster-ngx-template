package com.gym.serviceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.gym.domain.Members;
import com.gym.exception.ResourceNotFoundException;
import com.gym.repo.MembersRepo;
import com.gym.service.MembersService;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tharindu
 * 7/19/19
 */

@Service
@Transactional
public class MembersServiceImpl implements MembersService {

	@Autowired
    private MembersRepo membersRepo;
	
	//this method use for save data without image
    @Override
    public Members saveMembers(Members members) {
        return membersRepo.save(members);
    }
    //this method use for save data with image
	@Override
	public Members createAndUpdateMembers(JSONObject json, MultipartFile file) {
		Members members=new Members(); 
		members=setMemberData(json, file) ;
		return membersRepo.save(members);
	}
	
	@Override
	public List<Members> getAllMembers() {
		return membersRepo.findAll();
	}
	
	@Override
	public Members getMembersById(Long memberId) {
		return membersRepo.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("Member", "memberId", memberId));
	}
	
	@Override
	public void deleteGroup(Long memberId) {
		Members members=membersRepo.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("Member", "memberId", memberId));
		membersRepo.delete(members);
	}
	
	//this is a support method for save members
	public Members setMemberData(JSONObject json, MultipartFile file) {
		Members members=new Members(); 
		if(json.has("memberId")) 
			members.setMemberId(json.getLong("memberId"));
		if(json.has("firstName"))
			members.setFirstName(json.getString("firstName"));
		if(json.has("middleName") && !json.isNull("middleName")) 
			members.setMiddleName(json.getString("middleName"));
		if(json.has("lastName"))
			members.setLastName(json.getString("lastName"));
		if(json.has("gender"))
			members.setGender(json.getString("gender"));
		if(json.has("birthDate")) {
			 Date date=null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(json.getString("birthDate"));
			} catch (JSONException | ParseException e) {
				e.printStackTrace();
			} 
			 members.setBirthDate(date);
		}
		if(json.has("groupId") && !json.isNull("groupId"))
			members.setGroupId(	json.getInt("groupId"));
		if(json.has("address"))
			members.setAddress(json.getString("address"));
		if(json.has("city"))
			members.setCity(json.getString("city"));
		if(json.has("state") && !json.isNull("state"))
			members.setState(json.getString("state"));
		if(json.has("zipCode"))
			members.setZipCode(json.getString("zipCode"));
		if(json.has("mobileNumber"))
			members.setMobileNumber(json.getString("mobileNumber"));
		if(json.has("phone") && !json.isNull("phone"))
			members.setPhone(json.getString("phone"));
		if(json.has("email"))
			members.setEmail(json.getString("email"));
		
		if(json.has("weight") && !json.isNull("weight"))
			members.setWeight(json.getString("weight")!=null? json.getString("weight"):"");
		if(json.has("height") && !json.isNull("height"))
			members.setHeight(json.getString("height")!=null? json.getString("height"):"");
		if(json.has("chest") && !json.isNull("chest"))
			members.setChest(json.getString("chest")!=null? json.getString("chest"):"");
		if(json.has("waist") && !json.isNull("waist"))
			members.setWaist(json.getString("waist")!=null? json.getString("waist"):"");
		if(json.has("thigh") && !json.isNull("thigh"))
			members.setThigh(json.getString("thigh")!=null? json.getString("thigh"):"");
		if(json.has("arms") && !json.isNull("arms"))
			members.setArms(json.getString("arms")!=null? json.getString("arms"):"");
		if(json.has("fat") && !json.isNull("fat"))
			members.setFat(json.getString("fat")!=null? json.getString("fat"):"");
		if(json.has("userName"))
			members.setUserName(json.getString("userName"));
		if(json.has("password"))
			members.setPassword(json.getString("password"));
		if(json.has("confirmPassword"))
			members.setConfirmPassword(json.getString("confirmPassword"));
		
		members.setImageName(file.getOriginalFilename()); 
		try {
			members.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return members;
		
	}
}
