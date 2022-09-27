package academy.mindswap.pantry_management.aop;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LoggerMessage {
    private String className;
    private String methodName;
    private String methodArgs;
    private Long ElapsedTimeInMillis;
    private Long ElapsedTimeInMicros;
    private Object result;

    @SneakyThrows
    @Override
    public String toString() {
        return "LoggerMessage{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodArgs='" + methodArgs + '\'' +
                ", ElapsedTimeInMillis=" + ElapsedTimeInMillis +
                ", ElapsedTimeInNanos=" + ElapsedTimeInMicros +
                ", result=" + this.result +
                '}';
    }
}
