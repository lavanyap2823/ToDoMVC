package com.config;


import org.aeonbits.owner.Config;

@Config.Sources({"file:src//test//resources/config.properties"})
public interface TestDataManager extends Config {

    String browser();
    String url();
    String newtodo1();
    String newtodo2();
    String newtodo3();
}
