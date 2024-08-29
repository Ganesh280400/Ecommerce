package com.example.ElectronicCommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.service.OrdServiceCron;

@Component
public class OrdScheduler {
	@Autowired
	private OrdServiceCron ordservice;

	@Scheduled(cron = "${order.scheduler.cron}")
	public void scheduleOrdPlacement() {
		ordservice.checkAndPlaceOrd();
	}

}
