/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.silibre.demo.config;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import org.silibre.demo.SpringFXMLLoader;
import org.silibre.demo.StageManager;
import org.silibre.demo.logging.ExceptionWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author lauthier
 */
@Configuration
public class AppJavaConfig {
    
    private static final String SPECIFIC_BUNDLE = "Bundle";
    
//    @Autowired 
//    SpringFXMLLoader springFXMLLoader;

    /**
     * Useful when dumping stack trace to a string for logging.
     * @return ExceptionWriter contains logging utility methods
     */
    @Bean
    @Scope("prototype")
    public ExceptionWriter exceptionWriter() {
        return new ExceptionWriter(new StringWriter());
    }

    /**
     * Get specific resource bundle
     * @return ResourceBundle 
     */
    @Bean
    public ResourceBundle resourceBundle() {
        return ResourceBundle.getBundle(SPECIFIC_BUNDLE);
    }
    
//    @Bean
//    @Lazy(value = true) //Stage only created after Spring context bootstap
//    public StageManager stageManager(Stage stage) throws IOException {
//        return new StageManager(springFXMLLoader, stage);
//    }
}
