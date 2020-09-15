package backend.database.migrate;


import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;


public class ExecuteMigrations {
    public void execute(Consumer<Class<?>> consumer) {
        File folder = new File("src/main/java/backend/migrations");
        List<File> migrations = Arrays.asList(Objects.requireNonNull(folder.listFiles()));

        migrations.forEach(migration -> executeSingleMigration(migration, consumer));
    }

    public void executeSingleMigration(File migration, Consumer<Class<?>> consumer) {
        if (migration.isFile()) {
            try {
                String migrationClassName = "backend.migrations."
                        + migration.getName().replace(".java", "");
                Class<?> migrationClass = Class.forName(migrationClassName);
                consumer.accept(migrationClass);
            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }
}
