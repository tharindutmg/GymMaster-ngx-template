package com.gym.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.domain.StaffMember;

/**
 * @author tharindu
 *
 * Aug 1, 2019
 */

@Repository
public interface StaffMemberRepo extends JpaRepository<StaffMember, Long>{

}
