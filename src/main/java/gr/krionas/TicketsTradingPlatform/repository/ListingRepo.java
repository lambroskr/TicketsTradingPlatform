package gr.krionas.TicketsTradingPlatform.repository;

import gr.krionas.TicketsTradingPlatform.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepo extends JpaRepository<Listing, Long> {

    List<Listing> findByUserId(long userId);
}
