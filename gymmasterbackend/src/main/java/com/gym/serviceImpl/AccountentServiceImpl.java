package com.gym.serviceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.gym.domain.Accountent;
import com.gym.exception.ResourceNotFoundException;
import com.gym.repo.AccountentRepo;
import com.gym.service.AccountentService;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tharindu
 *
 * Aug 15, 2019
 */

@Service
@Transactional
public class AccountentServiceImpl implements AccountentService{
	
	@Autowired
	public AccountentRepo accountentRepo;

	@Override
	public Accountent createAndUpdate(JSONObject json, MultipartFile file) {
		Accountent obj=new Accountent(); 
		obj=setData(json, file) ;
		return accountentRepo.save(obj);
	}

	@Override
	public Accountent save(Accountent accountent) {
		return accountentRepo.save(accountent);
	}

	@Override
	public List<Accountent> getAll() {
		return accountentRepo.findAll();
	}

	@Override
	public Accountent getById(Long id) {
		return accountentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Accountent", "accountentId", id));
	}

	@Override
	public void delete(Long id) {
		Accountent accountent = getById(id);
		accountentRepo.delete(accountent);
	}
	
	//this is a support method for save mainObj
	public Accountent setData(JSONObject json, MultipartFile file) {
		Accountent mainObj=new Accountent(); 
		if(json.has("accountentId")) 
			mainObj.setAccountentId(json.getLong("accountentId"));
		if(json.has("firstName"))
			mainObj.setFirstName(json.getString("firstName"));
		if(json.has("middleName") && !json.isNull("middleName")) 
			mainObj.setMiddleName(json.getString("middleName"));
		if(json.has("lastName"))
			mainObj.setLastName(json.getString("lastName"));
		if(json.has("gender"))
			mainObj.setGender(json.getString("gender"));
		if(json.has("birthDate")) {
			 Date date=null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(json.getString("birthDate"));
			} catch (JSONException | ParseException e) {
				e.printStackTrace();
			} 
			 mainObj.setBirthDate(date);
		}
		if(json.has("homeTownAddress"))
			mainObj.setHomeTownAddress(json.getString("homeTownAddress"));
		if(json.has("city"))
			mainObj.setCity(json.getString("city"));
		if(json.has("mobileNumber"))
			mainObj.setMobileNumber(json.getString("mobileNumber"));
		if(json.has("phone") && !json.isNull("phone"))
			mainObj.setPhone(json.getString("phone"));
		if(json.has("email"))
			mainObj.setEmail(json.getString("email"));
		if(json.has("userName"))
			mainObj.setUserName(json.getString("userName"));
		if(json.has("password"))
			mainObj.setPassword(json.getString("password"));
		
		mainObj.setImageName(file.getOriginalFilename()); 
		try {
			mainObj.setImageData(file.getBytes()); 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return mainObj;
	}

}
