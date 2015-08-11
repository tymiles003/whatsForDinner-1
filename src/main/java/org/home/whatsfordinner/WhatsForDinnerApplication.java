package org.home.whatsfordinner;

import org.home.whatsfordinner.config.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
@ComponentScan
public class WhatsForDinnerApplication {

    public static void main(String[] args) {
        final SpringApplication app = new SpringApplication(WhatsForDinnerApplication.class);
        app.setShowBanner(false);
        final SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        addDefaultProfile(app, source);
        app.run(args);
    }

    /**
     * Set a default profile if it has not been set
     */
    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }
    }
}
