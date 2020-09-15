package backend.database.schema.column;

public class NumericColumn extends Column {

    private int range;
    private int precision;
    private int scale;

    public NumericColumn(String columnName, ColumnTypes columnType) {
        super(columnName, columnType);
    }

    public NumericColumn(String columnName, ColumnTypes columnType, boolean isPrimaryKey,
                         boolean autoIncrement) {
        super(columnName, columnType, isPrimaryKey, autoIncrement);
    }

    public NumericColumn(String columnName, ColumnTypes columnType, int precision, int scale) {
        super(columnName, columnType);
        this.precision = precision;
        this.scale = scale;
    }

    public NumericColumn(String columnName, ColumnTypes columnType, int precision, int scale,
                         boolean nullable, Object defaultValue) {
        super(columnName, columnType, nullable, defaultValue);
        this.precision = precision;
        this.scale = scale;
    }

    public NumericColumn(String columnName, ColumnTypes columnType, int precision, int scale,
                         boolean nullable) {
        super(columnName, columnType, nullable);
        this.precision = precision;
        this.scale = scale;
    }

    public NumericColumn(String columnName, ColumnTypes columnType, int range) {
        super(columnName, columnType);
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
