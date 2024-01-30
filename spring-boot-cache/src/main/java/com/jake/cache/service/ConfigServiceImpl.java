package com.jake.cache.service;

import com.jake.cache.constants.Constant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService{

    @Cacheable(value = "descriptionCache", key = "#code")
    @Override
    public String getDescription(String code) {
        getSum();
        return Constant.CONCEPT_MAP.get(code).getDescription();
    }

    private int getSum() {
        int sum = 0;

        for(int i=0; i < 10_000_000; i++) {
            for(int j = 0; j < 100; j++) {
                sum = sum - 1;
            }
            sum = sum + 1;
        }

        return sum;
    }
}
