package com.backend.evetostec.api.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.backend.evetostec.api.domain.coupon.Coupon;
import com.backend.evetostec.api.domain.coupon.CouponRequestDTO;
import com.backend.evetostec.api.domain.event.Event;
import com.backend.evetostec.api.repositories.CouponRepository;
import com.backend.evetostec.api.repositories.EventRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final EventRepository eventRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO couponData) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(couponData.code());
        coupon.setDiscount(couponData.discount());
        coupon.setValid(new Date(couponData.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);
    }

    public List<Coupon> consultCoupons(UUID eventId, Date currentDate) {
        return couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }
}