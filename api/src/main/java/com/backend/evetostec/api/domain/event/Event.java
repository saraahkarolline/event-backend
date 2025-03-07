package com.backend.evetostec.api.domain.event;
import java.util.Date;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "event")
@Entity
@Setter
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String description;
    private String imgUrl;
    private String eventUrl;
    private Boolean remote;
    private Date date;

}
