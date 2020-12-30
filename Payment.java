public class Payment{

    float HourAmount = 30;
    float TotalAmountForHour = 0;
    float TotalAmountForMinute = 0;

    public float TotalAmount(int Hour, int Minute){
        TotalAmountForHour = Hour * HourAmount;
        if (Minute < 60 && Minute >= 30) {
            TotalAmountForMinute = 20;
        }
        else if(Minute < 30 && Minute >= 15){
            TotalAmountForMinute = 15;
        }
        else if(Minute < 15 && Minute >= 1){
            TotalAmountForMinute = 10;
        }

        return (TotalAmountForHour+TotalAmountForMinute);
    }

}