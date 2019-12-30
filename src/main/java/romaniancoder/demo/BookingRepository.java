package romaniancoder.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository  extends JpaRepository<HoteBooking, Long> {
   List<HoteBooking> findByPricePerNightLessThan(double price);

    void delete(long id);

    void save(List<HoteBooking> bookings);
}
