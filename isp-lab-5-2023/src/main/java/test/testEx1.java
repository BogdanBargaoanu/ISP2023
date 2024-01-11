package test;

import isp.lab4.exercise1.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testEx1 {
    @Test
    public void testEx1v1() {
        Address[] ad = new Address[2];
        ad[0] = new Address("Observatorului", "Cluj-Napoca");
        ad[1] = new Address("Rodnei", "Bucuresti");
        Customer[] cst = new Customer[2];
        cst[0] = new Customer("C01", "Andrei", "078xx", ad[0]);
        cst[1] = new Customer("C02", "Mihai", "026xx", ad[1]);
        Product[] prod = new Product[3];
        prod[0] = new Product("P01", "Placa Video", 500.0, ProductCategory.ELECTRONICS);
        prod[1] = new Product("P02", "Machiaj", 100.0, ProductCategory.BEAUTY);
        prod[2] = new Product("P03", "Tricou", 150.0, ProductCategory.FASHION);
        Order ord = cst[0].placeOrder(prod);
        LocalDateTime now = LocalDateTime.now();
        assertEquals("C01100", ord.getOrderId());
        assertEquals(now.withNano(0), ord.getDate()); //poate da fail cand e foarte aproape de sec urmatoare la apelare
        assertEquals(750, ord.getTotalPrice());
        assertEquals(prod, ord.getProducts());
    }
}
