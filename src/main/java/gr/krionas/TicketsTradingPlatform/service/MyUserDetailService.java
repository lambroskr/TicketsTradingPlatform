package gr.krionas.TicketsTradingPlatform.service;


import gr.krionas.TicketsTradingPlatform.config.UserDetailsImplementation;
import gr.krionas.TicketsTradingPlatform.model.User;
import gr.krionas.TicketsTradingPlatform.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service class implementing Spring Security's UserDetailsService to load
 * user-specific data during authentication.
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Fetches the user from the database
        User user = repo.findByUsername(username);

        if(user== null){
            throw new UsernameNotFoundException("404 User not Found.");
        }

        // Returns an instance of UserDetailsImplementation for authentication
        return new UserDetailsImplementation(user);
    }
}
