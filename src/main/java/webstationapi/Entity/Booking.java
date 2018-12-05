package webstationapi.Entity;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name="FLAT_BOOKINGS")
public class Booking {

    @Id
    @Column(name="ID_BOOKING")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long bookingId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_FLAT")
    private Flat flat;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_PERIOD")
    private Period period;

    @Column(name="LAUNDRY")
    private boolean laundry;

    @Column(name="GARAGE")
    private boolean garage;

    @Column(name="BABY")
    private boolean baby;

    public Booking() {}
    public Booking(Flat flat, Period period, boolean laundry, boolean garage, boolean baby) {
        this.flat = flat;
        this.period = period;
        this.laundry = laundry;
        this.garage = garage;
        this.baby = baby;
    }
}