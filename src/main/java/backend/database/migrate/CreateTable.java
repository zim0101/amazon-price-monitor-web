package backend.database.migrate;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class CreateTable extends ExecuteMigrations {

    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        createTable.create();
    }

    public void create() {
        execute((migrationClass) -> {
            try {
                Method method = migrationClass.getMethod("up");
                method.invoke(migrationClass.getConstructor().newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException
                    | InstantiationException e) {
                e.printStackTrace();
            }
        });
    }
}
