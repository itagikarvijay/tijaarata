/**
 * 
 */
package com.tijaarata.tran.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author User
 *
 */
@Repository
public interface IOrderRepo extends JpaRepository<Order,Integer>{

}
