package constants;

public final class Message {

    private Message() {
    }

    //menu chon he nhap
    public static final String INPUT_BASE_MENU = "1 for Binary\n2 for Decimal\n3 for Hexadecimal\n"
            + "Enter choice: ";
    //menu chon he xuat (co thoat)
    public static final String TARGET_BASE_MENU = "1 for Binary\n2 for Decimal\n3 for Hexadecimal\n4 exit\n"
            + "Enter choice: ";

    public static final String ENTER_BIN = "Enter binary number: ";
    public static final String ENTER_DEC = "Enter decimal number: ";
    public static final String ENTER_HEX = "Enter hexadecimal number: ";

    public static final String CONVERT_SUCCESS = "Number after convert: %s";

    public static final String ERROR_INVALID_VALUE = "Invalid input value.";
    public static final String ERROR_RANGE = "Please input number in a range %d -> %d";
}