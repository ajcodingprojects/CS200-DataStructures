import worker.*;
import org.junit.*;
import java.util.*;
import java.lang.reflect.*;


public class WorkerHierarchyStructureTest {
  
  // NOTE: In this test class, every test method uses a different Worker object(s)
  // so there are no instance variables, and there is no @Before method.
  
  //Helper method to check if a given class contains the expected instance fields and methods 
  private void testStructure(Class c, Map<String,String> allFields, Map<String,String> allMethods) throws SecurityException{      
    
    //System.out.println(c);
    Field[] fields = c.getDeclaredFields();
    Assert.assertEquals(c.getName() + " should have " + allFields.size() + " declared fields", 
                        allFields.size(), fields.length);    
    //System.out.println(allFields);
    for (Field f: fields){
      //System.out.println(f);
      //System.out.println(f.getType() +"|" + f.getName() + "|" + f.getModifiers());
      Assert.assertTrue(c.getName() + " should contain field: private " + f.getType() +" " + f.getName(),
                        allFields.containsKey(f.getName()) && 
                        allFields.get(f.getName()).equals(f.getType().getName()) && 
                        (Modifier.isPrivate(f.getModifiers())));

    }
    Method[] methods = c.getDeclaredMethods();
    Assert.assertEquals(c.getName() + " should have " + allMethods.size() + " declared methods", 
                        allMethods.size(), methods.length);
    //System.out.println(allMethods);
    for (Method m: methods){
      //System.out.println(m);
      // System.out.println(allMethods.containsKey(m.getName()));
      // System.out.println(m.getReturnType().getName() + "==" + allMethods.get(m.getName()) + ":" + allMethods.get(m.getName()).equals(m.getReturnType().getName()) );
      //System.out.println(Modifier.isPublic(m.getModifiers()));        
      //System.out.println(m.getReturnType() +"|" + m.getName() + "|" + m.getModifiers());
      Assert.assertTrue(c.getName() + " should contain method: public " + m.getReturnType() +" " + m.getName(), 
                        allMethods.containsKey(m.getName()) && 
                        allMethods.get(m.getName()).equals(m.getReturnType().getName()) && 
                        (Modifier.isPublic(m.getModifiers())));     
      
    }
  }
  
