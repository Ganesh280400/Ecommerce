package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Ord;

@Repository
public interface OrdRepo extends JpaRepository<Ord, Integer> {

}
