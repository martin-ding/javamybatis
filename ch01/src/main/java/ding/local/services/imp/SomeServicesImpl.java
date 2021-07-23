package ding.local.services.imp;

import ding.local.services.SomeServices;

public class SomeServicesImpl implements SomeServices {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SomeServicesImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void doSome() {
        System.out.println("ddadas");
    }

    @Override
    public void doOther() {

    }
}