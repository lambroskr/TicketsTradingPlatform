package gr.krionas.TicketsTradingPlatform.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ListingDTO {
    private long id;
    private String title;
    private String username;
    private String email;
    private LocalDate date;
    private String location;
    private Boolean isAvailable;
    private String type;
    private Double price;

    public ListingDTO(long id, String title, String username, String email, LocalDate date, String location, Boolean isAvailable, String type, Double price) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.email = email;
        this.date = date;
        this.location = location;
        this.isAvailable = isAvailable;
        this.type = type;
        this.price = price;
    }

}