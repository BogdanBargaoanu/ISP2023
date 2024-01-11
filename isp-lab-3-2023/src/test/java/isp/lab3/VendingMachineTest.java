package isp.lab3;

import isp.lab3.exercise5.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    @Test
    public void testdisplayProducts() {
        VendingMachine v1 = new VendingMachine();
        assertEquals("1 - Coca-Cola\n2 - Pepsi\n3 - Mars\n", v1.displayProducts());
    }

    @Test
    public void testselectProduct() {
        VendingMachine v2 = new VendingMachine();
        assertEquals("Selectie invalida", v2.selectProduct(4));
        v2.insertCoin(100);
        assertEquals("S-a cumparat Coca-Cola", v2.selectProduct(1)); //0 monede dupa terminarea comenzii
        assertEquals("Credit insuficient", v2.selectProduct(1));
    }

    @Test
    public void testinsertCoin() {
        VendingMachine v3 = new VendingMachine();
        assertEquals(0, v3.displayCredit());
        v3.insertCoin(122);
        assertEquals(122, v3.displayCredit());
    }
}
