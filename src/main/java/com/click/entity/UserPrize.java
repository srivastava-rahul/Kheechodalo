package com.click.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author vipul
 */
@Entity
@Table(name = "KD_PRIZE")
public class UserPrize implements Serializable {

	private static final long serialVersionUID = 8865900934641440411L;

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "idGen", strategy = "uuid.hex")
	@GeneratedValue(generator = "idGen")
	private String id;

	@Column(name = "PRIZE_DATE")
	private Date prizeDate;

	@Column(name = "PRIZE_AMOUNT", length = 500)
	private String prizeAmount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPrizeDate() {
		return prizeDate;
	}

	public void setPrizeDate(Date prizeDate) {
		this.prizeDate = prizeDate;
	}
	
	public String getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(String prizeAmount) {
		this.prizeAmount = prizeAmount;
	}

	public String toLogString() {
		return "UserPrize [id=" + id + ", prizeDate=" + prizeDate + ", prizeAmount=" + prizeAmount + "]";
	}

}
