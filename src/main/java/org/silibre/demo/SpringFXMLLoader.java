/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.silibre.demo;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Load the FXML hierarchy as specified in the load method and register
 * Spring as the FXML Controller Factory. Allows Spring and Java FX to coexist
 * once the Spring Application context has been bootstrapped.
 */
@Component
public class SpringFXMLLoader {
    
    private final ResourceBundle resourceBundle;
    private final ApplicationContext context;

    @Autowired
    public SpringFXMLLoader(ApplicationContext context, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.context = context;
    }

    public Parent load(String fxmlPath) throws IOException {      
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean); //Spring is now FXML Controller Factory
        loader.setResources(resourceBundle);
        loader.setLocation(getClass().getResource(fxmlPath));
        return loader.load();
    }
}
