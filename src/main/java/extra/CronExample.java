import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CronExample {

    public static LocalDateTime getNextExecutionTime(LocalDateTime previousExecutionTime, String cron, int fixedDelay) {
        if (cron.startsWith("FIXED_DELAY_CRON")) {
            cron = cron.replace("FIXED_DELAY_CRON ", "");
            CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.SPRING);
            CronParser parser = new CronParser(cronDefinition);
            ExecutionTime executionTime = ExecutionTime.forCron(parser.parse(cron));
            LocalDateTime nextTime = executionTime.nextExecution(previousExecutionTime.atZone(ZoneId.systemDefault())).get().toLocalDateTime();
            long duration = Duration.between(previousExecutionTime, nextTime).toSeconds();
            if (duration > fixedDelay && duration < fixedDelay * 2) {
                return previousExecutionTime.plusSeconds(fixedDelay);
            } else {
                LocalDateTime previousPreviousTime = getLastExecutionTime(previousExecutionTime, cron, fixedDelay);
                duration = Duration.between(previousPreviousTime, previousExecutionTime).toSeconds() % fixedDelay;
                return nextTime.plusSeconds(duration);
            }
        } else {
            CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.SPRING);
            CronParser parser = new CronParser(cronDefinition);
            ExecutionTime executionTime = ExecutionTime.forCron(parser.parse(cron));
            return executionTime.nextExecution(previousExecutionTime.atZone(ZoneId.systemDefault())).get().toLocalDateTime();
        }
    }

    public static LocalDateTime getLastExecutionTime(LocalDateTime previousExecutionTime, String cron, int fixedDelay) {
        CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.SPRING);
        CronParser parser = new CronParser(cronDefinition);
        ExecutionTime executionTime = ExecutionTime.forCron(parser.parse(cron));
        return executionTime.lastExecution(previousExecutionTime.atZone(ZoneId.systemDefault())).get().toLocalDateTime().withSecond(0);
    }

    public static void main(String[] args) {
        String cron = "FIXED_DELAY_CRON * */10 9-18 * * *";
//        String cron = "* */10 9-18 * * *";
        LocalDateTime previousExecutionTime = LocalDateTime.of(2023, 4, 8, 19, 6, 3);
        int fixedDelay = 600;
        System.out.println("NEXT TIME : " + getNextExecutionTime(previousExecutionTime, cron, fixedDelay));

    }
}