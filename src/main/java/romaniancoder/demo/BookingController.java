package romaniancoder.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private BookingRepository bookingRepository;
 //  private List<HoteBooking> bookings;
@Autowired
    public BookingController(BookingRepository bookingRepository) {
     /*   bookings = new ArrayList<>();
        bookings.add(new HoteBooking("Marriot", 200.50, 3));
        bookings.add(new HoteBooking("Ibis", 90, 4));
        bookings.add(new HoteBooking("Novotel", 140.74, 1));*/

   this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HoteBooking> getAll() {
  // return bookings;
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HoteBooking> getAffordable(@PathVariable double price){

     //  return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
   return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HoteBooking> create(@RequestBody HoteBooking hoteBooking){

       // return bookings;
         bookingRepository.save(hoteBooking);
        return bookingRepository.findAll();
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<HoteBooking> remove(@PathVariable long id) {
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }

    }

