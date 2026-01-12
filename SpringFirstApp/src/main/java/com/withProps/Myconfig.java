package com.withProps;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.withProps")
@PropertySource("myap.properties")
public class Myconfig {

}
