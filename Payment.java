public class Payment{

    float HourAmount = 30;
    float MinuteAmount = 0.5F;
    float TotalAmountForHour = 0;
    float TotalAmountForMinute = 0;

    public float TotalAmount(int Hour, int Minute){
        TotalAmountForHour = Hour * HourAmount;
        TotalAmountForMinute = Minute * MinuteAmount;

        return (TotalAmountForHour+TotalAmountForMinute);
    }

}