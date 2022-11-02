package alphateam;

import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RandomInfo{
	private Random rand = new Random();

	private final String[] states = {"MH", "GJ", "RJ", "DL", "MP", "UP", "KA", "JK", "LA"};
	private final String[] dist = {"02", "27", "12", "19", "22", "08", "05", "26", "30"};
	private final String[] alpha = {"AB", "CV", "RT", "ZX", "WE", "JK", "RL", "AQ", "PO", "DH"};
	private final String[] color = {"Red", "Yellow", "Green", "white", "Brown", "Violet", "Pink"};
	private final String[] type = {"Sedan", "van", "Minivan", "Bus", "Pickup-truck", "Hatchback"};

	private final String[] cardType = {"Debit", "Credit"};

	public String numberPlate(){
		int stateSelector = rand.nextInt(states.length);
		int distanceSelector = rand.nextInt(dist.length);
		int alphaSelector = rand.nextInt(alpha.length);

		return states[stateSelector]+"-"+dist[distanceSelector]+" "+alpha[alphaSelector]+" "+
				rand.nextInt((99 - 10)+ 1) + 10;
	}

	public String carColor(){
		int res = rand.nextInt(color.length);
		return color[res];
	}

	public String carType() {
		int typ = rand.nextInt(type.length);
		return type[typ];
	}
	
	 public String time(){
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String enterTime = localTime.format(dateTimeFormatter);
		return enterTime;
	}

	public String exitTime(){
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String exitTime = localTime.format(dateTimeFormatter);
		return exitTime;
	}

	public String date(){
		LocalDate myDate = LocalDate.now();
		return myDate.toString();
	}
	public String exitDate(){
		LocalDate date = LocalDate.now();
		return date.toString();
	}

	public String CardType(){
		int cardTypeSelector = rand.nextInt(cardType.length);
		return cardType[cardTypeSelector];
	}

	public long cardNumber(){
		return ((rand.nextLong() % 100000000000000L) + 5200000000000000L);
	}

 }