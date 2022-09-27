package academy.mindswap.pantry_management.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Order(0)
@Aspect
@Configuration
@Slf4j
public class LogAspect {

    @Around("academy.mindswap.pantry_management.aop.AppPointCuts.mainPointCut()")
    public Object calculateMethodTimeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        final Logger classLogger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        if (!classLogger.isDebugEnabled()) {
            return joinPoint.proceed();
        }

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String methodArgs = Stream.of(joinPoint.getArgs()).toList().toString();

        long startTime = System.nanoTime();
        Object result = joinPoint.proceed(); // actual logic call
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        LoggerMessage message = LoggerMessage.builder()
                .className(className)
                .methodName(methodName)
                .methodArgs(methodArgs)
                .ElapsedTimeInMillis(TimeUnit.NANOSECONDS.toMillis(elapsedTime))
                .ElapsedTimeInMicros(TimeUnit.NANOSECONDS.toNanos(elapsedTime))
                .result(result)
                .build();

        classLogger.info("LogAspect : {}", message);


        return result;
    }
}
