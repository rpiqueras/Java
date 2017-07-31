package monitors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MonitoringCircuit {

	@AfterReturning(value = "execution(* models.Circuit.difficulty(..))", returning = "difficultyValue")
	public void movingKart(JoinPoint joinPoint, int difficultyValue){
		System.out.println(joinPoint.getThis().toString() + " Circuit difficulty: " + difficultyValue);
	}
}
