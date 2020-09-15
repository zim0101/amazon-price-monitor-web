package backend.database.schema.column;

public class StringColumn extends Column {

    private int length;

    public StringColumn(String columnName, ColumnTypes columnType) {
        super(columnName, columnType);
    }

    public StringColumn(String columnName, ColumnTypes columnType, int length) {
        super(columnName, columnType);
        this.length = length;
    }

    public StringColumn(String columnName, ColumnTypes columnType, int length, boolean nullable,
                        Object defaultValue) {
        super(columnName, columnType, nullable, defaultValue);
        this.length = length;
    }

    public StringColumn(String columnName, ColumnTypes columnType, int length, boolean nullable) {
        super(columnName, columnType, nullable);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
