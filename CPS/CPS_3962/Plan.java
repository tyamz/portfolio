package CPS_3962;

import java.io.*;      
abstract class Plan{  
         protected double rate;  
         abstract void getRate();  
   
         public void calculateBill(int units){  
              System.out.println(units*rate);  
          }  
}
class  HousingPlan extends Plan{
     public void getRate(){  
         rate=1000.00;              
    }  
}
class  MealPlan extends Plan{  
	    public void getRate(){   
	        rate=10.50;  
	    }   
}
class  TuitionPlan extends Plan{  
    public void getRate(){   
        rate=5000.00;  
    }   
}
class GetPlanFactory{  
    
	   //use getPlan method to get object of type Plan   
	       public Plan getPlan(String planType){  
	            if(planType == null){  
	             return null;  
	            }  
	          if(planType.equalsIgnoreCase("HOUSINGPLAN")) {  
	                 return new HousingPlan();  
	               }   
	           else if(planType.equalsIgnoreCase("MEALPLAN")){  
	                return new MealPlan();  
	            }   
	          else if(planType.equalsIgnoreCase("TUITIONPLAN")) {  
	                return new TuitionPlan();  
	          }  
	      return null;  
	   }
}   
class GenerateBill {  
    public static void main(String args[]) throws IOException{  
      GetPlanFactory planFactory = new GetPlanFactory();  
        
      System.out.print("Enter the name of plan for which the bill will be generated: ");  
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
      String planName=br.readLine();  
      System.out.print("Enter the number of units for bill will be calculated: ");  
      int units=Integer.parseInt(br.readLine());  
  
      Plan p = planFactory.getPlan(planName);  
      //call getRate() method and calculateBill()method of DomesticPaln.  
  
       System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");  
           p.getRate();  
           p.calculateBill(units);  
    }  
}