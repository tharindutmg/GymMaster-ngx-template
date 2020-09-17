package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.domain.Members;

/**
 * @author tharindu
 * 7/19/19
 */

@Repository
public interface MembersRepo extends JpaRepository<Members, Long> {
}
