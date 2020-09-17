package com.gym.controllers;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.MembershipType;
import com.gym.service.MembershipTypeService;
import com.gym.util.CommonResponce;

/**
 * @author tharindu
 *
 * Sep 11, 2019
 */
public class MembershipTypeController {
	
	private final String url="/membershipType";
	
	@Autowired
	private MembershipTypeService menbershipTypeService;
	
	@PostMapping(url)
	public MembershipType createAndUpdate(@RequestPart("membershipType") String accountentStr,@RequestPart("file") MultipartFile file) {
		
		JSONObject jsonObj = new JSONObject(accountentStr);
    	JSONObject json = (JSONObject) jsonObj.get("membershipType");
		
		return menbershipTypeService.createAndUpdate(json,file);
		
	}
    @PostMapping(url+"/saveWithoutImage")
    public MembershipType save(@RequestBody MembershipType membershipType){
    	System.out.println(membershipType);
        return menbershipTypeService.save(membershipType);
    }
    
    @PostMapping(url+"/temporyImage")
	public MembershipType gettemporyImage(@RequestPart("file") MultipartFile file){
    	MembershipType membershipType=new MembershipType(); 
    	membershipType.setImageName(file.getOriginalFilename()); 
		try {
			membershipType.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return membershipType;
	}
    
    @GetMapping(url)
    public List<MembershipType> getAll() {
    	return menbershipTypeService.getAll();
    }
    
    @GetMapping(url+"/{id}")
	public MembershipType getById(@PathVariable(value="id") Long id){
		return menbershipTypeService.getById(id);
	}
    
    @DeleteMapping(url+"/{id}")
	public CommonResponce delete(@PathVariable(value="id") Long id){
    	menbershipTypeService.delete(id);
		CommonResponce responce = new CommonResponce("success", "Delete Success..!!!");
		return responce;
	}
	

}
