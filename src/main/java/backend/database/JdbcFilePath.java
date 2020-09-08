package backend.database;

public enum JdbcFilePath {
    DEFAULT("/home/trex/Development/JavaArea/web.amazon.price.notifier/src/" +
            "main/resources/jdbc.properties"),
    TEST("/home/trex/Development/JavaArea/web.amazon.price.notifier/src/" +
            "main/resources/jdbc.testdb.properties");

    public final String path;

    JdbcFilePath(String jdbcPropertyPath) {
        this.path = jdbcPropertyPath;
    }
}
