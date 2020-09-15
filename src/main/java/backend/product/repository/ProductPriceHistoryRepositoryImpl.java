package backend.product.repository;


import backend.database.connector.DBConfig;
import backend.database.connector.DBConnector;
import backend.database.connector.DatabaseType;
import backend.product.dto.ProductPriceDTO;
import backend.product.query.ProductPriceHistoryQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ProductPriceHistoryRepositoryImpl implements ProductPriceHistoryRepository {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductPriceHistoryRepositoryImpl.class);

    private final DBConfig defaultDBConfig = new DBConfig(DatabaseType.DEFAULT);

    /**
     * Build single ProductPriceDTO from result
     *
     * @param resultSet ResultSet
     * @return ProductPriceDTO
     * @throws SQLException SQL exception
     */
    private ProductPriceDTO buildProductPriceDto(ResultSet resultSet) throws SQLException {
        return new ProductPriceDTO(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getString("date")
        );
    }

    /**
     * Returns List of ProductPriceDTO
     * @param resultSet ResultSet
     * @return ProductPriceDTO
     * @throws SQLException SQLException
     */
    private List<ProductPriceDTO> listOfProductPriceDto(ResultSet resultSet) throws SQLException {
        List<ProductPriceDTO> productsList = new LinkedList<>();
        while (resultSet.next()) {
            ProductPriceDTO product = buildProductPriceDto(resultSet);
            productsList.add(product);
        }

        return productsList;
    }

    /**
     * Get price history of a product by it's id and in ascending order of date.
     *
     * @param id product id
     * @return List of ProductPriceDTO
     */
    @Override
    public List<ProductPriceDTO> getPriceHistory(int id) {
        List<ProductPriceDTO> historyList = new LinkedList<>();

        try (Connection connection = new DBConnector(defaultDBConfig.getDatabase()).connection()) {
            ResultSet resultSet = ProductPriceHistoryQuery.getHistory(connection, id).executeQuery();
            historyList = listOfProductPriceDto(resultSet);
        } catch (SQLException | ClassNotFoundException exception) {
            logger.error("Product Query Exception (Exception occurred while fetching history): "
                    , exception);
            exception.printStackTrace();
        }

        return historyList;
    }
}
