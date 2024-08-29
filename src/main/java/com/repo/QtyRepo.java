package com.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Qty;

@Repository
public interface QtyRepo extends JpaRepository<Qty, Integer> {

	@Modifying
	@Query(value = "DELETE FROM Qty where prod_id=:prodId", nativeQuery = true)
	void deleteqty(@Param("prodId") Integer prodId);

	boolean existsByProd_IdAndQtyGreaterThanEqual(Integer prodId, int qty);

	Qty findByProdId(Integer prodId);

	List<Qty> findByQtyLessThan(int qty);

}
