package backend.database.migrate;

public interface Migration {
    void up();
    void down();
}
