package tn.esprit.examenblancuserproject.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    //tn.esprit.esponline.service.StockServiceImpl.*(..))")
    @After("execution(* tn.esprit.examenblancuserproject.services.ImpService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Type type = joinPoint.getSignature().getDeclaringType();

            log.info("Success method " + name + " : ");


    }

}
