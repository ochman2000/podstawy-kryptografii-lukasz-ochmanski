package pl.lodz.p.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BitArrayTest.class, DecryptTest.class, EncryptTest.class,
		UtilsTest.class })
public class AllTests {

}
