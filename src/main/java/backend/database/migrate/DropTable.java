package backend.database.migrate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DropTable extends ExecuteMigrations {

    public static void main(String[] args) {
        DropTable dropTable = new DropTable();
        dropTable.drop();
    }

    public void drop() {
        execute((migrationClass) -> {
            try {
                Method method = migrationClass.getMethod("down");
                method.invoke(migrationClass.getConstructor().newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException
                    | InstantiationException e) {
                e.printStackTrace();
            }
        });
    }
}
