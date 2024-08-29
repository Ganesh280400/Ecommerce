package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Prod;
import com.model.ProdQtyReq;
import com.model.Qty;
import com.repo.ProdRepo;
import com.repo.QtyRepo;
import com.service.ProdService;

import jakarta.transaction.Transactional;

@RestController
public class ProdController {

	@Autowired
	private ProdService serv;

	@Autowired
	ProdRepo repo;

	@Autowired
	QtyRepo qtyrepo;

	@PostMapping("/saveProdAndQty")
	public ResponseEntity<String> saveProdAndQty(@RequestBody ProdQtyReq req) {
		Prod prod = req.getProd();
		Qty qty = req.getQty();
		serv.saveProdAndQty(prod, qty);
		return ResponseEntity.ok("Product details saved successfully!");
	}

	@GetMapping("/getprod")
	public ResponseEntity<Prod> getProdById(@RequestParam("id") int id) {
		Optional<Prod> prod = repo.findById(id);
		return ResponseEntity.ok(prod.get());
	}

	@DeleteMapping("/deleteprod")
	@Transactional
	public ResponseEntity<String> deleteProdbyId(@RequestParam("id") int id) {
		qtyrepo.deleteqty(id);
		repo.deleteById(id);
		return ResponseEntity.ok("Product details deleted successfully!");
	}

}
