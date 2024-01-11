package isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
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
        System.out.println("Comanda plasata de:" + cst[0].getName() + " la adresa: Oras- " + ad[0].getCity() + " Strada - " + ad[0].getStreet());
        System.out.print("------------------\nProduse comandate:");
        for (Product product : prod) {
            System.out.println("Categorie- " + product.getProductCategory().toString() + " Produs- " + product.getName());
        }
        System.out.println("Data: " + ord.getDate() + "\nID Comanda: " + ord.getOrderId() + "\nPret total: " + ord.getTotalPrice());
        Product[] prod1 = new Product[5];
        prod1[0] = new Product("P01", "Placa Video", 500.0, ProductCategory.ELECTRONICS);
        prod1[1] = new Product("P02", "Machiaj", 100.0, ProductCategory.BEAUTY);
        prod1[2] = new Product("P03", "Tricou", 150.0, ProductCategory.FASHION);
        prod1[3] = new Product("P04", "Hot-Wheels", 20.0, ProductCategory.TOYS);
        prod1[4] = new Product("P05", "Furtun", 30.0, ProductCategory.HOME_AND_GARDEN);
        Order ord1 = cst[1].placeOrder(prod1);
        System.out.println("\nComanda plasata de:" + cst[1].getName() + " la adresa: Oras- " + ad[1].getCity() + " Strada - " + ad[1].getStreet());
        System.out.print("------------------\nProduse comandate:");
        for (Product product : prod1) {
            System.out.println("Categorie- " + product.getProductCategory().toString() + " Produs- " + product.getName());
        }
        System.out.println("Data: " + ord1.getDate() + "\nID Comanda: " + ord1.getOrderId() + "\nPret total: " + ord1.getTotalPrice());
    }
}
