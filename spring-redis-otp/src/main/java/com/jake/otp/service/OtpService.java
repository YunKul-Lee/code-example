package com.jake.otp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final RedisTemplate<String, String> redisTemplate;

    private final TwilioService twilioService;

    private static final String OTP_PREFIX = "otp:";
    private static final String RATE_LIMIT_PREFIX = "rate_limit:";
    private static final int RATE_LIMIT = 5;
    private static final long RATE_LIMIT_PERIOD_SECONDS = 60;

    public String generateOTP(String phoneNumber) {
        String rateLimitKey = RATE_LIMIT_PREFIX + phoneNumber;
        if(!isRateLimited(rateLimitKey)) {
            return "Rate limit exceeded. Please try again later.";
        }

        String otpKey = OTP_PREFIX + phoneNumber;
        String existingOTP = redisTemplate.opsForValue().get(otpKey);
        if(existingOTP != null) {
            return "An OTP has already been generated for this number. Please check your SMS.";
        }

        String otpCode = generateRandomOTP(6);
        redisTemplate.opsForValue().set(otpKey, otpCode, Duration.ofMinutes(5));
        twilioService.sendOTP(phoneNumber, otpCode);

        return "OTP generated and sent to " + phoneNumber;
    }

    public boolean verifyOTP(String phoneNumber, String otpCode) {
        String otpKey = OTP_PREFIX + phoneNumber;
        String storedOTP = redisTemplate.opsForValue().get(otpKey);

        if(storedOTP != null && storedOTP.equalsIgnoreCase(otpCode)) {
            redisTemplate.delete(otpKey);
            return true;
        }

        return false;
    }

    private String generateRandomOTP(int digit) {
        StringBuilder builder = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for(int i = 0; i < digit; i++) {
            builder.append( random.nextInt(10) );
        }

        return builder.toString();
    }

    private boolean isRateLimited(String rateLimitKey) {
        Long currentCount = redisTemplate.opsForValue().increment(rateLimitKey, 1);
        if(currentCount == 1) {
            redisTemplate.expire(rateLimitKey, RATE_LIMIT_PERIOD_SECONDS, TimeUnit.SECONDS);
        }
        return currentCount <= RATE_LIMIT;
    }
}
