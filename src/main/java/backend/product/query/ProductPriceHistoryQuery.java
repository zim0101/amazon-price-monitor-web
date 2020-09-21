package backend.product.query;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProductPriceHistoryQuery {

    /**
     * Get history of product price
     *
     * @param connection Database connection
     * @param id Product table's id
     * @return PreparedStatement
     * @throws SQLException SQLException
     */
    public static PreparedStatement getHistory(Connection connection, int id) throws SQLException {
        String query = "select\n" +
                "       products.id,\n" +
                "       products.name,\n" +
                "       product_price_histories.price,\n" +
                "       product_price_histories.date\n" +
                "from products\n" +
                "    left join product_price_histories " +
                "on products.id = product_price_histories.product_id\n" +
                "where products.id = ?\n" +
                "order by date;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        return preparedStatement;
    }
}
