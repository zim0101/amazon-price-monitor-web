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

    /**
     * @return Product Id
     */
    public int getId() {
        return id;
    }

    /**
     * @return Product Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Product Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Product Price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price Product Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return Product Vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @param vendor Product Vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * @return Product Url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url Product Url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return Product PriceSelector
     */
    public String getPriceSelector() {
        return priceSelector;
    }

    /**
     * @param priceSelector Product PriceSelector
     */
    public void setPriceSelector(String priceSelector) {
        this.priceSelector = priceSelector;
    }

    /**
     * @return Product NameSelector
     */
    public String getNameSelector() {
        return nameSelector;
    }

    /**
     * @param nameSelector Product NameSelector
     */
    public void setNameSelector(String nameSelector) {
        this.nameSelector = nameSelector;
    }
}
