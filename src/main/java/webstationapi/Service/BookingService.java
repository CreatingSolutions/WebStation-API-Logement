package webstationapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Booking;
import webstationapi.Repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}
	
	public void createBooking(Booking booking) {
		bookingRepository.save(booking);
	}
	
}
