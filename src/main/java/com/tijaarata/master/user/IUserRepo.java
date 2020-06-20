/**
 * 
 */
package com.tijaarata.master.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author User
 *
 */
@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {

	User findByName(String name);
}
