package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.model.Ord;
import com.model.Prod;
import com.model.Qty;
import com.repo.OrdRepo;
import com.repo.ProdRepo;
import com.repo.QtyRepo;

import jakarta.transaction.Transactional;

@Service
public class OrdServiceCron {

	private static final Logger log = LoggerFactory.getLogger(OrdServiceCron.class);

	@Autowired
	private QtyRepo qtyrepo;

	@Autowired
	private OrdRepo ordrepo;

	@Autowired
	ProdRepo prodrepo;

	@Value("${order.critical.qty}")
	private int criticalNumber;

	@Transactional
	public void checkAndPlaceOrd() {
		List<Qty> lowQtyItems = qtyrepo.findByQtyLessThan(criticalNumber);

		log.info(lowQtyItems.toString());

		for (Qty qty : lowQtyItems) {

			int ordQty = calculateOrdQty(qty.getProd().getId());

			Ord ord = new Ord();
			ord.setProd(qty.getProd());
			ord.setOrdQty(ordQty);
			log.info(ord.toString());
			ordrepo.save(ord);
			qty.setQty(qty.getQty() + ordQty);
			qtyrepo.save(qty);
		}
	}

	private int calculateOrdQty(int prodId) {
		Prod prod = prodrepo.findById(prodId).orElse(null);

		if (prod != null) {

			int currentStock = prod.getCurrentStock();
			int reordLevel = prod.getReordLevel();
			int reordQty = prod.getReordQty();

			if (currentStock < reordLevel) {

				return reordQty;
			} else {
				return 20;
			}

		}
		return 0;
	}

}
