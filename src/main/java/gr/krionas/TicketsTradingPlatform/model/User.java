package gr.krionas.TicketsTradingPlatform.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;


    private String password;
    private String role;

    @Column(name = "is_verified")
    @JsonProperty("isVerified")
    private boolean isVerified;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Listing> listings;

}
