package com.gym.service;

import java.util.List;

import com.gym.domain.Accountent;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tharindu
 *
 * Aug 15, 2019
 */
public interface AccountentService {

	/**
	 * @param json
	 * @param file
	 * @return
	 */
	Accountent createAndUpdate(JSONObject json, MultipartFile file);

	/**
	 * @param assignRole
	 * @return
	 */
	Accountent save(Accountent assignRole);

	/**
	 * @return
	 */
	List<Accountent> getAll();

	/**
	 * @param id
	 * @return
	 */
	Accountent getById(Long id);

	/**
	 * @param id
	 */
	void delete(Long id);

}
