package com.smit.result.providers;

import java.util.ServiceLoader;

import com.smit.result.constants.DefaultResultConstants;
import com.smit.result.constants.ResultConstants;

public class ResultConstantsProvider {
    private static final ResultConstants INSTANCE = loadResultConstants();

     private static ResultConstants loadResultConstants() {
        ServiceLoader<ResultConstants> loader = ServiceLoader.load(ResultConstants.class);
        return loader.findFirst().orElse(new DefaultResultConstants());
    }

    public static ResultConstants getInstance() {
        return INSTANCE;
    }
}
