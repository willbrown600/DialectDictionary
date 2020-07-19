public class Key {
    int key;

    public Key(int key) {
        this.key = key;
    }

    public int increment() {
        key++;
        return key;
    }
}
