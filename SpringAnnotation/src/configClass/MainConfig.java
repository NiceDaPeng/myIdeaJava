package configClass;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"controller","service","dao"})
@Import(ConfigClass.class)
public class MainConfig {

}
