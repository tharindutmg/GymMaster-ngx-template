package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.domain.MembershipType;

/**
 * @author tharindu
 *
 * Sep 11, 2019
 */
@Repository
public interface MembershipTypeRepo extends JpaRepository<MembershipType, Long>{

}
