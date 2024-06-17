import java.util.Scanner;

public class Seller {
    private String userName;//
    private String password;
    private Product[] products;//List of the products of the seller
    private int countProducts=0;
    private static Seller[] sellers = new Seller[1];
    private static int sellerSize = 0;

    public Seller(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.products = new Product[1];


    }
    public Seller()
    {
        this.userName = "Name";
        this.password = "Password";
        this.products = null;
    }
    public static void addSeller(Seller seller)
    {
        Seller s1= new Seller();
        s1.validateArrSeller();
        sellers[sellerSize] = seller;
        sellerSize++;
    }
    private  void validateArrSeller() {
        if (sellerSize == sellers.length) {
            int newSize = sellerSize * 2;
            newSize = Math.max(2, newSize);
            Seller[] temp = new Seller[newSize];
            for(int i = 0; i < sellers.length; i++) {
                temp[i] = sellers[i];//new Seller(sellers[i].getUserName(), sellers[i].getPassword(), sellers[i].getProducts())
            }
            sellers = temp;
        }
    }
    private void  validateArrProduct()
    {
        if(this.countProducts == this.products.length){
            int newSize = this.countProducts * 2;
            newSize = Math.max(2, newSize);
            Product[] temp = new Product[newSize];
            for (int i = 0; i < this.products.length; i++) {
                temp[i] = this.products[i];
            }
            this.products = temp;
        }
    }
    public static Tuple isExist(String name) {

        if (sellers[0] == null) {
            return new Tuple(false,-1);
        }
        for (int i = 0; i < sellerSize; i++) {
            if (sellers[i].getUserName().equalsIgnoreCase(name)) {
                return new Tuple(true,i);
            }
        }
        return new Tuple(false,-1);
    }
    private Product createProduct() {
        Product product1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Product Name :  ");
        String productName = scanner.next();
        System.out.println("Enter the Product price of the arr1 :  ");
        int productPrice = scanner.nextInt();
        product1 = new Product(productName, productPrice);
        return product1;
    }

    public static void addProductToSeller()
    {
        int index;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the seller name :  ");
        String sellerName = scanner.next();
        while (!isExist(sellerName).getExist())
        {
            System.out.println("The name doesnt exist pls try again :  ");
            sellerName = scanner.next();
        }
        Seller s1 = new Seller();
        Product p1 = s1.createProduct();
        index = Seller.isExist(sellerName).getIndex();
        sellers[index].validateArrProduct();
        sellers[index].setProducts(p1);
    }
    public static void printListSellers() {
        for(int i =0 ;i<sellerSize;i++)
        {
           System.out.println ("Seller{" +
                    "userName='" + sellers[i].getUserName() + '\'' +
                    ", password='" + sellers[i].getPassword() + '\'' +
                    "\n, products=" + sellers[i].printListProducts() +
                    '}');
        }
    }
    public String printListProducts() {
        String str = "";
        for(int i =0 ;i<products.length;i++)
        {
            if (products[i] != null)
                str += i+1+"."+products[i].toString()+"\n";
        }
        return str;
    }
    public Product returnProductByName(String productName) {
        for (int i = 0; i < this.products.length; i++) {
            if(this.products[i] == null)
            {
                return null;
            }

            if (this.products[i].getName().equalsIgnoreCase(productName))
                return this.products[i];
        }
        return null;
    }
    public void deleteProductByName(String productName) {
        int index=0;
        for (int i = 0; i < this.products.length; i++) {
            if(this.products[i] != null && this.products[i].getName().equalsIgnoreCase(productName)) {
                this.products[i] = null;
                index = i;
            }
        }
        for(int i = index+1;i<this.products.length;i++)
        {
            this.products[i-1] = this.products[i];
        }
        this.countProducts--;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product p1) {
        this.products[this.countProducts] = p1;
        this.countProducts++;
    }

    public int getCountProducts() {
        return countProducts;
    }

    public void setCountProducts(int countProducts) {
        this.countProducts = countProducts;
    }

    public static Seller[] getSellers() {
        return sellers;
    }

    public static void setSellers(Seller[] sellers) {
        Seller.sellers = sellers;
    }

    public static int getSellerSize() {
        return sellerSize;
    }

    public static void setSellerSize(int sellerSize) {
        Seller.sellerSize = sellerSize;
    }
}



