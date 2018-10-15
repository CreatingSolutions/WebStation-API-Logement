package webstationapi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @Class FLT_RESAS
 * 
 * Seven columns :
 * 		- id_resa, a long primary key, auto-incremented value;
 * 		- id_flat, a long, foreign key to FLT_FLATS(id_flat);
 * 		- id_period, a long, foreign key to FLT_PERIODS(id_period);
 * 		- id_user, a long, foreign key to WS_USERS(id_user);
 * 		- laundry, an integer, stores the value for the laundry option (1 = yes, 0 = no)
 * 		- garage, an integer, stores the value for the garage option (1 = yes, 0 = no)
 * 		- baby, an integer, stores the value for the baby option (1 = yes, 0 = no)
 * 
 * Primary key is composed of two fields : (id_period, id_flat).
 * 
 * To be used to store prices for a flat during a certain period.
 */

@Entity
@Table(name="FLT_RESAS")
public class Flt_Resa {

	@Id
	@Column(name="ID_RESA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_resa;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_FLAT")
	private Flt_Flat flat;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PERIOD")
	private Flt_Period period;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USER")
	private Ws_User user;*/

	@Column(name="LAUNDRY")
	private int laundry;

	@Column(name="GARAGE")
	private int garage;

	@Column(name="BABY")
	private int baby;

	public Flt_Resa() {}
	public Flt_Resa(Long id_resa, Flt_Flat flat, Flt_Period period, /*Ws_User user,*/ int laundry, int garage, int baby) {
		this.id_resa = id_resa;
		this.flat = flat;
		this.period = period;
		//this.user = user;
		this.laundry = laundry;
		this.garage = garage;
		this.baby = baby;
	}
}