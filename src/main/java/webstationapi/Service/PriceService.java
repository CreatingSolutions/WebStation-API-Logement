package webstationapi.Service;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstationapi.Entity.Period;
import webstationapi.Entity.Price;
import webstationapi.Repository.PeriodRepository;
import webstationapi.Repository.PriceRepository;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PeriodRepository periodRepository;

    @Transactional
    public Price computePrice(Long idFlat, Date dDeb, Date dFin, int saison, boolean week) {
        Price truePrice = new Price();
        List<Period> periodsUsed = new ArrayList<>();
        List<Period> allPeriods = periodRepository.findAll();
        for (Period periods : allPeriods) {
            if (dDeb.after(periods.getStartDay()) && dDeb.before(periods.getStartDay()) && saison == periods.getSeason()) {
                periodsUsed.add(periods);
            }
        }
        if(week) {
            for (Period periods : periodsUsed) {
                truePrice.setPrice(truePrice.getPrice() + priceRepository.computePrice(periods.getPeriodId(), idFlat).getPrice());
            }
        } else {
            Map<Period, Double> dailyPrices = new HashMap<Period, Double>();
            for(Period periods : periodsUsed) {
                dailyPrices.put(periods, priceRepository.computePrice(periods.getPeriodId(), idFlat).getPrice() / ChronoUnit.DAYS.between((Temporal) periods.getStartDay(), (Temporal) periods.getEndDay()));
            }
            Calendar cal = Calendar.getInstance();
            for(int i = 1; i <= ChronoUnit.DAYS.between((Temporal) dDeb, (Temporal) dFin); i++) {
                cal.setTime(dDeb);
                cal.add(Calendar.DAY_OF_YEAR, 1);
                for(Period periods : periodsUsed) {
                    if (cal.getTime().after(periods.getStartDay()) && cal.getTime().before(periods.getEndDay()) && saison == periods.getSeason()) {
                        truePrice.setPrice(truePrice.getPrice()+dailyPrices.get(periods));
                    }
                }
            }
        }
        return truePrice;
    }


}
