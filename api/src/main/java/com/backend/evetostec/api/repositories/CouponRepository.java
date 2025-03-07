package com.backend.evetostec.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.evetostec.api.domain.coupon.Coupon;
public interface CouponRepository extends JpaRepository<Coupon, UUID> {

}
