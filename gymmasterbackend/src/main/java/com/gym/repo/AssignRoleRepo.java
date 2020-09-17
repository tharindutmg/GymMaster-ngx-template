package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.domain.AssignRole;

/**
 * @author tharindu
 *
 * Jul 31, 2019
 */
@Repository
public interface AssignRoleRepo extends JpaRepository<AssignRole, Long>{

}
