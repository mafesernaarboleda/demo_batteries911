package co.demo.batteries911.service;

import java.util.List;

import co.demo.batteries911.domain.Battery;

public interface BatteryService {

	void save(Battery battery);

	List<Battery> findAll();

	Battery findById(Long cdBattery);

	void update(Battery battery);
	
	void delete(Battery battery);
}
