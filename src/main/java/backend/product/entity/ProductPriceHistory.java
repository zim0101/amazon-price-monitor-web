package backend.product.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * ProductPriceHistory entity. Represents product_price_histories table.
 */
public class ProductPriceHistory {

    /**
     * product_price_histories table id
     */
    private int id;

    /**
     * productId from products table id
     */
    private final int productId;

    /**
     * current price of the product
     */
    private final double price;

    /**
     * datetime of fetching the product price
     */
    private final String datetime;

    /**
     * @param id table id
     * @param productId product id from products table
     * @param price product price
     */
    public ProductPriceHistory(int id, int productId, double price) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(Calendar.getInstance().getTime());
    }

    /**
     * @param productId product id from products table
     * @param price product price
     */
    public ProductPriceHistory(int productId, double price) {
        this.productId = productId;
        this.price = price;
        this.datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());
    }

    /**
     * @return table id
     */
    public int getId() {
        return id;
    }

    /**
     * @return product id
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @return product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return date of the fetching product
     */
    public String getDate() {
        return datetime;
    }
}
