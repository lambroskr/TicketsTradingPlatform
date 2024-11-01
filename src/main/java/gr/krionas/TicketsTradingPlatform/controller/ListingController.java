package gr.krionas.TicketsTradingPlatform.controller;

import gr.krionas.TicketsTradingPlatform.dto.ListingDTO;
import gr.krionas.TicketsTradingPlatform.model.Listing;
import gr.krionas.TicketsTradingPlatform.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
public class ListingController {

    @Autowired
    ListingService service;

    @GetMapping("/listings")
    public String getAllListings(Model model) {
        List<ListingDTO> listings = service.getAllListings();
        model.addAttribute("listings", listings); // Add listings to the model
        return "listings"; // Return the name of the Thymeleaf template
    }




    @PostMapping("/createListing")
    public String createListing(
            @RequestParam String title,
            @RequestParam String type,
            @RequestParam double price,
            @RequestParam String location,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {

        // Create listing and set default values
        Listing listing = new Listing();
        listing.setTitle(title);
        listing.setType(type);
        listing.setPrice(price);
        listing.setLocation(location);
        listing.setDate(date);
        listing.setIsAvailable(true); // Default to true

        // Save listing through the service
        service.saveListing(listing);

        // Redirect to  listings page
        return "redirect:/listings";
    }

    @GetMapping("/createListing")
    public String showCreateListingForm(Model model) {
        model.addAttribute("listing", new Listing()); // Add an empty listing object for binding
        return "createListing";
    }

}
