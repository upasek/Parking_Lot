import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RandomInfo{
	Random rand = new Random();

	String[] states = {"MH", "GJ", "RJ", "DL", "MP", "UP", "KA", "JK", "LA"};
	String[] dist = {"02", "27", "12", "19", "22", "08", "05", "26", "30"};
	String[] alpha = {"AB", "CV", "RT", "ZX", "WE", "JK", "RL", "AQ", "PO", "DH"};
	String[] color = {"Red", "Yellow", "Green", "white", "Brown", "Violet", "Pink"};
	String[] type = {"Sedan", "van", "Minivan", "Bus", "Pickup-truck", "Hatchback"};

	public String Numberplate(){
		int st = rand.nextInt(states.length);
		int di = rand.nextInt(dist.length);
		int al = rand.nextInt(alpha.length);

		return states[st]+"-"+dist[di]+" "+alpha[al]+" "+rand.nextInt((99 - 10)+ 1) + 10;
	}

	public String CarColor(){
		int res = rand.nextInt(color.length);
		return color[res];
	}

	public String CarType() {
		int typ = rand.nextInt(type.length);
		return type[typ];
	}


	// information for parkingaticket
	 public String Time(){
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String enterTime = localTime.format(dateTimeFormatter);
		return enterTime;
	}

	public String ExitTime(){
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		String exitTime = localTime.format(dateTimeFormatter);
		return exitTime;
	}

	public String Date(){
		LocalDate mydate = LocalDate.now();
		return mydate.toString();
	}
	public String ExitDate(){
		LocalDate date = LocalDate.now();
		return date.toString();
	}

	String[] cardtype = {"Debit", "Credit"};
	public String CardType(){
		int caty = rand.nextInt(cardtype.length);
		return cardtype[caty];
	}

	public long CardNumber(){
		return ((rand.nextLong() % 100000000000000L) + 5200000000000000L);
	}

 }