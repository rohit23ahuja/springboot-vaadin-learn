package dev.rohitahuja;

import com.vaadin.flow.component.page.Push;
import dev.rohitahuja.tools.EmailConfigProperties;
import dev.rohitahuja.tools.WeatherConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({WeatherConfigProperties.class, EmailConfigProperties.class})
@Push
@SpringBootApplication
@Theme("doc-chat")
public class SpringbootVaadinLearnApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootVaadinLearnApplication.class, args);
    }
}
