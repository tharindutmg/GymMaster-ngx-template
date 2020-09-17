package com.gym.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.Accountent;
import com.gym.domain.MembershipType;

/**
 * @author tharindu
 *
 * Sep 11, 2019
 */
public interface MembershipTypeService {

	/**
	 * @param json
	 * @param file
	 * @return
	 */
	public MembershipType createAndUpdate(JSONObject json, MultipartFile file);

	/**
	 * @param membershipType
	 * @return
	 */
	public MembershipType save(MembershipType membershipType);

	/**
	 * @return
	 */
	public List<MembershipType> getAll();

	/**
	 * @param id
	 * @return
	 */
	public MembershipType getById(Long id);

	/**
	 * @param id
	 */
	public void delete(Long id);

}
