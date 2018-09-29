package nelli.tutorial.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    // Create a filter with all bookings that are less than a specific value
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    // Method for deleting a hotel booking
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<HotelBooking> remove(@PathVariable long id) {
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }
}
