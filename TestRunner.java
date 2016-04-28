import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


	
	public class TestRunner {

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
	            		,EnemyTest.class,EnemyTest.class,EnemyTest.class,EnemyTest.class
	            		,LevelUpTest.class,LevelUpTest.class,LevelUpTest.class);



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


