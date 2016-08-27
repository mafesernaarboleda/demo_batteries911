package co.demo.batteries911.repository;

import java.util.List;

import co.demo.batteries911.domain.Battery;

public interface BatteryRepository {

	void save(Battery battery);

	List<Battery> findAll();

	Battery findById(Long cdBattery);

	void update(Battery battery);
	
	void delete(Battery battery);
}
