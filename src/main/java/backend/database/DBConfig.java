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
        // TODO: Remove plain path from codebase. Develop API for that. Its risky.
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
        database.put("source", properties.getProperty("default_source"));
        database.put("host", properties.getProperty("default_host"));
        database.put("port", properties.getProperty("default_port"));
        database.put("database", properties.getProperty("default_database"));
        database.put("username", properties.getProperty("default_username"));
        database.put("password", properties.getProperty("default_password"));
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

    public static void main(String[] args) {
        DBConfig dbConfig = new DBConfig(DatabaseType.DEFAULT);
        Map<String, String> primaryDB = dbConfig.getDatabase();
        System.out.println(primaryDB);
    }
}
