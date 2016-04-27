import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * TestRunner runs all of the different tests for all the classes. Some are called repeatedly to ensure 
 * proper function, others that include GUI are only ran once. It also prints out the number of tests ran,
 * successful tests, and tests that failed. If it failed, it sysout why it failed.
 */
	public class TestRunner {

		/**
		 * TestRunner runs all of the different tests for all the classes. Some are called repeatedly to ensure 
		 * proper function, others that include GUI are only ran once. It also prints out the number of tests ran,
		 * successful tests, and tests that failed. If it failed, it sysout why it failed.
		 */
	    @Test
	    public void myTestRunner() {

	            Result result = JUnitCore.runClasses(CharacterTest.class,CharacterTest.class
	            		,CharacterTest.class,CharacterTest.class,CharacterTest.class
	            		,CharacterTest.class,CharacterTest.class,CharacterTest.class
	            		,CharacterTest.class,CharacterTest.class,CharacterTest.class
	            		,CharacterTest.class,CharacterTest.class,CharacterTest.class
	            		,CharacterTest.class,CharacterTest.class,CharacterTest.class
	            		,HeroTest.class,HeroTest.class,HeroTest.class,HeroTest.class
	            		,HeroTest.class,HeroTest.class,HeroTest.class,HeroTest.class
	            		,HeroTest.class,HeroTest.class,HeroTest.class,HeroTest.class
	            		,HeroTest.class,HeroTest.class,HeroTest.class,HeroTest.class
	            		,EnemyTest.class,EnemyTest.class,EnemyTest.class,EnemyTest.class
	            		,EnemyTest.class,EnemyTest.class,EnemyTest.class,EnemyTest.class
	            		,EnemyTest.class,EnemyTest.class,EnemyTest.class,EnemyTest.class);

	        System.out.println("Tests run: " + result.getRunCount());

	        System.out.println("Tests successful: " + (result.getRunCount() - result.getFailureCount()));
	        System.out.println("Tests failed: " + result.getFailureCount());

	        if (result.getFailureCount() > 0)
	            System.out.println("\nList of failures:");
	        for (Failure failure : result.getFailures()) {
	            System.out.println(failure.toString());

	        }
	    }
	}


