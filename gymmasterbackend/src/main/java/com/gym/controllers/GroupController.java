package com.gym.controllers;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.Group;
import com.gym.service.GroupService;
import com.gym.util.CommonResponce;

/**
 * @author tharindu
 *
 * Jun 4, 2019
 */

@CrossOrigin
@RestController
public class GroupController {
	
	private final String url="/group";
	
	@Autowired
	private GroupService groupService;
	
	@PostMapping(url)
	public Group createAndUpdateGroup(@RequestPart("group") String complaintStr,@RequestPart("file") MultipartFile file) {
		
		JSONObject jsonObj = new JSONObject(complaintStr);
    	JSONObject json = (JSONObject) jsonObj.get("group");
		
		return groupService.createAndUpdateGroup(json,file);
		
	}
	
	@PostMapping(url+"/noImage")
	public Group createAndUpdateGroupWithoutImage(@RequestBody Group group) {
		return groupService.createAndUpdateGroupWithoutImage(group);
	}
	
	@GetMapping(url)
	public List<Group> getGroupList(){
		return groupService.getAllGroup();
	}
	
	@GetMapping(url+"/{groupId}")
	public Group getGroupById(@PathVariable(value="groupId") Long groupId){
		return groupService.getGroupById(groupId);
	}
	
	@GetMapping(url+"/name/{groupId}")
	public String getGroupNameById(@PathVariable(value="groupId") Long groupId){
		return groupService.getGroupNameById(groupId);
	}
	
	@PostMapping(url+"/temporyImage")
	public Group gettemporyImage(@RequestPart("file") MultipartFile file){
		Group group=new Group(); 
		group.setImageName(file.getOriginalFilename()); 
		try {
			group.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return group;
	}
	
	@DeleteMapping(url+"/{groupId}")
	public CommonResponce deleteGroup(@PathVariable(value="groupId") Long groupId){
		groupService.deleteGroup(groupId);
		CommonResponce responce = new CommonResponce("success", "Delete Success..!!");
		return responce;
	}
}
