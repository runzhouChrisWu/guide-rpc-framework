public class HolderTest<T> {
    public static void main(String[] args) {
        new HolderTest<String>();
    }

    private volatile T type;
}
