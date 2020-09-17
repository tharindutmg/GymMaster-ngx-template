package com.gym.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.AssignRole;
import com.gym.exception.ResourceNotFoundException;
import com.gym.repo.AssignRoleRepo;
import com.gym.service.AssignRoleService;

/**
 * @author tharindu
 *
 * Jul 31, 2019
 */

@Service
@Transactional
public class AssignRoleServiceImpl implements AssignRoleService{
	
	@Autowired
	public AssignRoleRepo assignRoleRepo;

	@Override
	public AssignRole createAndUpdate(JSONObject json, MultipartFile file) {
		AssignRole obj=new AssignRole(); 
		obj=setData(json, file) ;
		return assignRoleRepo.save(obj);
	}

	@Override
	public AssignRole save(AssignRole assignRole) {
		return assignRoleRepo.save(assignRole);
	}

	@Override
	public List<AssignRole> getAll() {
		return assignRoleRepo.findAll();
	}

	@Override
	public AssignRole getById(Long id) {
		return assignRoleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("AssignRole", "assignRoleId", id));
	}

	@Override
	public void delete(Long id) {
		AssignRole assignRole = getById(id);
		assignRoleRepo.delete(assignRole);
	}
	
	//this is a support method for save mainObj
	public AssignRole setData(JSONObject json, MultipartFile file) {
		AssignRole mainObj=new AssignRole(); 
		if(json.has("assignRoleId")) 
			mainObj.setAssignRoleId(json.getLong("assignRoleId"));
		if(json.has("assignRoleDescription"))
			mainObj.setAssignRoleDes(json.getString("assignRoleDescription"));
		
		/*
		 * mainObj.setImageName(file.getOriginalFilename()); try {
		 * mainObj.setImageData(file.getBytes()); } catch (IOException e) {
		 * e.printStackTrace(); }
		 */
		return mainObj;
		
	}

}
