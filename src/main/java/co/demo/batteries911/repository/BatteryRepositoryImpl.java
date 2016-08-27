package co.demo.batteries911.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.demo.batteries911.domain.Battery;

@Repository
public class BatteryRepositoryImpl implements BatteryRepository {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	static Logger log = Logger.getLogger(BatteryRepositoryImpl.class.getName());

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Battery battery) throws RuntimeException {
		Session session = this.sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(battery);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error("Error persistence save: " + e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Battery> findAll() throws RuntimeException {
		Session session = this.sessionFactory.openSession();
		List<Battery> listBatteries = new ArrayList<>();
		try {
			session.getTransaction().begin();
			String hql = "FROM Battery";
			Query query = session.createQuery(hql);
			listBatteries = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error("Error persistence findAll: " + e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return listBatteries;
	}
	
	
	@SuppressWarnings("unchecked")
	public Battery findById(Long cdBattery) throws RuntimeException {
		Session session = this.sessionFactory.openSession();
		Battery batteryModel = new Battery();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery(
					"FROM Battery b WHERE b.cdBattery = :cdBattery");
			query.setParameter("cdBattery", cdBattery);
			List<Battery> listBatteries = query.list();
			for (Battery battery : listBatteries) {
				batteryModel.setCdBattery(battery.getCdBattery());
				batteryModel.setDsBrand(battery.getDsBrand());
				batteryModel.setDsCapacity(battery.getDsCapacity());
				batteryModel.setDsAmperage(battery.getDsAmperage());
				batteryModel.setDsCrankingAmps(battery.getDsCrankingAmps());
				batteryModel.setDsDiameter(battery.getDsDiameter());
				batteryModel.setDsHeight(battery.getDsHeight());
				batteryModel.setDsVoltage(battery.getDsVoltage());
				batteryModel.setDsWeight(battery.getDsWeight());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error("Error persistence findById: " + e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return batteryModel;
	}

	public void update(Battery battery) throws RuntimeException {
		Session session = this.sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.update(battery);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error("Error persistence update: " + e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(Battery battery) throws RuntimeException {
		Session session = this.sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(battery);
			session.getTransaction().commit();
		} catch (Exception e) {
			log.error("Error persistence delete: " + e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}
	

}
