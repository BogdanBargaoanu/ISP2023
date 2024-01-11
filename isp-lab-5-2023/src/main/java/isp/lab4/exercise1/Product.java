package isp.lab4.exercise1;

public class Product {
    private String productId;
    private String name;
    private double price;
    private ProductCategory productCategory;

    public Product() {
        productId = "Necunoscut";
        name = "Necunoscut";
        price = 0;
        productCategory = null;
    }

    public Product(String productId, String name, double price, ProductCategory productCategory) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
