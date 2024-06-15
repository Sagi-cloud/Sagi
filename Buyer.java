public class Buyer extends User {
    private String adress;
    private static Buyer[] buyers = new Buyer[1];
    private static int sizeBuyers =0;

    public Buyer(String user, String password, String adress) {
        super(user, password);
        this.adress = adress;
    }

    public static Buyer[] getBuyers() {
        return buyers;
    }

    public static void setBuyers(Buyer[] buyers) {
        Buyer.buyers = buyers;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public static int getSizeBuyers() {
        return sizeBuyers;
    }

    public static void setSizeBuyers(int sizeBuyers) {
        Buyer.sizeBuyers = sizeBuyers;
    }
}

