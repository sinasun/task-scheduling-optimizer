package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestEmployee.class, TestTask.class, TestScheduler.class}) 
public class TestSuite {

}
