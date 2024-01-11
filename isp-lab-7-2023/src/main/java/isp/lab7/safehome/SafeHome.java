package isp.lab7.safehome;

import java.util.HashMap;
import java.util.Map;

public class SafeHome {

    public static void main(String[] args) throws Exception {
        Door door = new Door(DoorStatus.CLOSE);
        Map<Tenant, AccessKey> validAcc = new HashMap<>();
        DoorLockController ctrl = new DoorLockController(door, validAcc);
        ctrl.addTenant("123", "asd");
        Tenant tenant = new Tenant("asd");
        AccessKey accessKey = new AccessKey("123");
        System.out.println(validAcc.containsKey(tenant));
        System.out.println(validAcc.containsValue(accessKey));
        DoorStatus d = ctrl.enterPin("123");
        if (DoorStatus.OPEN == d) {
            System.out.println("tst1");
        }
        d = ctrl.enterPin("123");
        if (DoorStatus.OPEN == d) {
            System.out.println("tst2");
        }
        ctrl.addTenant("1111", "Andi");
        Tenant tenant1 = ctrl.getTenant("1111");
        if (tenant1 != null) {
            System.out.println(tenant1.getName());
        }
    }
}
