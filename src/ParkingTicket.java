import java.time.format.DateTimeFormatter;

public class ParkingTicket{

	//public String ParkingTime;
	public String enterDate;
	public String enterTime;
	private long CardNumber ;
	public String CardType;
	public int SpotNumber;

	public Car car;

	public Car getAssignedCar(){
		return car;
	}

	public void setAssignedCar(Car car){
		this.car = car;
	}

	public String getDate(){
		return enterDate;
	}

	public void setDate(String enterDate){
		this.enterDate = enterDate;
	}

	public String getTime(){
		return enterTime;
	}

	public void setTime(String enterTime){
		this.enterTime = enterTime;
	}

	private long getCardNumber(){
		return CardNumber;
	}

	public void setCardNumber(long CardNumber){
		this.CardNumber = CardNumber;
	}

	private String getCardType(){
		return CardType;
	}

	public void setCardType(String CardType){
		this.CardType = CardType;
	}


	public int getSpotNumber(){
		return SpotNumber;
	}

	public void setSpotNumber(int SpotNumber){
		this.SpotNumber = SpotNumber;
	}

}