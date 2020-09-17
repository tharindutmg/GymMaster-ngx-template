package com.gym.controllers;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.AssignRole;
import com.gym.domain.Members;
import com.gym.service.AssignRoleService;
import com.gym.service.MembersService;
import com.gym.util.CommonResponce;

/**
 * @author tharindu
 *
 * Jul 31, 2019
 * 
 * this is sub program inside staff member program (this program not fully developed still the requirement not clear)
 */

@CrossOrigin
@RestController
public class AssignRoleController {
	
	private final String url="/assignRole";

    @Autowired
    private AssignRoleService assignRoleService;

	/*
	 * @PostMapping(url) public AssignRole
	 * createAndUpdate(@RequestPart("assignRole") String
	 * assignRoleStr,@RequestPart("file") MultipartFile file) {
	 * 
	 * JSONObject jsonObj = new JSONObject(assignRoleStr); JSONObject json =
	 * (JSONObject) jsonObj.get("assignRole");
	 * 
	 * return assignRoleService.createAndUpdate(json,file);
	 * 
	 * }
	 */
    @PostMapping(url)
    public AssignRole save(@RequestBody AssignRole assignRole){
    	System.out.println(assignRole);
        return assignRoleService.save(assignRole);
    }
    
	/*
	 * @PostMapping(url+"/temporyImage") public AssignRole
	 * gettemporyImage(@RequestPart("file") MultipartFile file){ AssignRole
	 * assignRole=new AssignRole();
	 * assignRole.setImageName(file.getOriginalFilename()); try {
	 * assignRole.setImageData(file.getBytes()); } catch (IOException e) {
	 * e.printStackTrace(); } return assignRole; }
	 */
    
    @GetMapping(url)
    public List<AssignRole> getAll() {
    	return assignRoleService.getAll();
    }
    
    @GetMapping(url+"/{id}")
	public AssignRole getById(@PathVariable(value="id") Long id){
		return assignRoleService.getById(id);
	}
    
    @DeleteMapping(url+"/{id}")
	public CommonResponce delete(@PathVariable(value="id") Long id){
    	assignRoleService.delete(id);
		CommonResponce responce = new CommonResponce("success", "Delete Success..!!");
		return responce;
	}
}
