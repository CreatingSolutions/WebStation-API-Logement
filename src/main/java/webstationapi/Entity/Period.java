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
 * To be used to store available booking periods.
 */

@Entity
@Table(name="FLAT_PERIODS")
public class Period {

    @Id
    @Column(name="ID_PERIOD")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private long periodId;

    @Column(name="START_DAY")
    private Date startDay;

    @Column(name="END_DAY")
    private Date endDay;

    @Column(name = "SEASON")
    private int season;

    public Period() {}
    public Period(long periodId, Date startDay, Date endDay, int season) {
        this.periodId = periodId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.season = season;
    }
}