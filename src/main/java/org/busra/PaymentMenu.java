package org.busra;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class PaymentMenu {

    public static void pay() throws SystemNotWorkingException {
        Random r = new Random();
        if (r.nextInt() > 75)
            throw new SystemNotWorkingException();
    }
    public static void run() {
        System.out.println("------  Welcome to Payment Menu  -----");
        Scanner kb = new Scanner(System.in);

        try {
            System.out.print("Enter Payment Amount: ");
            Integer amount = kb.nextInt();
            if (!isValidAmount(amount))
                throw new InvalidPaymentAmountException("Invalid amount! Payment amount mustn't be negative or float.");

            System.out.print("Enter Card Number: ");
            String cardNumber = kb.nextLine();
            if (!isValidCardNumber(cardNumber))
                throw new InvalidCardNumberException("Invalid card number! Card number must be 16 character number.");

            System.out.println("Enter Date: ");
            String date = kb.nextLine();
            if (!isValidDate(date))
                throw new InvalidDateException("Invalid date! Year must be greater than now.");

            System.out.println("Enter Security Code: ");
            int code = kb.nextInt();
            if (!isValidCode(code))
                throw new InvalidSecurityCodeException("Invalid card number! Card number must be 16 character number.");

        } catch (InvalidPaymentAmountException e){
            System.out.println(e.getMessage());
        } catch (InvalidCardNumberException e){
            System.out.println(e.getMessage());
        } catch (InvalidDateException e){
            System.out.println(e.getMessage());
        } catch (InvalidSecurityCodeException e){
            System.out.println(e.getMessage());
        }

    }

    private static boolean isValidAmount(Integer amount){
        if (amount < 0)
            return false;
        return true;
    }

    private static boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16)
            return false;
        return true;
    }

    private static boolean isValidDate(String year){
        return true;
    }

    private static boolean isValidCode(int code){
        int count = 0;
        while (code != 0){
            code = code / 10;
            ++count;
        }
        if(count != 3){
            return false;
        }
        return true;
    }


}
