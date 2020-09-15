package backend.product.dto;

public class ProductPriceDTO {

    /**
     * product id
     */
    private int id;

    /**
     * product name
     */
    private String name;

    /**
     * product price
     */
    private double price;

    /**
     * product date
     */
    private String date;


    /**
     * @param id product id
     * @param name product name
     * @param price product price
     * @param date product date
     */
    public ProductPriceDTO(int id, String name, double price, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    /**
     * @return Product Id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id Product Id
     */
    public void setId(int id) {
        this.id = id;
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
     * @return Product Date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date Product Date
     */
    public void setDate(String date) {
        this.date = date;
    }
}
