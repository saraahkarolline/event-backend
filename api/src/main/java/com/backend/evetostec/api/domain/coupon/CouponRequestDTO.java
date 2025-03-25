package com.backend.evetostec.api.domain.coupon;

public record CouponRequestDTO(String code, Integer discount, Long valid) {
}