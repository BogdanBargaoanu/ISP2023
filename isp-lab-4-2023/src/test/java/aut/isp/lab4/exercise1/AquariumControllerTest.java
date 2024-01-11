package aut.isp.lab4.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AquariumControllerTest {
    @Test
    public void testAquarium() {
        AquariumController a = new AquariumController("XLARGE", "AquaIND", 10.30F);
        AquariumController a1 = new AquariumController();
        assertEquals("Producator: AquaIND modelul: XLARGE ora:10:30", a.toString());
        assertEquals("Producator: Necunoscut modelul: Necunoscut ora:0:00", a1.toString());

    }
}
