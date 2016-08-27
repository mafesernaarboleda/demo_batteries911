package co.demo.batteries911.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.demo.batteries911.domain.Battery;
import co.demo.batteries911.repository.BatteryRepository;

@Service
public class BatteryServiceImpl implements BatteryService {

	private BatteryRepository batteryRepository;

	public void setBatteryRepository(BatteryRepository batteryRepository) {
		this.batteryRepository = batteryRepository;
	}

	@Transactional
	public void save(Battery battery) {
		batteryRepository.save(battery);
	}

	@Transactional
	public List<Battery> findAll() {
		return (List<Battery>) batteryRepository.findAll();
	}

	@Transactional
	public Battery findById(Long cdBattery) {
		return batteryRepository.findById(cdBattery);
	}

	@Transactional
	public void update(Battery battery) {
		batteryRepository.update(battery);
	}

	@Transactional
	public void delete(Battery battery) {
		batteryRepository.delete(battery);
	}
}
