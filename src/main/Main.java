package main;

import constants.Base;
import constants.Constants;
import constants.Message;
import controller.Controller;
import dto.BaseDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        while (true) {
            BaseDTO dto = new BaseDTO();
            //buoc 1: chon he nhap
            dto.setSourceBase(inputSourceBase(scanner));
            //buoc 2: chon he xuat
            Base target = inputTargetBase(scanner);
            //chon 4 thi thoat chuong trinh
            if (target == null) {
                break;
            }
            dto.setTargetBase(target);
            //buoc 3: nhap so theo he nhap
            dto.setPresentation(inputNumber(scanner, dto.getSourceBase()));
            //buoc 4: chuyen doi va in ket qua
            controller.setDto(dto);
            controller.convertNumber();
        }
    }

    //chon he nhap (1 -> 3), sai thi nhap lai
    private static Base inputSourceBase(Scanner scanner) {
        while (true) {
            try {
                System.out.print(Message.INPUT_BASE_MENU);
                int choice = Validation.getInt(scanner.nextLine(), 1, 3);
                //thu tu enum BIN, DEC, HEX khop voi lua chon 1, 2, 3
                return Base.values()[choice - 1];
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //chon he xuat (1 -> 4), chon 4 tra ve null de thoat
    private static Base inputTargetBase(Scanner scanner) {
        while (true) {
            try {
                System.out.print(Message.TARGET_BASE_MENU);
                int choice = Validation.getInt(scanner.nextLine(), 1, 4);
                //4 la thoat
                if (choice == 4) {
                    return null;
                }
                return Base.values()[choice - 1];
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //nhap so theo he nhap, sai thi nhap lai
    private static String inputNumber(Scanner scanner, Base source) {
        String prompt;
        String regex;
        //chon cau hoi va regex theo he nhap
        switch (source) {
            case BIN:
                prompt = Message.ENTER_BIN;
                regex = Constants.REGEX_BINARY;
                break;
            case DEC:
                prompt = Message.ENTER_DEC;
                regex = Constants.REGEX_DECIMAL;
                break;
            default:
                prompt = Message.ENTER_HEX;
                regex = Constants.REGEX_HEXADECIMAL;
                break;
        }
        while (true) {
            try {
                System.out.print(prompt);
                return Validation.getString(scanner.nextLine(), regex);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}