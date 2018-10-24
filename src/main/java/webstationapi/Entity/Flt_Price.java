package webstationapi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Class FLT_PRICES
 * 
 * Three columns :
 * 		- id_period, a long, foreign key to FLT_PERIODS(id_period);
 * 		- id_flat, a long, foreign key to FLT_FLATS(id_flat);
 * 		- price, a double, stores the price corresponding to a flat and the period it's booked
 * 
 * Primary key is composed of two fields : (id_period, id_flat).
 * 
 * To be used to store prices for a flat during a certain period.
 */

@Entity
@Table(name="FLT_PRICES")
public class Flt_Price implements Serializable {

	@Id 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PERIOD")
	private Flt_Period period;
	// Long primary key, foreign key to FLT_PERIODS(id_period)

	@Id 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_FLAT")
	private Flt_Flat flat;
	// Long primary key, foreign key to FLT_FLATS(id_flat)

	@Column(name="END_DAY")
	private double price;
	// Double field

	public Flt_Price() {}
	public Flt_Price(Flt_Period period, Flt_Flat flat, Double price) {
		this.period = period;
		this.flat = flat;
		this.price = price;
	}
}