package webstationapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webstationapi.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
