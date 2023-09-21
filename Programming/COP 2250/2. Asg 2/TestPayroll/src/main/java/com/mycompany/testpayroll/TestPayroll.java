package com.mycompany.testpayroll;

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
        employee1.calculateEmpSalary();
        displaySalary (employee1, nf);

        //Define employee 2

        Payroll employee2 = new Payroll ("555-55555", 20, 50);
        employee2.calculateEmpSalary();
        displaySalary(employee2, nf);

        System.out.println("\tIncrease " + employee1.getIDEmployee() + " by 10 hours");
        employee1.increasedHours(10); // 10 hours increase
        System.out.println("\tEmployee # ...... " + employee1.getIDEmployee ());
        System.out.println("\tHours Worked:.... " + employee1.getHrs() + " hours");
        System.out.println("\tHourly Rate:..... " + nf.format(employee1.getRateHourly()) + "/hour");
        System.out.println("\tYour Salary is .. " + nf.format(employee1.EmpSalary));
        System.out.println("\t------------------------------");

        System.out.println("Total Payout Amount..... " + nf.format(Payroll.getPayTotal()));
        System.out.println("-------------End of Report------------");
    }
    public static void displaySalary (Payroll e, NumberFormat nf){
        System.out.println("\tEmployee # ...... " + e.getIDEmployee ());
        System.out.println("\tHours Worked .... " + e.getHrs() + " hours");
        System.out.println("\tHourly Rate ..... " + nf.format(e.getRateHourly()) + "/hour");
        System.out.println("\tYour Salary is .. " + nf.format(e.calculateEmpSalary()));
        System.out.println("\t------------------------------\n");

    }
}

class Payroll{

    private static double PayTotal;  
    private double Hrs;
    private double RateHourly;
    private String IDEmployee;
    public static double EmpSalary;
    private double HoursIncreased = 10;

    public Payroll (String getIDEmployee, double getHrs, double getRateHourly){
        IDEmployee = getIDEmployee;
        Hrs = getHrs;
        RateHourly = getRateHourly;
        EmpSalary = Hrs * RateHourly;

        PayTotal = PayTotal + EmpSalary;
    }

    public static double getPayTotal(){
        return PayTotal;
    }

    public String getIDEmployee (){
        return IDEmployee;
    }
    public double getHrs (){
        return Hrs;
    }
    public void increasedHours (double increasedHours){
        Hrs = increasedHours + Hrs;
        PayTotal += increasedHours * RateHourly;
    }
    public double getRateHourly(){
        return RateHourly;
    }
    public double calculateEmpSalary(){
        EmpSalary = Hrs * RateHourly; 
        return EmpSalary;
    }
}   