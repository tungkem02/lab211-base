package constants;

public enum Base {
    BIN(2), DEC(10), HEX(16);

    private int base;

    private Base(int base) {
        this.base = base;
    }

    public int getValue() {
        return base;
    }
}