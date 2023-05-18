package org.busra;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class PaymentMenu {

    public static void pay(int count) throws SystemNotWorkingException {
        Random r = new Random();

        try {
            if (r.nextInt(100) > 75)
                throw new SystemNotWorkingException("System not working. Try again...");
            else
                System.out.println("Payment is successful. Thank You..");
        } catch (SystemNotWorkingException e){
            System.err.println(e.getMessage());
            if (count > 0)
                pay(count - 1);
        }
    }
    public static void run() {
        System.out.println("------  Welcome to Payment Menu  -----");
        Scanner kb = new Scanner(System.in);

        try {
            System.out.print("Enter Payment Amount : ");
            String amount = kb.nextLine();
            isValidAmount(amount);

            System.out.print("Enter Card Number : ");
            String cardNumber = kb.nextLine();
            isValidCardNumber(cardNumber);

            System.out.print("Enter Month and Year : ");
            int month = kb.nextInt();
            int year = kb.nextInt();
            kb.nextLine();
            isValidDate(month, year);

            System.out.print("Enter Security Code : ");
            String code = kb.nextLine();
            isValidCode(code);


            int i = 1;
            pay(i);

        } catch (InvalidPaymentAmountException | InvalidCardNumberException | InvalidDateException |
                 InvalidSecurityCodeException | SystemNotWorkingException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void isValidAmount(String amount) throws InvalidPaymentAmountException{
        if (amount.contains(","))
            throw new InvalidPaymentAmountException("Invalid amount! Payment amount mustn't be negative or float.");
        for (Character c : amount.toCharArray()){
            if (!Character.isDigit(c))
                throw new InvalidPaymentAmountException("Invalid amount! Payment amount mustn't be negative or float.");
        }
        Integer amountInt = Integer.valueOf(amount);
        if (amountInt < 0)
            throw new InvalidPaymentAmountException("Invalid amount! Payment amount mustn't be negative or float.");
    }

    private static void isValidCardNumber (String cardNumber) throws InvalidCardNumberException{
        if (cardNumber.length() != 16 )
            throw new InvalidCardNumberException("Invalid card number! Card number must be 16 character and mustn't be letter.");
        for (Character c : cardNumber.toCharArray()){
            if (!Character.isDigit(c))
                throw new InvalidCardNumberException("Invalid card number! Card number must be 16 character and mustn't be letter.");
        }
    }

    private static void isValidDate (int month, int year) throws InvalidDateException{
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        if (month < 1 || month > 12 & year >= currentYear)
            throw new InvalidDateException("Invalid date! Year must be greater than now and month must be between 01-12.");
    }

    private static void isValidCode(String code) throws InvalidSecurityCodeException{
        for (Character c : code.toCharArray()){
            if (!Character.isDigit(c))
                throw new InvalidSecurityCodeException("Invalid security code! Security code must be 3 character and mustn't be letter.");
        }
        if(code.length() != 3){
            throw new InvalidSecurityCodeException("Invalid security code! Security code must be 3 character and mustn't be letter.");
        }
    }


}
