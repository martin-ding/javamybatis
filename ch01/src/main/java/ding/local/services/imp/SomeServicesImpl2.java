package ding.local.services.imp;

import ding.local.services.SomeServices;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Component
public class SomeServicesImpl2 implements SomeServices {
    @Override
    public void doSome() {
        System.out.println("222222");
    }

    @Override
    public void doOther() {

    }
}