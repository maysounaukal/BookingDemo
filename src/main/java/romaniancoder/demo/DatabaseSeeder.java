package romaniancoder.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        List<HoteBooking> bookings = new ArrayList<> ();

        // bookings = new ArrayList<> ();
        bookings.add (new HoteBooking ("Marriot", 200.50, 3));
        bookings.add (new HoteBooking ("Ibis", 90, 4));
        bookings.add (new HoteBooking ("Novotel", 140.74, 1));
        bookingRepository.save (bookings);

    }


}
