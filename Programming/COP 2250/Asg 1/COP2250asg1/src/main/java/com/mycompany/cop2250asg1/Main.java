package com.mycompany.cop2250asg1;
public class Main{
    public static void main(String[]args){
        Employee john = new Employee("John", 50000);
        System.out.println("ABC Payroll");
        System.out.println("------------------   Employee   -----------------");
        System.out.println("Employee name       :   " + john.getName());
        System.out.println("Salary before bonus :   $" + john.getSalary());
        john.raiseSalary(15);
        System.out.println("Bonus amount        :   $" + john.getBonus());
        System.out.println("Salary after bonus  :   $" + john.getSalary());
        
        System.out.println("------------------   Report End   -----------------");
    }
}

class Employee{
    private String name;
    private double salary;
    private double bonus;

    public Employee(String employeeName, double currentSalary){
        name = employeeName;
        salary = currentSalary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public double getBonus(){
        return bonus;
    }
    public void raiseSalary(double byPercent){
        bonus = salary * (byPercent/100);
        salary = (salary/100) * byPercent + salary;
    }
}

