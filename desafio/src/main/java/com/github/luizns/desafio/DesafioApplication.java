package com.github.luizns.desafio;

import com.github.luizns.desafio.entities.Order;
import com.github.luizns.desafio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;


    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);

    /*
        ConfigurableApplicationContext context = SpringApplication.run(DesafioApplication.class, args);
        Para fechar o contexto manualmente
        context.close();
     */

    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("\n" + "*".repeat(20) + " ENTRADA " + "*".repeat(20));
        System.out.println("(dados do pedido: código, valor básico, porcentagem de desconto)");

        var code = input.nextInt();
        var basic = input.nextDouble();
        var discount = input.nextDouble();
        Order order = new Order(code, basic, discount);

        System.out.println("\n" + "*".repeat(20) + " SAÍDA " + "*".repeat(20));
        System.out.printf("Pedido código %d%n", order.getCode());
        System.out.printf("Valor total: R$ %.2f", orderService.total(order));

        input.close();

    }
}
