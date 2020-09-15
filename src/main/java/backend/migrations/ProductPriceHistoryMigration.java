package backend.migrations;

import backend.database.migrate.Migration;
import backend.database.utils.QueryExecutor;

public class ProductPriceHistoryMigration extends QueryExecutor implements Migration {

    private static final String UP_QUERY = "create table product_price_histories "
            + "("
            + "id int auto_increment primary key,"
            + "product_id int not null,"
            + "price double not null,"
            + "date datetime not null"
            + ");";

    private  static final String DOWN_QUERY = "DROP TABLE IF EXISTS product_price_histories;";

    @Override
    public void up() {
        executeQuery(UP_QUERY);
    }

    @Override
    public void down() {
        executeQuery(DOWN_QUERY);
    }
}
