package webstationapi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Class FLT_PERIODS
 * 
 * Three columns :
 * 		- id_period, a long primary key, auto-incremented value;
 * 		- startDay, a Date, stores the beginning of the period;
 * 		- endDay, a Date, stores the ending of the period.
 * 
 * To be used to store available booking periods (Summer or Winter).
 */

@Entity
@Table(name="FLT_PERIODS")
public class Flt_Period {

	@Id 
	@Column(name="ID_PERIOD")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_period;
	// Long primary key, auto-incremented value

	@Column(name="START_DAY")
	private Date startDay;
	// Date field

	@Column(name="END_DAY")
	private Date endDay;
	// Date field
	
	public Flt_Period() {}
	public Flt_Period(long id_period, Date startDay, Date endDay) {
		this.id_period = id_period;
		this.startDay = startDay;
		this.endDay = endDay;
	}
}