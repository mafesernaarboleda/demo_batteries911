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

	
}
