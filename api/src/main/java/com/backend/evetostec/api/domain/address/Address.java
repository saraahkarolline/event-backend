package com.backend.evetostec.api.domain.address;
import java.util.Date;
import java.util.UUID;

import com.backend.evetostec.api.domain.event.Event;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "address")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
        @Id
    @GeneratedValue
    private UUID id;

    private String city;
    private String uf;
    private Date valid;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
