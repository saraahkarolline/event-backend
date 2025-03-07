package com.backend.evetostec.api.domain.coupon;

import java.util.Date;
import java.util.UUID;

import com.backend.evetostec.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "coupon")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue
    private UUID id;

    private String code;
    private Integer discount;
    private Date valid;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
