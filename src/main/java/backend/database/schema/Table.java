package backend.database.schema;

import backend.database.schema.column.Column;

public class Table {

    private final String tableName;
    private final Column[] columns;

    public Table(String tableName, Column[] columns){
        this.tableName = tableName;
        this.columns = columns;
    }

    public String getTableName() {
        return tableName;
    }

    public Column[] getColumns() {
        return columns;
    }
}
