package alphateam;

public class Payment{

    private float TotalHourCost = 0;
    private float TotalMinuteCost = 0;

    public float TotalAmount(int Hour, int Minute){
        float hourAmount = 30;

        setTotalHourCost(Hour * hourAmount);

        if (Minute < 60 && Minute >= 30) {
            setTotalMinuteCost(20);
        }
        else if(Minute < 30 && Minute >= 15){
            setTotalMinuteCost(15);
        }
        else if(Minute < 15 && Minute >= 1){
            setTotalMinuteCost(10);
        }

        return (TotalHourCost + TotalMinuteCost);
    }

    public float getTotalHourCost(){
        return TotalHourCost;
    }

    public void setTotalHourCost(float newTotalHourCost){
        TotalHourCost = newTotalHourCost;
    }

    public float getTotalMinuteCost() {
        return TotalMinuteCost;
    }

    public void setTotalMinuteCost(float totalMinuteCost) {
        TotalMinuteCost = totalMinuteCost;
    }

}