package backend.database;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * DBConfig class contains multiple database configurations.
 */
public class DBConfig {
    /**
     * Database configuration
     */
    protected final Map<String, String> database = new HashMap<>();

    public DBConfig(DatabaseType db) {
        Properties jdbcProperty = switch (db) {
            case DEFAULT -> readPropertiesFile(JdbcFilePath.DEFAULT.path);
            case TEST -> readPropertiesFile(JdbcFilePath.TEST.path);
        };

        setDatabase(jdbcProperty);
    }

    /**
     * @return Configuration of primary database
     */
    public Map<String, String> getDatabase() {
        return database;
    }

    /**
     * Set primary database properties
     *
     * @param properties jdbc properties
     */
    public void setDatabase(Properties properties) {
        database.put("source", properties.getProperty("source"));
        database.put("host", properties.getProperty("host"));
        database.put("port", properties.getProperty("port"));
        database.put("database", properties.getProperty("database"));
        database.put("username", properties.getProperty("username"));
        database.put("password", properties.getProperty("password"));
    }

    /**
     * Read jdbc properties file and return all properties
     *
     * @return jdbc properties
     */
    private Properties readPropertiesFile(String propertyFile) {
        Properties properties = new Properties();
        try (FileInputStream file = new FileInputStream(propertyFile)) {
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
