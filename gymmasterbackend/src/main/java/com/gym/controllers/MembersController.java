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

import com.gym.domain.Group;
import com.gym.domain.Members;
import com.gym.service.MembersService;
import com.gym.util.CommonResponce;

/**
 * @author tharindu
 * 7/19/19
 */

@CrossOrigin
@RestController
public class MembersController {

    private final String url="/members";

    @Autowired
    private MembersService membersService;

    @PostMapping(url)
	public Members createAndUpdateGroup(@RequestPart("members") String membersStr,@RequestPart("file") MultipartFile file) {
		
		JSONObject jsonObj = new JSONObject(membersStr);
    	JSONObject json = (JSONObject) jsonObj.get("members");
		
		return membersService.createAndUpdateMembers(json,file);
		
	}
    @PostMapping(url+"/saveWithoutImage")
    public Members saveMembers(@RequestBody Members members){
    	System.out.println(members);
        return membersService.saveMembers(members);
    }
    
    @PostMapping(url+"/temporyImage")
	public Members gettemporyImage(@RequestPart("file") MultipartFile file){
    	Members members=new Members(); 
    	members.setImageName(file.getOriginalFilename()); 
		try {
			members.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return members;
	}
    
    @GetMapping(url)
    public List<Members> getAllMembers() {
    	return membersService.getAllMembers();
    }
    
    @GetMapping(url+"/{memberId}")
	public Members getMemberById(@PathVariable(value="memberId") Long memberId){
		return membersService.getMembersById(memberId);
	}
    
    @DeleteMapping(url+"/{memberId}")
	public CommonResponce deleteGroup(@PathVariable(value="memberId") Long memberId){
    	membersService.deleteGroup(memberId);
		CommonResponce responce = new CommonResponce("success", "Delete Success..!!");
		return responce;
	}
}
