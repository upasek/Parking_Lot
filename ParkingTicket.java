public class ParkingTicket{

	//public String ParkingTime;
	public String Date;
	public String Time;
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
		return Date;
	}

	public void setDate(String Date){
		this.Date = Date;
	}

	public String getTime(){
		return Time;
	}

	public void setTime(String Time){
		this.Time = Time;
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