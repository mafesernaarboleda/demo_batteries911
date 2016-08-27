package co.demo.batteries911.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_batteries")
public class Battery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5487324171993597976L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cdBattery")
	private Long cdBattery;
	
	@Column(name = "dsBrand")
	private String dsBrand;
	
	@Column(name = "dsAmperage")
	private String dsAmperage;
	
	@Column(name = "dsVoltage")
	private String dsVoltage;
	
	@Column(name = "dsCapacity")
	private String dsCapacity;
	
	@Column(name = "dsDiameter")
	private String dsDiameter;
	
	@Column(name = "dsHeight")
	private String dsHeight;
	
	@Column(name = "dsWeight")
	private String dsWeight;
	
	@Column(name = "dsCrankingAmps")
	private String dsCrankingAmps;

	public Long getCdBattery() {
		return cdBattery;
	}

	public void setCdBattery(Long cdBattery) {
		this.cdBattery = cdBattery;
	}

	public String getDsBrand() {
		return dsBrand;
	}

	public void setDsBrand(String dsBrand) {
		this.dsBrand = dsBrand;
	}

	public String getDsAmperage() {
		return dsAmperage;
	}

	public void setDsAmperage(String dsAmperage) {
		this.dsAmperage = dsAmperage;
	}

	public String getDsVoltage() {
		return dsVoltage;
	}

	public void setDsVoltage(String dsVoltage) {
		this.dsVoltage = dsVoltage;
	}

	public String getDsCapacity() {
		return dsCapacity;
	}

	public void setDsCapacity(String dsCapacity) {
		this.dsCapacity = dsCapacity;
	}

	public String getDsDiameter() {
		return dsDiameter;
	}

	public void setDsDiameter(String dsDiameter) {
		this.dsDiameter = dsDiameter;
	}

	public String getDsHeight() {
		return dsHeight;
	}

	public void setDsHeight(String dsHeight) {
		this.dsHeight = dsHeight;
	}

	public String getDsWeight() {
		return dsWeight;
	}

	public void setDsWeight(String dsWeight) {
		this.dsWeight = dsWeight;
	}

	public String getDsCrankingAmps() {
		return dsCrankingAmps;
	}

	public void setDsCrankingAmps(String dsCrankingAmps) {
		this.dsCrankingAmps = dsCrankingAmps;
	}
	
}
