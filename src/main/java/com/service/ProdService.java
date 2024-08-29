package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Prod;
import com.model.Qty;
import com.repo.ProdRepo;
import com.repo.QtyRepo;

import jakarta.transaction.Transactional;

@Service
public class ProdService {

	@Autowired
	private ProdRepo prodrepo;

	@Autowired
	private QtyRepo qtyrepo;

	@Transactional
	public void saveProdAndQty(Prod prod, Qty qty) {
		Prod saveprod = prodrepo.save(prod);
		qty.setProd(saveprod);
		qtyrepo.save(qty);

	}

}
