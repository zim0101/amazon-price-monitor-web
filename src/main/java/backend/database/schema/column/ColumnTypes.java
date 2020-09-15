package backend.database.schema.column;

public enum ColumnTypes {

    AUTO_INCREMENT("AUTO_INCREMENT"),
    PRIMARY_KEY("PRIMARY KEY"),
    NOT_NULL("NOT NULL"),
    DEFAULT("DEFAULT"),

    VARCHAR("VARCHAR"),
    CHAR("CHAR"),
    TEXT("TEXT"),
    TINYTEXT("TINYTEXT"),
    MEDIUMBLOB("MEDIUMBLOB"),
    MEDIUMTEXT("MEDIUMTEXT"),
    LONGBLOB("LONGBLOB"),
    LONGTEXT("LONGTEXT"),

    TINYINT("TINYINT"),
    SMALLINT("SMALLINT"),
    MEDIUMINT("MEDIUMINT"),
    INT("INT"),
    BIGINT("BIGINT"),
    FLOAT("FLOAT"),
    DOUBLE("DOUBLE"),
    DECIMAL("DECIMAL"),

    DATE("DATE"),
    DATETIME("DATETIME"),
    TIMESTAMP("TIMESTAMP"),
    TIME("TIME"),
    YEAR("YEAR"),

    TINYBLOB("TINYBLOB"),
    BLOB("BLOB"),

    ENUM("ENUM"),
    SET("SET"),
    BOOL("BOOL"),
    BINARY("BINARY"),
    VARBINARY("VARBINARY");


    private final String typeValue;

    private ColumnTypes(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return this.typeValue;
    }
}
