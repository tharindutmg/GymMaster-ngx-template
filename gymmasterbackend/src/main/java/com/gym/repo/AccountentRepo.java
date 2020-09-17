package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.domain.Accountent;

/**
 * @author tharindu
 *
 * Aug 15, 2019
 */
@Repository
public interface AccountentRepo extends JpaRepository<Accountent, Long>{

}
