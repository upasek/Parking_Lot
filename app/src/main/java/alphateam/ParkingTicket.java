package alphateam;

public class ParkingTicket {
	public Car car;
	private String date;
	private String time;
	private long cardNumber;
	private String cardType;
	private int spotNumber;
	

	public ParkingTicket(String enterDate, String enterTime, long cardNumber, String cardType, int spotNumber, Car car) {
		this.date = enterDate;
		this.time = enterTime;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.spotNumber = spotNumber;
		this.car = car;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
			str.append("----- Parking Ticket -----")
			.append("\nCar Number: ").append(car.getNumberPlate())
			.append("\nCar Color: ").append(car.getCarColor())
			.append("\nCar Type: ").append(car.getCarType())
			.append("\nTime: ").append(getTime())
			.append("\nDate: ").append(getDate())
			.append("\nSpot Number: ").append(getSpotNumber());

		return str.toString();
	}

	public Car getAssignedCar(){
		return car;
	}

	public void setAssignedCar(Car car){
		this.car = car;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String enterDate){
		this.date = enterDate;
	}

	public String getTime(){
		return time;
	}

	public void setTime(String enterTime){
		this.time = enterTime;
	}

	private long getCardNumber(){
		return cardNumber;
	}

	public void setCardNumber(long CardNumber){
		this.cardNumber = CardNumber;
	}

	private String getCardType(){
		return cardType;
	}

	public void setCardType(String CardType){
		this.cardType = CardType;
	}

	public int getSpotNumber(){
		return spotNumber;
	}

	public void setSpotNumber(int SpotNumber){
		this.spotNumber = SpotNumber;
	}

}