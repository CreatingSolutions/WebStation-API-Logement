package webstationapi.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
@Table(name="FLAT_PRICES")
public class Price implements Serializable {

    private static final long serialVersionUID = 3484508023001200373L;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_PERIOD")
    private Period period;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_FLAT")
    private Flat flat;

    @Column(name="PRICE")
    private double price;

    public Price() {}
    public Price(Period period, Flat flat, Double price) {
        this.period = period;
        this.flat = flat;
        this.price = price;
    }
}