package gr.krionas.TicketsTradingPlatform.service;

import gr.krionas.TicketsTradingPlatform.dto.ListingDTO;
import gr.krionas.TicketsTradingPlatform.model.Listing;
import gr.krionas.TicketsTradingPlatform.model.User;
import gr.krionas.TicketsTradingPlatform.repository.ListingRepo;
import gr.krionas.TicketsTradingPlatform.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListingService {

    @Autowired
    ListingRepo repo;
    @Autowired
    UserRepo userRepo;

    public Listing saveListing(Listing listing) {
        // Get logged-in user's username
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Retrieve the user by username

        User user = userRepo.findByUsername(username);

        // Assign the user to the listing
        listing.setUser(user);

        // Save the listing
        return repo.save(listing);
    }

    public List<ListingDTO> getAllListings() {
        List<Listing> listings = repo.findAll();
        return listings.stream().map(listing -> new ListingDTO(
                listing.getId(),
                listing.getTitle(),
                listing.getUser().getUsername(),  // Username from associated User
                listing.getUser().getEmail(),     // Email from associated User
                listing.getDate(),
                listing.getLocation(),
                listing.getIsAvailable(),
                listing.getType(),
                listing.getPrice()
        )).toList();
    }

    public List<Listing> getListingsByUser(long userId) {
        return repo.findByUserId(userId);
    }
}
