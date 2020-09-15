package backend.database.schema.column;

public class Column {

    private String columnName;
    private ColumnTypes columnType;
    private boolean nullable = false;
    private boolean primaryKey = false;
    private boolean autoIncrement = false;
    private Object defaultValue;

    public Column(String columnName, ColumnTypes columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public Column(String columnName, ColumnTypes columnType, boolean primaryKey,
                  boolean autoIncrement) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.primaryKey = primaryKey;
        this.autoIncrement = autoIncrement;
    }

    public Column(String columnName, ColumnTypes columnType, boolean nullable) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.nullable = nullable;
    }

    public Column(String columnName, ColumnTypes columnType, boolean nullable,
                  Object defaultValue) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.nullable = nullable;
        this.defaultValue = defaultValue;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnTypes getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnTypes columnType) {
        this.columnType = columnType;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public boolean getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }
}
