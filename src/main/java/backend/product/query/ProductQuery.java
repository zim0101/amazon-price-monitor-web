package backend.product.query;

import backend.product.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductQuery {
    /**
     * Prepare statement for finding product by id.
     *
     * @param connection Database connection
     * @param id Product id
     * @return PreparedStatement
     * @throws SQLException SQL Exception
     */
    public static PreparedStatement findOne(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from products where id = ?");
        preparedStatement.setInt(1, id);

        return preparedStatement;
    }

    /**
     * Prepares query statement for finding product by price.
     *
     * @param connection Database connection
     * @param price Product price
     * @return PreparedStatement
     * @throws SQLException SQL Exception
     */
    public static PreparedStatement findByPrice(Connection connection, double price)
            throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from products where price = ?");
        preparedStatement.setDouble(1, price);

        return preparedStatement;
    }

    /**
     * Prepares query statement for finding all products in a price range.
     *
     * @param connection Database connection
     * @param upperRange upper range of product price
     * @param lowerRange lower range of product price
     * @return PreparedStatement
     * @throws SQLException SQL Exception
     */
    public static PreparedStatement findByPriceRange(Connection connection, double upperRange,
                                                     double lowerRange) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from products where price >= ? and price <= ?");
        preparedStatement.setDouble(1, lowerRange);
        preparedStatement.setDouble(2, upperRange);

        return preparedStatement;
    }

    /**
     * Prepares query statement for finding all products.
     *
     * @param connection Database connection
     * @return PreparedStatement
     * @throws SQLException SQL Exception
     */
    public static PreparedStatement findAll(Connection connection) throws SQLException {
        return connection.prepareStatement("select * from products");
    }

    /**
     * Prepares query statement for creating a product.
     *
     * @param connection Database connection
     * @return PreparedStatement
     * @throws SQLException SQL Exception
     */
    public static PreparedStatement create(Product product, Connection connection)
            throws SQLException {
        String query = "insert into products "
                + "(`name`, price, site_name, url, price_selector, name_selector) "
                + "values (?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        return prepareColumnData(product, statement);

    }

    /**
     * Prepares query statement for updating a product.
     *
     * @param connection Database connection
     * @return PreparedStatement
     * @throws SQLException SQL Exception
     */
    public static PreparedStatement update(Product product, Connection connection)
            throws SQLException {
        String query = "update products set "
                + "`name` = ?, "
                + "price = ?, "
                + "site_name = ?, "
                + "url = ?, "
                + "price_selector = ?, "
                + "name_selector = ? where id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(7, product.getId());

        return prepareColumnData(product, statement);

    }

    /**
     * Prepares query statement for deleting a product.
     *
     * @param connection Database connection
     * @return PreparedStatement
     * @throws SQLException SQL Exception
     */
    public static PreparedStatement delete(int id, Connection connection)
            throws SQLException {
        String query = "delete from products where id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        return statement;
    }

    /**
     * Add prepared statement parameters which is both useful for creating
     * new product or updating all columns of existing product.
     *
     * @param product Product object
     * @param statement PreparedStatement
     * @return PreparedStatement
     * @throws SQLException SQLException
     */
    private static PreparedStatement prepareColumnData(Product product, PreparedStatement statement)
            throws SQLException {

        statement.setString(1, product.getName());
        statement.setDouble(2, product.getPrice());
        statement.setString(3, product.getVendor());
        statement.setString(4, product.getUrl());
        statement.setString(5, product.getPriceSelector());
        statement.setString(6, product.getNameSelector());

        return statement;
    }
}
