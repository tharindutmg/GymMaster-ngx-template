package com.gym.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.domain.SpecializedGroup;

/**
 * @author tharindu
 *
 * Aug 7, 2019
 */

@Repository
public interface SpecializedGroupRepo extends JpaRepository<SpecializedGroup,Long>{
	
	public List<SpecializedGroup> findByStaffMemberId(long id);
	
	//public List<Long> getGroupIdListMemberId(long id);

}
