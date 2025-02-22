package unit2;

/**
 * Enum representing the options in the library system.
 */
public enum LibraryOption {
    ADD_BOOKS(1),
    BORROW_BOOKS(2),
    RETURN_BOOKS(3),
    EXIT(4);

    private final int value;

    LibraryOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LibraryOption fromValue(int value) {
        for (LibraryOption option : values()) {
            if (option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid option value: " + value);
    }
}