package com.gym.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.StaffMember;

/**
 * @author tharindu
 *
 * Aug 1, 2019
 */
public interface StaffMemberService {

	/**
	 * @param json
	 * @param file
	 * @return
	 */
	StaffMember createAndUpdate(JSONObject json, MultipartFile file);

	/**
	 * @param staffMember
	 * @return
	 */
	StaffMember saveStaffMember(StaffMember staffMember);

	/**
	 * @return
	 */
	List<StaffMember> getAll();

	/**
	 * @param id
	 * @return
	 */
	StaffMember getById(Long id);

	/**
	 * @param id
	 */
	void delete(Long id);

}
