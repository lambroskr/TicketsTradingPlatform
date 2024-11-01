package gr.krionas.TicketsTradingPlatform.repository;

import gr.krionas.TicketsTradingPlatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    boolean existsByUsernameOrEmail(String username, String email);
}
