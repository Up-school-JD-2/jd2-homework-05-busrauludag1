package org.busra;
import java.math.BigInteger;
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
            System.out.println("Enter Payment Amount: ");
            Integer amount = kb.nextInt();
            if (!isValidAmount(amount))
                throw new InvalidPaymentAmountException("Invalid amount! Payment amount mustn't be negative or float.");

            System.out.println("Enter Card Number: ");
            String cardNumber = kb.nextLine();
            if (!isValidCardNumber(cardNumber))
                throw new InvalidCardNumberException("Invalid card number! Card number must be 16 character number.");


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


}
