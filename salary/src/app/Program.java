package app;

import entities.Employee;
import service.BrazilTaxService;
import service.PensionService;
import service.SalaryService;
import service.TaxService;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Salário Bruto: ");
        double grossSalary = sc.nextDouble();

        Employee employee = new Employee(name, grossSalary);

        PensionService pensionService = new PensionService();
        TaxService taxService = new BrazilTaxService();
        SalaryService salaryService = new SalaryService(taxService, pensionService);
        double netSalary = salaryService.netSalary(employee);
        System.out.printf("Salário Líquido = R$ %.2f%n", netSalary);

        sc.close();
    }
}
