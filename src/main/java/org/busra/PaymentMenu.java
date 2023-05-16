package org.busra;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class PaymentMenu {
    private static int [] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static void pay() throws SystemNotWorkingException {
        Random r = new Random();
        if (r.nextInt() > 75)
            throw new SystemNotWorkingException("System not working. Try again...");
    }
    public static void run() {
        System.out.println("------  Welcome to Payment Menu  -----");
        Scanner kb = new Scanner(System.in);

        try {
            System.out.print("Enter Payment Amount : ");
            String amount = kb.nextLine();
            if (!isValidAmount(amount))
                throw new InvalidPaymentAmountException("Invalid amount! Payment amount mustn't be negative or float.");

            System.out.print("Enter Card Number : ");
            String cardNumber = kb.nextLine();
            if (!isValidCardNumber(cardNumber))
                throw new InvalidCardNumberException("Invalid card number! Card number must be 16 character and mustn't be letter.");

            System.out.print("Enter Month and Year : ");
            int month = kb.nextInt();
            kb.nextLine();
            int year = kb.nextInt();
            kb.nextLine();
            if (!isValidDate(month, year))
                throw new InvalidDateException("Invalid year! Year must be greater than now and month must be between 01-12.");

            System.out.print("Enter Security Code : ");
            String code = kb.nextLine();
            if (!isValidCode(code))
                throw new InvalidSecurityCodeException("Invalid security code! Security code must be 3 character and mustn't be letter.");

            pay();

        } catch (InvalidPaymentAmountException | InvalidCardNumberException | InvalidDateException |
                 InvalidSecurityCodeException | SystemNotWorkingException e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean isValidAmount(String amount){
        if (amount.contains(","))
            return false;
        for (Character c : amount.toCharArray()){
            if (!Character.isDigit(c))
                return false;
        }
        Integer amountInt = Integer.valueOf(amount);
        if (amountInt < 0)
            return false;
        return true;
    }

    private static boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16 )
            return false;
        for (Character c : cardNumber.toCharArray()){
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    private static boolean isValidDate(int month, int year){
        if (month < 1 || month > 12 || year < 2023)
            return false;
        return true;
    }

    private static boolean isValidCode(String code){
        for (Character c : code.toCharArray()){
            if (!Character.isDigit(c))
                return false;
        }
        if(code.length() != 3){
            return false;
        }
        return true;
    }


}
