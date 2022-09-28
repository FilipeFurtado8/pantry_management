package academy.mindswap.pantry_management.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import static academy.mindswap.pantry_management.utils.Messages.*;

@Configuration
public class AppPointCuts {
   @Pointcut(CONTROLLER_POINT_CUT)
    public void controllerPointCut() {
       //NO-OP
       }

   @Pointcut(SERVICE_POINT_CUT)
    public void servicePointCut() {
       // NO-OP
   }

    @Pointcut(REPOSITORY_POINT_CUT)
    public void repositoryPointCut() {
       // NO-Op
    }

    @Pointcut(APP_POINT_CUT)
    public void appPointCut() {
       // NO-OP
    }

    @Pointcut(MAIN_POINT_CUT)
    public void mainPointCut() {
        // NO-OP
    }
}