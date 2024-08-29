package com.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Prod;

@Repository
public interface ProdRepo extends JpaRepository<Prod, Integer> {

	Page<Prod> findByProdCategoryAndIdAndProdPriceBetween(String prodCategory, Integer id, double minPrice,
			double maxPrice, Pageable pageable);

}
