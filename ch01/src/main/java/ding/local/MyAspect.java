package ding.local;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Aspect 是AspectJ框架带有的注解，表示这个类是切面类
 *         切面类：给基本类提供额外功能的类
 *         使用在类的定义上
 */
@Component
@Aspect
public class MyAspect {
    /**
     * 定义方法，方法实现切面功能
     * 方法定义要求
     *  1.public
     *  2.无返回值，方法名任意
     *  3.可以有参数也可以无参数
     *      有参数的只能从几个参数中进行选择，不是自定义的
     */

    /**
     * @Before 前置通知注解，
     * 属性：value，是切面表达式，会在目标方法前面执行
     * 位置：放在方法上面
     */
    //before执行的时机， execution表达式执行的位置
    @Before(value = "execution(* ding.local.dao.Student.call(..))")
    public void myBefore() {
        //执行的功能
        System.out.println("before");
    }

    @AfterReturning(pointcut = "execution(* ding.local.dao.Student.call(..)))", returning = "varl")
    public void myAfterReturning(Object varl) {
        System.out.println("returning is " + varl);
    }

    @Around(value = "execution(* ding.local.dao.Student.call(..)))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.getThis().getClass().getCanonicalName());
        // 甚至可以修改参数等
        System.out.println("around before .....");
        try {
            Object res = pjp.proceed();//相当于method.invoke
        }catch (Exception e) {
            System.out.println("around after.....");
//            throw new RuntimeException(e);
        }
        return "res";
    }

    @AfterThrowing(value = "execution(* ding.local.dao.Student.call(..)))", throwing = "ex")
    public void afterReturning(JoinPoint jp,Exception ex) {
        System.out.println(jp.getArgs().toString());
    }


}