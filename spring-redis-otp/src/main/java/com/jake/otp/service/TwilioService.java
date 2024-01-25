package com.jake.otp.service;

import com.jake.otp.config.TwilioConfig;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwilioService {

    private final TwilioConfig twilioConfig;

    public void sendOTP(String phoneNumber, String otpCode) {
        Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                "Your OTP is: " + otpCode
        ).create();
    }
}
