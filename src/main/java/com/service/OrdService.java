package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Ord;
import com.model.OrdReq;
import com.model.Prod;
import com.model.Qty;
import com.repo.OrdRepo;
import com.repo.ProdRepo;
import com.repo.QtyRepo;

@Service
public class OrdService {

	@Autowired
	private OrdRepo ordrepo;

	@Autowired
	private QtyRepo qtyrepo;

	@Autowired
	ProdRepo prodrepo;

	public void createOrder(OrdReq ordreq) {
		// Assuming OrderRequest has productId and orderQuantity
		Integer prodId = ordreq.getProdId();
		int ordQty = ordreq.getOrdQty();

		// Validate if sufficient quantity is available
		if (qtyrepo.existsByProd_IdAndQtyGreaterThanEqual(prodId, ordQty)) {
			// Decrease quantity in the Quantity table
			Qty qty = qtyrepo.findByProdId(prodId);
			qty.setQty(qty.getQty() - ordQty);
			qtyrepo.save(qty);

			Optional<Prod> product = prodrepo.findById(prodId);
			// Create the order
			Ord ord = new Ord();
			ord.setProd(product.get()); // Assuming there's a constructor with productId in Product entity
			ord.setOrdQty(ordQty);
			ordrepo.save(ord);
		} else {
			throw new RuntimeException("Insufficient quantity available for the product.");
		}
	}

	public void cancelOrder(Integer ordId) {
		// Retrieve the order
		Ord ord = ordrepo.findById(ordId).orElseThrow(() -> new RuntimeException("Order not found"));

		// Increase quantity in the Quantity table
		Qty qty = qtyrepo.findByProdId(ord.getProd().getId());
		qty.setQty(qty.getQty() + ord.getOrdQty());
		qtyrepo.save(qty);

		// Delete the order
		ordrepo.deleteById(ordId);
	}

}
