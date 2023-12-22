
public class PaymentStrategyForHour implements PaymentStrategy{
	private float HourAmount;

    public PaymentStrategyForHour(float HourAmount) {
        this.HourAmount = HourAmount;
    }

    @Override
    public float calculateTotalAmount(int Hour, int Minute) {
        float totalAmountForHour = Hour * HourAmount;
        float totalAmountForMinute = 0;

        if (Minute < 60 && Minute >= 30) {
            totalAmountForMinute = 20;
        }
        else if(Minute < 30 && Minute >= 15){
            totalAmountForMinute = 15;
        }
        else if(Minute < 15 && Minute >= 1){
            totalAmountForMinute = 10;
        }

        return (totalAmountForHour+totalAmountForMinute);
    }
	
	

}
