package backend.database.utils;

import backend.database.connector.DBConfig;
import backend.database.connector.DBConnector;
import backend.database.connector.DatabaseType;
import backend.product.repository.ProductRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    private final DBConfig defaultDBConfig = new DBConfig(DatabaseType.DEFAULT);

    public void executeQuery(String query) {
        try (Connection connection = new DBConnector(defaultDBConfig.getDatabase()).connection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException exception) {
            logger.error("Migration error: ", exception);
            exception.printStackTrace();
        }
    }
}
