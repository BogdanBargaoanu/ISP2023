package isp.lab6.exercise3;

public class Product {
    public String name;
    public int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        boolean b;
        return b = this.hashCode() == product.hashCode();
    }

    public String toString() {
        return "Nume produs: " + name + "  ---- pret: " + price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
