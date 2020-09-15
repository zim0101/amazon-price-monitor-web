package backend.migrations;

import backend.database.migrate.Migration;
import backend.database.utils.QueryExecutor;

public class ProductTableMigration extends QueryExecutor implements Migration {

    private static final String UP_QUERY = "create table products"
            + "("
            + " id int auto_increment primary key,"
            + " name varchar(100) not null,"
            + " price double not null,"
            + " site_name varchar(100) not null,"
            + " url text not null,"
            + " price_selector varchar(100) not null,"
            + " name_selector varchar(100) not null"
            + ");";

    private  static final String DOWN_QUERY = "DROP TABLE IF EXISTS products;";

    @Override
    public void up() {
        executeQuery(UP_QUERY);
    }

    @Override
    public void down() {
        executeQuery(DOWN_QUERY);
    }
}
