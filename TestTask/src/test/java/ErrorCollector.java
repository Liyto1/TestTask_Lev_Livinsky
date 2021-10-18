import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ErrorCollector {
    public static void errorCollector () {
        Result result = JUnitCore.runClasses(MainPageTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Result: " + result.wasSuccessful());
    }
}
