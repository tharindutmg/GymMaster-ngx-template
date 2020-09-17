package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.domain.Group;

/**
 * @author tharindu
 *
 * Jun 4, 2019
 */
@Repository
public interface GroupRepo extends JpaRepository<Group, Long>{

}
