package org.busra;

public class BaseException extends Exception{

    public BaseException(){

    }
    public BaseException(String message) {
        super(message);
    }
}

class InvalidPaymentAmountException extends NumberFormatException{
    public InvalidPaymentAmountException(String message){
        super(message);
    }
}

class InvalidCardNumberException extends BaseException{

    public InvalidCardNumberException(String message) {
        super(message);
    }
}

class InvalidDateException extends BaseException{

    public InvalidDateException(String message) {
        super(message);
    }
}

class InvalidSecurityCodeException extends BaseException{

    public InvalidSecurityCodeException(String message) {
        super(message);
    }
}

class SystemNotWorkingException extends BaseException{

    public SystemNotWorkingException(){
        super();
    }

    public SystemNotWorkingException(String message) {
        super(message);
    }
}



