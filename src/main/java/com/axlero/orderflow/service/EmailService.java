package com.axlero.orderflow.service;

public interface EmailService {

    void sendOtp(String email, String otp);

    public void sendResetOtp(String email, String otp);
}