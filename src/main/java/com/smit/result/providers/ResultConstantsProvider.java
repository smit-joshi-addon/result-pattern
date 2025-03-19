package com.smit.result.providers;

import com.smit.result.constants.DefaultResultConstants;
import com.smit.result.constants.ResultConstants;

import java.util.ServiceLoader;

public class ResultConstantsProvider {
   private static ResultConstants INSTANCE = loadResultConstants();

   public ResultConstantsProvider() {
   }

   private static ResultConstants loadResultConstants() {
      // First, try loading via Spring if running in a Spring Boot app
      ResultConstants springBean = getSpringBeanIfAvailable();
      if (springBean != null) {
         return springBean;
      }

      // Otherwise, fallback to normal ServiceLoader behavior
      ServiceLoader<ResultConstants> loader = ServiceLoader.load(ResultConstants.class);
      return loader.findFirst().orElse(new DefaultResultConstants());
   }

   public static ResultConstants getInstance() {
      return INSTANCE;
   }

   // Try to detect if Spring is available and fetch ResultConstants bean
   private static ResultConstants getSpringBeanIfAvailable() {
      try {
         // Check if Spring is available at runtime by loading Spring context class
         Class<?> springContextClass = Class.forName("org.springframework.context.ApplicationContext");
         Object context = springContextClass.getMethod("getInstance").invoke(null);
         if (context != null) {
            // Fetch the Spring bean for ResultConstants
            return (ResultConstants) springContextClass
                .getMethod("getBean", Class.class)
                .invoke(context, ResultConstants.class);
         }
      } catch (Exception e) {
         // Spring is not available, ignore and return null
      }
      return null;
   }
}
