package com.gym.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.gym.domain.Group;
import com.gym.domain.Members;

/**
 * @author tharindu
 * 7/19/19
 */


public interface MembersService {
    public Members saveMembers(Members members);
	public Members createAndUpdateMembers(JSONObject json, MultipartFile file);
	public List<Members> getAllMembers();
	public Members getMembersById(Long memberId);
	public void deleteGroup(Long memberId);
}
