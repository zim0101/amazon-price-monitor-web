package backend.database.schema.column;

public class DateColumn extends Column {

    public DateColumn(String columnName, ColumnTypes columnType) {
        super(columnName, columnType);
    }

    public DateColumn(String columnName, ColumnTypes columnType, boolean nullable,
                      Object defaultValue) {
        super(columnName, columnType, nullable, defaultValue);
    }

    public DateColumn(String columnName, ColumnTypes columnType, boolean nullable) {
        super(columnName, columnType, nullable);
    }
}
