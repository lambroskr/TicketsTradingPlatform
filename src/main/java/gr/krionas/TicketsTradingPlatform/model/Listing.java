package gr.krionas.TicketsTradingPlatform.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference // Marks the child side of the relationship
    private User user;

    private LocalDate date;
    private String location;
    private Boolean isAvailable;
    private String type; //buy-sell
    private Double price;

}
