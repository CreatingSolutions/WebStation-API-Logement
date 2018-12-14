package webstationapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Entity.Booking;
import webstationapi.Entity.Flat;
import webstationapi.Entity.Period;
import webstationapi.Service.BookingService;
import webstationapi.Service.FlatService;
import webstationapi.Service.PeriodService;

@RestController
@EnableAutoConfiguration
public class FlatAPIController {

    @Autowired
    private FlatService flatService;
    @Autowired
    private PeriodService periodService;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/flats")
    public List<Flat> getFlats() {
        return flatService.getFlats();
    }
    
    @GetMapping("/flat/{id}")
    public Flat getFlat(long flatId) {
    	return flatService.findById(flatId);
    }
    
    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }
    
    @PostMapping("/book")
    public void bookFlat(@RequestParam int userId, @RequestParam long flatId, @RequestParam long periodId, 
    		@RequestParam boolean laundry, @RequestParam boolean garage, @RequestParam boolean baby) throws Exception {
    	
    	Flat flat = flatService.findById(flatId);
    	Period period = periodService.findById(periodId);
		
    	Booking booking = new Booking(flat, period, laundry, garage, baby);
    	bookingService.createBooking(booking);
    }
}