  //@Test
  public void testWorkerInterfaceStructure(){      
    Class<worker.Worker> w = worker.Worker.class;
    Assert.assertTrue("worker.Worker is an interface that extends java.io.Serializable : " ,  
                      w.getPackage().getName().equals("worker") && 
                      w.isInterface() &&
                      w.getInterfaces()[0].getName().equals("java.io.Serializable"));
    Map<String,String> allFields = new HashMap<String,String>();
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("equals", "boolean");
        put("toString", "java.lang.String");
        put("hashCode","int");
        put("getName","java.lang.String");
      }
    };
    testStructure(w,allFields,allMethods);
  }
  
  @Test
  public void testHourlyWorkerClassStructure(){  
    Class<worker.HourlyWorker> hw = worker.HourlyWorker.class;
    Assert.assertTrue("worker.HourlyWorker is an abstract class that implements worker.Worker : " ,  
                      hw.getPackage().getName().equals("worker") && 
                      !hw.isInterface() &&
                      Modifier.isAbstract(hw.getModifiers()) &&
                      hw.getInterfaces()[0].getName().equals("worker.Worker"));
    Map<String,String> allFields = new HashMap<String,String>(){
      {
        put("hours", "int");
        put("name", "java.lang.String");
      }
    };      
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("equals", "boolean");
        put("getHours", "int");
        put("addHours", "void");
        put("resetHours", "void");        
        put("hashCode","int");
        put("getName","java.lang.String");
      }
    };
    testStructure(hw,allFields,allMethods);
  }  
  
  @Test
  public void testEmployeeInterfaceStructure(){      
    Class<worker.Employee> e = worker.Employee.class;
    Assert.assertTrue("worker.Employee is an interface that extends worker.Worker : " ,  
                      e.getPackage().getName().equals("worker") && 
                      e.isInterface() && 
                      e.getInterfaces()[0].getName().equals("worker.Worker"));
    Map<String,String> allFields = new HashMap<String,String>();      
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getMonthlyPay", "double");
      }
    };
    testStructure(e,allFields,allMethods);
  }   
  
  @Test
  public void testHourlyEmployeeClassStructure(){      
    Class<worker.HourlyEmployee> he = worker.HourlyEmployee.class;
    Assert.assertTrue("worker.HourlyEmployee is a class that implements worker.Employee and extends worker.HourlyWorker : " ,  
                      he.getPackage().getName().equals("worker") && 
                      !he.isInterface() &&
                      !Modifier.isAbstract(he.getModifiers()) &&
                      he.getInterfaces()[0].getName().equals("worker.Employee") && 
                      he.getSuperclass().getName().equals("worker.HourlyWorker"));    
    Map<String,String> allFields = new HashMap<String,String>(){
      {
        put("hourlyPay", "double");
      }
    };      
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getMonthlyPay", "double");
        put("getHourlyPay", "double");
        put("setHourlyPay", "void");
        put("toString", "java.lang.String");        
      }
    };
    testStructure(he,allFields,allMethods);
  }   
  
  @Test
  public void testSalariedEmployeeClassStructure(){      
    Class<worker.SalariedEmployee> se = worker.SalariedEmployee.class;
    Assert.assertTrue("worker.SalariedEmployee is a class that implements worker.Employee : " ,  
                      se.getPackage().getName().equals("worker") && 
                      !se.isInterface() &&
                      !Modifier.isAbstract(se.getModifiers()) &&
                      se.getInterfaces()[0].getName().equals("worker.Employee"));       
    Map<String,String> allFields = new HashMap<String,String>(){
      {
        put("monthlySalary", "double");
        put("name", "java.lang.String");
      }
    };      
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("getMonthlyPay", "double");
        put("setMonthlyPay", "void");
        put("toString", "java.lang.String");  
        put("hashCode","int");
        put("getName","java.lang.String");    
        put("equals", "boolean");
      }
    };
    testStructure(se,allFields,allMethods);    
  }   
  
  @Test
  public void testVolunteerClassStructure(){      
    Class<worker.Volunteer> v = worker.Volunteer.class;
    Assert.assertTrue("worker.Volunteer is a class that implements extends worker.HourlyWorker : " ,  
                      v.getPackage().getName().equals("worker") && 
                      !v.isInterface() &&
                      !Modifier.isAbstract(v.getModifiers()) &&
                      v.getSuperclass().getName().equals("worker.HourlyWorker"));     
    Map<String,String> allFields = new HashMap<String,String>();
    Map<String,String> allMethods = new HashMap<String,String>() {
      {
        put("toString", "java.lang.String");
      }
    };
    testStructure(v,allFields,allMethods);
  }  

  /**
   * Test that Worker volunteerWorker is an instance of Worker,
   * HourlyWorker, and Volunteer, but not an instance of Employee,
   * HourlyEmployee, or SalariedEmployee.
   */   
  @Test
  public void testPolymorphismForVolunteers() {
    // create a Volunteer worker with name "VolunteerWorker"
    Worker volunteerWorker = new Volunteer("VolunteerWorker");

    Assert.assertTrue( "Volunteers are Workers",
                       volunteerWorker instanceof Worker);
    Assert.assertTrue( "Volunteers are HourlyWorkers",
                       volunteerWorker instanceof HourlyWorker);
    Assert.assertTrue( "Volunteers are Volunteers",
                       volunteerWorker instanceof Volunteer);
    Assert.assertFalse("Volunteers are NOT Employees",
                       volunteerWorker instanceof Employee);
    Assert.assertFalse("Volunteers are NOT HourlyEmployees",
                       volunteerWorker instanceof HourlyEmployee);
    Assert.assertFalse("Volunteers are NOT SalariedEmployees",
                       volunteerWorker instanceof SalariedEmployee);
  }
  
  /**
   * Test that Worker hourlyEmployeeWorker is an instance of Worker,
   * HourlyWorker, Employee, and HourlyEmployee,
   * but not an instance of Volunteer or SalariedEmployee
   */   
  @Test
  public void testPolymorphismForHourlyEmployees(){
    // create an HourlyEmployee worker with name "HourlyEmployeeWorker"
    // 20 hours, and $10.50 hourlyPay 
    Worker hourlyEmployeeWorker =
      new HourlyEmployee("HourlyEmployeeWorker", 20, 10.5);

    Assert.assertTrue ("HourlyEmployees are Workers",
                       hourlyEmployeeWorker instanceof Worker);
    Assert.assertTrue ("HourlyEmployees are HourlyWorkers",
                       hourlyEmployeeWorker instanceof HourlyWorker);
    Assert.assertTrue ("HourlyEmployees are Employees",
                       hourlyEmployeeWorker instanceof Employee);
    Assert.assertTrue ("HourlyEmployees are HourlyEmployees",
                       hourlyEmployeeWorker instanceof HourlyEmployee);
    Assert.assertFalse("HourlyEmployees are NOT Volunteers",
                       hourlyEmployeeWorker instanceof Volunteer);
    Assert.assertFalse("HourlyEmployees are NOT SalariedEmployees",
                       hourlyEmployeeWorker instanceof SalariedEmployee);
  }
  
  /**
   * Test that Worker salariedEmployeeWorker is an instance of Worker,
   * Employee, and SalariedEmployee but not an instance of
   * Volunteer or HourlyWorker.
   */   
  @Test
  public void testPolymorphismForSalariedEmployees(){
    // create an SalariedEmployee worker with name "SalariedEmployeeWorker"
    // and $5000.00 monthlySalary   
    Worker salariedEmployeeWorker =
       new SalariedEmployee("SalariedEmployeeWorker", 5000);

    Assert.assertTrue ("SalariedEmployees are Workers",
                       salariedEmployeeWorker instanceof Worker);
    Assert.assertTrue ("SalariedEmployees are Employees",
                       salariedEmployeeWorker instanceof Employee);
    Assert.assertTrue ("SalariedEmployees are SalariedEmployees",
                       salariedEmployeeWorker instanceof SalariedEmployee);
    Assert.assertFalse("SalariedEmployees are NOT HourlyWorkers",
                       salariedEmployeeWorker instanceof HourlyWorker);    
    Assert.assertFalse("SalariedEmployees are NOT Volunteers",
                       salariedEmployeeWorker instanceof Volunteer);
    Assert.assertFalse("SalariedEmployees are NOT HourlyEmployees",
                       salariedEmployeeWorker instanceof HourlyEmployee);
  }   
}