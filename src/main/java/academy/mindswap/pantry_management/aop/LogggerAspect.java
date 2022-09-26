package academy.mindswap.pantry_management.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


//Advice -> What   -> Before, after   PointCut -> where    Cross cutting concerns -> Aspect

@Aspect
//@Component   -> gives a error
//@EnableAspectJAutoProxy

public class LogggerAspect {

    private final void SEPARATION(){
        System.out.println("--+--".repeat(30));
    }

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        SEPARATION();
        Object proceed = joinPoint.proceed();

        // SomethingDTO changedSomething = (somethingDto) proceed;
        //changedSomething.setName("nameChanged");

        long executionTime = System.currentTimeMillis() - start;
        SEPARATION();
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        SEPARATION();


        return proceed;
    }

    @Before("execution(public void show())")

    public void log() {
        System.out.println("method is called");
    }

}