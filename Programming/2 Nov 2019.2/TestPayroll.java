package TestPayroll;

import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;

public class TestPayroll{

    public static void main (String [] arg){
        //Set up the formatters
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance();
        NumberFormat nf = NumberFormat.getCurrencyInstance();


        System.out.println("ABC Company");
        System.out.println ("\nPayroll For Week Ending " + df.format (d));
        System.out.println("--------------------------------------");

        //Define employee 1

        Payroll employee1 = new Payroll ("444-4444", 30, 25);
        employee1.calculateSalary();
        displaySalary (employee1, nf);

        //Define employee 2

        Payroll employee2 = new Payroll ("555-55555", 20, 50);
        employee2.calculateSalary();
        displaySalary(employee2, nf);

        System.out.println("\tIncrease " + employee1.getEmployeeId() + " by 10 hours");
        employee1.increaseHours(10); // 10 hours increase
        System.out.println("\tEmployee # ...... " + employee1.getEmployeeId ());
        System.out.println("\tHours Worked:.... " + employee1.getHours() + " hours");
        System.out.println("\tHourly Rate:..... " + nf.format(employee1.getHourly_Rate()) + "/hour");
        System.out.println("\tYour Salary is .. " + nf.format(employee1.Salary));
        System.out.println("\t------------------------------");

        System.out.println("Total Payout Amount..... " + nf.format(Payroll.getTotalPayout()));
        System.out.println("-------------End of Report------------");
    }
    public static void displaySalary (Payroll e, NumberFormat nf){
        System.out.println("\tEmployee # ...... " + e.getEmployeeId ());
        System.out.println("\tHours Worked .... " + e.getHours() + " hours");
        System.out.println("\tHourly Rate ..... " + nf.format(e.getHourly_Rate()) + "/hour");
        System.out.println("\tYour Salary is .. " + nf.format(e.calculateSalary()));
        System.out.println("\t------------------------------\n");

    }
}

class Payroll{

    private static double TotalPayout;  
    private double Hours;
    private double Hourly_Rate;
    private String EmployeeId;
    public static double Salary;
    private double increaseHours = 10;

    public Payroll (String getEmployeeId, double getHours, double getHourly_Rate){
        EmployeeId = getEmployeeId;
        Hours = getHours;
        Hourly_Rate = getHourly_Rate;
        Salary = Hours * Hourly_Rate;

        TotalPayout = TotalPayout + Salary;
    }

    public static double getTotalPayout(){
        return TotalPayout;
    }

    public String getEmployeeId (){
        return EmployeeId;
    }
    public double getHours (){
        return Hours;
    }
    public void increaseHours (double increaseHours){
        Hours = increaseHours + Hours;
        TotalPayout += increaseHours * Hourly_Rate;
    }
    public double getHourly_Rate(){
        return Hourly_Rate;
    }
    public double calculateSalary(){
        Salary = Hours * Hourly_Rate; 
        return Salary;
    }
}   