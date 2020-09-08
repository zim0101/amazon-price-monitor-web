package backend.product.entity;

/**
 * Product entity contains all columns as properties
 */
public class Product {
    /**
     * Product id
     */
    private int id;
    /**
     * Product name
     */
    private String name;
    /**
     * Product price
     */
    private double price;
    /**
     * Vendor name. For example: Amazon
     */
    private String vendor;
    /**
     * Product url from the vendor
     */
    private String url;
    /**
     * Id attribute from html of the price dom
     */
    private String priceSelector;
    /**
     * Id attribute from html of the product name dom
     */
    private String nameSelector;

    /**
     * @param id Product id
     * @param name Product name
     * @param price Product price
     * @param vendor Product vendor
     * @param url Product url
     * @param priceSelector Product price selector
     * @param nameSelector Product name selector
     */
    public Product(int id, String name, double price, String vendor, String url, String priceSelector,
                   String nameSelector) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vendor = vendor;
        this.url = url;
        this.priceSelector = priceSelector;
        this.nameSelector = nameSelector;
    }

    /**
     * @param name Product name
     * @param price Product price
     * @param vendor Product vendor
     * @param url Product url
     * @param priceSelector Product price selector
     * @param nameSelector Product name selector
     */
    public Product(String name, double price, String vendor, String url, String priceSelector,
                   String nameSelector) {
        this.name = name;
        this.price = price;
        this.vendor = vendor;
        this.url = url;
        this.priceSelector = priceSelector;
        this.nameSelector = nameSelector;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPriceSelector() {
        return priceSelector;
    }

    public void setPriceSelector(String priceSelector) {
        this.priceSelector = priceSelector;
    }

    public String getNameSelector() {
        return nameSelector;
    }

    public void setNameSelector(String nameSelector) {
        this.nameSelector = nameSelector;
    }
}
