import java.util.Scanner;

public class Buyer {
    private String userName;
    private String password;
    private String adress;
    private static Buyer[] buyers = new Buyer[1];
    private static int sizeBuyers = 0;
    private Product[] shoppingCart;
    private int countProducts=0;

    public Buyer(String name, String password, String adress) {
        this.userName = name;
        this.password = password;
        this.adress = adress;
        this.shoppingCart = new Product[1];
    }
    public Buyer()
    {
        this.userName ="Name";
        this.password = "password";
        this.adress = "adress";

    }
    public static void addBuyer(Buyer buyer)
    {
        Buyer b1= new Buyer();
        b1.validateArrBuyers();
        buyers[sizeBuyers] = buyer;
        sizeBuyers++;
    }

    public static Tuple isExist(String name) {
        if (buyers[0] == null) {
            return new Tuple(false,-1);
        }
        for (int i = 0; i < sizeBuyers; i++) {
            if (buyers[i].getUserName().equalsIgnoreCase(name)) {
                return new Tuple(true,i);
            }
        }
        return new Tuple(false,-1);
    }


    public static void printListBuyers() {
        for (int i = 0; i < sizeBuyers; i++) {
            System.out.println("Buyer{" +
                    "userName='" + buyers[i].getUserName() + '\'' +
                    ", password='" + buyers[i].getPassword() + '\'' +
                    ", adress='" + buyers[i].getAdress() + '\'' +
                    '\n'+"The Shopping card is: " + buyers[i].printListProducts()) ;
        }
    }
    public String printListProducts() {
        StringBuilder str = new StringBuilder();
        for (Product product : shoppingCart) {
            if (product != null)
                str.
                        append(product.toString()).append("\n");
        }
        return str.toString();
    }

    private  void validateArrBuyers() {
        if (sizeBuyers == buyers.length) {
            int newSize = sizeBuyers * 2;
            newSize = Math.max(2, newSize);
            Buyer[] temp = new Buyer[newSize];
            for (int i = 0; i < buyers.length; i++) {
                temp[i] = buyers[i];//new Buyer(buyers[i].getUserName(), buyers[i].getPassword(), buyers[i].getAdress());
            }
            buyers = temp;
        }

    }
    private void  validateArrProduct()
    {
        if(this.countProducts == this.shoppingCart.length){
            int newSize = this.countProducts * 2;
            newSize = Math.max(2, newSize);
            Product[] temp = new Product[newSize];
            for (int i = 0; i < this.shoppingCart.length; i++) {
                temp[i] = this.shoppingCart[i];
            }
            this.shoppingCart = temp;
        }

    }
    public static void addProductToBuyer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the buyer name :  ");
        String buyerName = scanner.next();
        while (!isExist(buyerName).getExist())
        {
            System.out.println("The Buyer name is not exist pls try again");
            buyerName = scanner.next();
        }
        System.out.println("from who Seller you want to buy : ");
        String sellerName = scanner.next();
        while (!Seller.isExist(sellerName).getExist())
        {
            System.out.println("The Seller name is not exist pls try again");
            sellerName = scanner.next();
        }
        Seller s = Seller.getSellers()[Seller.isExist(sellerName).getIndex()];
        System.out.println("The products is: "+s.printListProducts());
        System.out.println("Enter here the name of the product you want");
        String productName = scanner.next();
        while (s.returnProductByName(productName) == null)
        {
            if (productName.equalsIgnoreCase("Exit"))
            {
                return;
            }
            System.out.println("The product name is not exist pls try again " +
                    "\n If you want to return the menu enter exit");
            productName = scanner.next();

        }
        Product p = s.returnProductByName(productName);
        s.deleteProductByName(productName);
        Buyer b = Buyer.getBuyers()[Buyer.isExist(buyerName).getIndex()];
        b.validateArrProduct();
        b.setShoppingCart(p);


    }
    public int getCountProducts() {
        return countProducts;
    }

    public void setCountProducts(int countProducts) {
        this.countProducts = countProducts;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Product[] getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Product product) {

        this.shoppingCart[this.countProducts] = product;
        this.countProducts++;

    }
    public String getUserName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public static Buyer[] getBuyers() {
        return buyers;
    }

    public static void setBuyers(Buyer[] buyers) {
        Buyer.buyers = buyers;
    }

    public static int getSizeBuyers() {
        return sizeBuyers;
    }

    public static void setSizeBuyers(int sizeBuyers) {
        Buyer.sizeBuyers = sizeBuyers;
    }
}


