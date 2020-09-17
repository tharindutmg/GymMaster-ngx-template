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

import com.gym.domain.Accountent;
import com.gym.service.AccountentService;
import com.gym.util.CommonResponce;

/**
 * @author tharindu
 *
 * Aug 15, 2019
 */

@CrossOrigin
@RestController
public class AccountentController {
	private final String url="/accountent";

    @Autowired
    private AccountentService accountentService;

    @PostMapping(url)
	public Accountent createAndUpdate(@RequestPart("accountent") String accountentStr,@RequestPart("file") MultipartFile file) {
		
		JSONObject jsonObj = new JSONObject(accountentStr);
    	JSONObject json = (JSONObject) jsonObj.get("accountent");
		
		return accountentService.createAndUpdate(json,file);
		
	}
    @PostMapping(url+"/saveWithoutImage")
    public Accountent save(@RequestBody Accountent accountent){
    	System.out.println(accountent);
        return accountentService.save(accountent);
    }
    
    @PostMapping(url+"/temporyImage")
	public Accountent gettemporyImage(@RequestPart("file") MultipartFile file){
    	Accountent accountent=new Accountent(); 
    	accountent.setImageName(file.getOriginalFilename()); 
		try {
			accountent.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return accountent;
	}
    
    @GetMapping(url)
    public List<Accountent> getAll() {
    	return accountentService.getAll();
    }
    
    @GetMapping(url+"/{id}")
	public Accountent getById(@PathVariable(value="id") Long id){
		return accountentService.getById(id);
	}
    
    @DeleteMapping(url+"/{id}")
	public CommonResponce delete(@PathVariable(value="id") Long id){
    	accountentService.delete(id);
		CommonResponce responce = new CommonResponce("success", "Delete Success..!!");
		return responce;
	}
}
