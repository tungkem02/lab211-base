package utils;

import constants.Message;

public final class Validation {

    private Validation() {
    }

    //So nguyen trong khoang min..max
    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int value = Integer.parseInt(input.trim());
            //Ngoai khoang cho phep -> loi
            if (value < min || value > max) {
                throw new Exception(String.format(Message.ERROR_RANGE, min, max));
            }
            return value;
        } catch (NumberFormatException e) {
            //Khong phai so nguyen
            throw new Exception(Message.ERROR_INVALID_VALUE);
        }
    }

    //Chuoi phai khop regex cua he co so
    public static String getString(String input, String regex) throws Exception {
        //Khop regex -> hop le
        if (input.trim().matches(regex)) {
            return input.trim();
        }
        throw new Exception(Message.ERROR_INVALID_VALUE);
    }
}