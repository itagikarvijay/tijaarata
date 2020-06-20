/**
 * 
 */
package com.tijaarata.tran.order.details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author User
 *
 */
@Repository
public interface IOrderDetailsRepo extends JpaRepository<OrderDetails,Integer> {

}
