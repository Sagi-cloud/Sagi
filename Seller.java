public class Seller extends User {
    private Product[] products = new Product[1];
    private int countProducts;
    private static Seller[] sellers = new Seller[1];
    private static int sellerSize =0;

    public Seller(String user, String password, Product[] products) {
        super(user, password);
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    public static Seller[] getSellers(){return sellers;}
    public static int getSellerSize(){return sellerSize;}
}

