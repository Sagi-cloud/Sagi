import java.util.Arrays;

public class HistoryCart {
    Product[] historyOrderCart;
    Date orderDate;

    public Product[] getHistoryOrderCart() {
        return historyOrderCart;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setHistoryOrderCart(Product[] historyOrderCart) {
        this.historyOrderCart = historyOrderCart;
    }

    public HistoryCart(Product[] historyOrderCart, Date orderDate) {
        this.historyOrderCart = historyOrderCart;
        this.orderDate = orderDate;


    }


}

