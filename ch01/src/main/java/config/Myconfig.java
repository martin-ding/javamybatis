package config;

import ding.local.services.SomeServices;
import ding.local.services.imp.SomeServicesImpl2;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.*;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@ComponentScan(basePackages = "ding")
@PropertySource(value = "classpath:web.properties")
public class Myconfig {
}