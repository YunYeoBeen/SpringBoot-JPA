package jpabook.jpashop.Exception;

public class NotEnoughStockExcpetion extends RuntimeException {

    public NotEnoughStockExcpetion() {
        super();
    }

    public NotEnoughStockExcpetion(String message) {
        super(message);
    }

    public NotEnoughStockExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockExcpetion(Throwable cause) {
        super(cause);
    }

}
