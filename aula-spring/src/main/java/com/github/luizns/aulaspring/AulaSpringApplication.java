package com.github.luizns.aulaspring;

import com.github.luizns.aulaspring.entities.Employee;
import com.github.luizns.aulaspring.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaSpringApplication implements CommandLineRunner {

    @Autowired
    private SalaryService salaryService;

    public static void main(String[] args) {
        SpringApplication.run(AulaSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee("Luiz", 4000.0);

        System.out.printf("Salário Líquido = R$ %.2f%n", salaryService.netSalary(employee));
    }
}
