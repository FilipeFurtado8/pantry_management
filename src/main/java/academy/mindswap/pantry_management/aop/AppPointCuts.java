package academy.mindswap.pantry_management.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppPointCuts {
   @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controllerPointCut() {
       //NO-OP
       }

   @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void servicePointCut() {
       // NO-OP
   }

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryPointCut() {
       // NO-Op
    }

    @Pointcut("execution(* academy.mindswap.pantry_management..*(..))")
    public void appPointCut() {
       // NO-OP
    }

    @Pointcut("appPointCut() && (controllerPointCut() || servicePointCut() || repositoryPointCut())")
    public void mainPointCut() {
        // NO-OP
    }


}
