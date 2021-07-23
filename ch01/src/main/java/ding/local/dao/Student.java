package ding.local.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Observable;

@Component
public class Student implements mm{

    @Value("zhangsan")
    String name;

    @Resource
    School school;

    public Object call() {
        System.out.println("student function call........");
        int a = 10 / 0;
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", school=" + school +
                '}';
    }
}