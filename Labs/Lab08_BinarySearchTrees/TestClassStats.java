import org.junit.*;
import java.lang.reflect.*;
import java.lang.annotation.*;
import zhstructures.*;
import java.lang.invoke.*;

public class TestClassStats{
  
  protected boolean passed;  
  protected static int countOfTests = 0;
  protected static int countOfTestsPassed = 0;
   
  public static String tallyStats(Class me){    
    Method[] methods = me.getDeclaredMethods();
    for (Method method : methods) {
      Annotation[] annotations = method.getDeclaredAnnotations();
      for (Annotation annotation : annotations) {
        if (annotation.annotationType().toString().equals("interface org.junit.Test")) {
          countOfTests++;
        }
      }
    }
    String retStats = "\nTesting summary for class " + me.getName() + " : passed " + countOfTestsPassed + " / " + countOfTests;        
    countOfTests = 0;
    countOfTestsPassed = 0;
    return retStats;
  }   
  
  @Before
  public void resetStatus(){
    passed = false;
  }  
  
  @After
  public void updateStats(){
    if (passed){
      countOfTestsPassed++;
    }
  }   
}

