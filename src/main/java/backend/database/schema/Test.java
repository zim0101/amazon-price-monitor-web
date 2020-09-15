package backend.database.schema;

import backend.database.schema.column.Column;
import backend.database.schema.column.ColumnTypes;
import backend.database.schema.column.NumericColumn;
import backend.database.schema.column.StringColumn;

public class Test {
    public static void main(String[] args) {

        Column id = new NumericColumn("id", ColumnTypes.INT, true, true);
        Column name = new StringColumn("name", ColumnTypes.VARCHAR, 100);
        Column[] columns = {id, name};
        Table productTable = new Table("products", columns);
        Column[] productTableColumns = productTable.getColumns();

        StringBuilder query = new StringBuilder("create table " + productTable.getTableName() + " (");

        for (Column productTableColumn : productTableColumns) {
            query.append(" ").append(productTableColumn.getColumnName());

            if (productTableColumn.getAutoIncrement()) {
                query.append(" ").append(ColumnTypes.AUTO_INCREMENT.getTypeValue());
            }

            if (productTableColumn.getPrimaryKey()) {
                query.append(" ").append(ColumnTypes.PRIMARY_KEY.getTypeValue());
            }
        }
        System.out.println(query);
    }
}
