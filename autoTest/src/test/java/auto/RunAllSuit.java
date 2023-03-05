package auto;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({FormTest.class,RunAutoTest.class})
public class RunAllSuit {
}
