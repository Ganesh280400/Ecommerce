package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.OrdReq;
import com.service.OrdService;

@RestController
@RequestMapping("/ord")
public class OrdController {
	@Autowired
	private OrdService ordservice;

	@PostMapping("/create")
	public ResponseEntity<String> createOrder(@RequestBody OrdReq ordreq) {
		ordservice.createOrder(ordreq);
		return ResponseEntity.ok("Order created successfully!");
	}

	@PostMapping("/cancel/{ordId}")
	public ResponseEntity<String> cancelOrd(@PathVariable Integer ordId) {
		ordservice.cancelOrder(ordId);
		return ResponseEntity.ok("Order cancelled successfully!");
	}

}
