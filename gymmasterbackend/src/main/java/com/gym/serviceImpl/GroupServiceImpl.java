package com.gym.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.Group;
import com.gym.exception.ResourceNotFoundException;
import com.gym.repo.GroupRepo;
import com.gym.service.GroupService;


/**
 * @author tharindu
 *
 * Jun 4, 2019
 */

@Service
@Transactional
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupRepo groupRepo;
	
	@Override
	public Group createAndUpdateGroup(JSONObject json, MultipartFile file)  {
		Group group=new Group(); 
		if(json.has("groupId")) 
			group.setGroupId(json.getLong("groupId"));
		
			group.setGroupCode(json.getString("groupCode"));
			group.setGroup_name(json.getString("group_name"));
			group.setImageName(file.getOriginalFilename()); 
			
			try {
				group.setImageData(file.getBytes()); 
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		return groupRepo.save(group);
	}
	
	@Override
	public Group createAndUpdateGroupWithoutImage(Group group) {
		return groupRepo.save(group);
	}

	@Override
	public List<Group> getAllGroup() {
		List<Group> main = new ArrayList<>();
		for(Group group :groupRepo.findAll()) {
			//group.setBase64Image("data:image/PNG;base64,"+group.getImageData());
			//System.out.println(group.getImageData());
			/*
			 * try { group.setImageBlobObject( new
			 * javax.sql.rowset.serial.SerialBlob(group.getImageData())); } catch
			 * (SQLException e) { e.printStackTrace(); }
			 */
			main.add(group);
		}
		
		
		return main;
	}

	@Override
	public Group getGroupById(Long groupId) {
		return groupRepo.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group", "groupId", groupId));
	}

	@Override
	public void deleteGroup(Long groupId) {
		Group note = groupRepo.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group", "groupId", groupId));
		groupRepo.delete(note);
	}

	@Override
	public String getGroupNameById(Long groupId) {
		Group group = groupRepo.findById(groupId).orElseThrow(() -> new ResourceNotFoundException("Group", "groupId", groupId));
		return group.getGroup_name();
	}

	

}
