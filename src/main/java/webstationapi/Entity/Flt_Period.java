package webstationapi.Entity;

import org.hibernate.annotations.GenericGenerator;

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
 * 		- season, Integer, stores the season 0 winter 1 summer
 * 
 * To be used to store available booking periods (Summer or Winter).
 */

@Entity
@Table(name="FLT_PERIODS")
public class Flt_Period {

	@Id 
	@Column(name="ID_PERIOD")
	@GeneratedValue(
			strategy= GenerationType.AUTO,
			generator="native"
	)
	@GenericGenerator(
			name = "native",
			strategy = "native"
	)
	private long id_period;
	// Long primary key, auto-incremented value

	@Column(name="START_DAY")
	private Date startDay;
	// Date field

	@Column(name="END_DAY")
	private Date endDay;
	// Date field

	@Column(name = "SEASON")
	private Integer season;
	// season field

	public Flt_Period() {}
	public Flt_Period(long id_period, Date startDay, Date endDay, Integer season) {
		this.id_period = id_period;
		this.startDay = startDay;
		this.endDay = endDay;
		this.season = season;
	}
}