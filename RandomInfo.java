import java.util.Random;
import java.time.LocalDate;

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

	public String CarType(){
		int typ = rand.nextInt(type.length);
		return type[typ];
	}


	// information for parkingaticket

	String[] cardtype = {"Debit", "Credit"};
	String[] daytype = {"AM", "PM"};

	public String Time(){
		int time = rand.nextInt(12 - 1) + 1;
		int sec = rand.nextInt(59 - 1) + 1;
		int typ = rand.nextInt(daytype.length);

		String stringtime = Integer.toString(time);
		String stringsec = Integer.toString(sec);
		if(time < 10){
			stringtime = "0"+time;
		}
		if(sec < 10){
			stringsec = "0"+sec;
		}
		return (stringtime +":"+stringsec+" "+daytype[typ]);
	}

	public String Date(){
		LocalDate mydate = LocalDate.now();
		return mydate.toString();
	}
	public String CardType(){
		int caty = rand.nextInt(cardtype.length);
		return cardtype[caty];
	}

	public long CardNumber(){
		return ((rand.nextLong() % 100000000000000L) + 5200000000000000L);
	}

 }