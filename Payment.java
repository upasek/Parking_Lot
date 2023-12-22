public class Payment{

	private PaymentStrategy paymentStrategy;

    public Payment(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public float totalAmount(int Hour, int Minute){
        return paymentStrategy.calculateTotalAmount(Hour, Minute);
    }

}