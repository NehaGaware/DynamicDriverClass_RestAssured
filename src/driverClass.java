import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import sharedfunctions.UtilitySharedFunctions;

public class driverClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//Post_tc_1.execute();
		
         ArrayList<String> testcaserun = UtilitySharedFunctions.readdataexcel("testcases","testcasestoexecute");
         int count = testcaserun.size();
         System.out.println(count);
         
         for(int i=1; i<count; i++)
         {
        	 String testcasename = testcaserun.get(i);
        	 System.out.println(testcasename);
        	 
        	 //call the testcaseclass on runtime by using java.lang.reflect package
        	 
        	 Class<?> testclassname = Class.forName("testClassPackage."+testcasename);
        	 
        	 //call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
        	 Method executemethod = testclassname.getDeclaredMethod("execute");
        	 
        	 //set accessibility of method true
        	 executemethod.setAccessible(true);
        	 
        	 //create the instance of testClassPackage captured in variable name testclassname
        	 Object instanceoftestclass = testclassname.getDeclaredConstructor().newInstance();
        	 
        	 //Execute the testClassPackage captured in variable name testclassPackage name
        	 executemethod.invoke(instanceoftestclass);
        	
        	 
        	 
         }

	}

}
