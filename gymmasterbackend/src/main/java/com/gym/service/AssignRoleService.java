package com.gym.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.AssignRole;
import com.gym.domain.Members;

/**
 * @author tharindu
 *
 * Jul 31, 2019
 */
public interface AssignRoleService {

	/**
	 * @param json
	 * @param file
	 * @return
	 */
	AssignRole createAndUpdate(JSONObject json, MultipartFile file);

	/**
	 * @param assignRole
	 * @return
	 */
	AssignRole save(AssignRole assignRole);

	/**
	 * @return
	 */
	List<AssignRole> getAll();

	/**
	 * @param id
	 * @return
	 */
	AssignRole getById(Long id);

	/**
	 * @param id
	 */
	void delete(Long id);

}
