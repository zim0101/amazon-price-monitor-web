package backend.product.repository;


import backend.product.entity.Product;
import java.util.Optional;
import java.util.Set;


public interface ProductRepository {
    /**
     * Query for product by id and return product object if found or return
     * Optional.empty()
     *
     * @param id Product id for searching product.
     * @return Optional.empty() or Optional< Product >
     */
    Optional<Product> findOne(int id);

    /**
     * Query for all products and return set of product object if table not
     * empty  or return Optional.empty()
     *
     * @return Optional.empty() or Optional< Product >
     */
    Optional<Set<Product>> findAll();

    /**
     * Execute insert query and returns true if product is created and false
     * if product is not created
     *
     * @param product Product object
     * @return boolean
     */
    boolean create(Product product);

    /**
     * Execute update query and returns true if product is created and false
     * if product is not created
     *
     * @param product Product object
     * @return boolean
     */
    boolean update(Product product);

    /**
     * Delete product by product id
     *
     * @param id product id.
     * @return true if deleted or false if not.
     */
    boolean delete(int id);

    /**
     * Filter products by its name using search string
     *
     * @param searchString String to search products by name
     * @return Optional Product set
     */
    Optional<Set<Product>> filterProductsByName(String searchString);

    /**
     * Filter products by its price with given price
     *
     * @param price given price to filter products
     * @return Optional Product set
     */
    Optional<Set<Product>> filterProductsByPrice(Double price);

    /**
     * Filter products by its price with given price range
     *
     * @param min range of price
     * @param max range of price
     * @return Optional set of product
     */
    Optional<Set<Product>> filterProductsByPriceRange(Double min, Double max);

    /**
     * Sort products by name in descending order
     *
     * @return Optional set of product
     */
    Optional<Set<Product>> getProductsInDescendingOrderByName();

    /**
     * Sort products by price in descending order
     *
     * @return Optional set of product
     */
    Optional<Set<Product>> getProductsInDescendingOrderByPrice();
}
