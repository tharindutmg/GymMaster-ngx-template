package com.gym.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.Group;

/**
 * @author tharindu
 *
 * Jun 4, 2019
 */
public interface GroupService {
	
	public Group createAndUpdateGroup(JSONObject json, MultipartFile file);

	/**
	 * @return
	 */
	public List<Group> getAllGroup();

	/**
	 * @param groupId
	 * @return
	 */
	public Group getGroupById(Long groupId);

	/**
	 * @param group
	 * @return
	 */
	public Group createAndUpdateGroupWithoutImage(Group group);

	/**
	 * @param groupId
	 */
	public void deleteGroup(Long groupId);

	public String getGroupNameById(Long groupId);
}
