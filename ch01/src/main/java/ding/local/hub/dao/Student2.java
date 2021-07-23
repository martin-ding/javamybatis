package ding.local.hub.dao;

import ding.local.dao.School;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Student2 {

    @Value("hub")
    String name;

    @Resource
    School school;

    public void call() {
        System.out.println("student function call........");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}