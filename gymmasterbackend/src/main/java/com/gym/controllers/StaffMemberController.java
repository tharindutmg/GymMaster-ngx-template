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

import com.gym.domain.SpecializedGroup;
import com.gym.domain.StaffMember;
import com.gym.service.StaffMemberService;
import com.gym.util.CommonResponce;

/**
 * @author tharindu
 *
 * Aug 1, 2019
 */

@CrossOrigin
@RestController
public class StaffMemberController {
	private final String url="/staffMember";

    @Autowired
    private StaffMemberService staffMemberService;

    @PostMapping(url)
	public StaffMember createAndUpdate(@RequestPart("staffMember") String staffMemberStr,@RequestPart("file") MultipartFile file) {
		
		JSONObject jsonObj = new JSONObject(staffMemberStr);
    	JSONObject json = (JSONObject) jsonObj.get("staffMember");
		
		return staffMemberService.createAndUpdate(json,file);
		
	}
    @PostMapping(url+"/saveWithoutImage")
    public StaffMember save(@RequestBody StaffMember staffMember){
    	System.out.println(staffMember);
        return staffMemberService.saveStaffMember(staffMember);
    }
    
    @PostMapping(url+"/temporyImage")
	public StaffMember gettemporyImage(@RequestPart("file") MultipartFile file){
    	StaffMember staffMember=new StaffMember(); 
    	staffMember.setImageName(file.getOriginalFilename()); 
		try {
			staffMember.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return staffMember;
	}
    
    @GetMapping(url)
    public List<StaffMember> getAll() {
    	return staffMemberService.getAll();
    }
    
    @GetMapping(url+"/{id}")
	public StaffMember getById(@PathVariable(value="id") Long id){
		return staffMemberService.getById(id);
	}
    
    @DeleteMapping(url+"/{id}")
	public CommonResponce delete(@PathVariable(value="id") Long id){
    	staffMemberService.delete(id);
		CommonResponce responce = new CommonResponce("success", "Delete Success..!!");
		return responce;
	}
}
