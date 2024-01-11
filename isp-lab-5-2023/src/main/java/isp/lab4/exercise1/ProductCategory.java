package isp.lab4.exercise1;

/**
 * @author Radu Miron
 */
public enum ProductCategory {
    ELECTRONICS("Electronics & Gadgets"),
    FASHION("Fashion"),
    HOME_AND_GARDEN("Home & Garden"),
    BEAUTY("Beauty"),
    TOYS("Toys");


    private String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
