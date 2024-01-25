package com.jake.otp.controller;

import com.jake.otp.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/otp")
public class OTPController {

    private final OtpService otpService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateOTP(@RequestParam String phoneNumber) {
        String result = otpService.generateOTP(phoneNumber);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOTP(@RequestParam String phoneNumber, @RequestParam String otpCode) {
        boolean isValid = otpService.verifyOTP(phoneNumber, otpCode);
        if(isValid) {
            return ResponseEntity.ok("OTP verification successful");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
    }
}
