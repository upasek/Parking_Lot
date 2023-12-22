import java.util.ArrayList;

import java.util.*;
public class ParkingLot{
	
	private static ParkingLot instanciaParkinglot;
	public ArrayList<ParkingTicket> asignarpotlist;
	private List<ParkinglotObserver> observers = new ArrayList<>();
	
	private ParkingLot() {
		this.asignarpotlist = new ArrayList<>();
	}
	
	public static ParkingLot getInstancia() {
		if (instanciaParkinglot == null) {
			synchronized (ParkingLot.class) {
				if (instanciaParkinglot == null) {
					instanciaParkinglot = new ParkingLot();
				}
			}
		}
		return instanciaParkinglot;
	} 
	
	public void addObserver(ParkinglotObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ParkinglotObserver observer) {
        observers.remove(observer);
    }

    private void notifyCarPark(Car parkCar, int spotNumber) {
        for (ParkinglotObserver observer : observers) {
            observer.carPark(parkCar, spotNumber);
        }
    }

    private void notifyCarNoPark(Car noParkedCar, int spotNumber) {
        for (ParkinglotObserver observer : observers) {
            observer.carNoPark(noParkedCar, spotNumber);
        }
    }

    // Metodo para estacionar un auto
    public void parkCar(Car car, int spotNumber) {
        notifyCarPark(car, spotNumber);
    }

    // Metodo para que un auto salga del estacionamiento
    public void departCar(Car car, int spotNumber) {
        notifyCarNoPark(car, spotNumber);
    }
	
	public static void main(String[] args){

		
		ParkingLot parkingLot = ParkingLot.getInstancia();

		ParkingSpot parkingspot = new ParkingSpot();
		RandomInfo randominfo = new RandomInfo();
		Scanner scan = new Scanner(System.in);

		while( true ) {

			System.out.print("You want to parked your vehicle : ");
			String userinput = scan.nextLine();
			int size = userinput.length();

			ParkingTicket parkingticket = new ParkingTicket();
			Car car = null;
			Car.createCar("suv");
			if (size == 5) {
				System.out.print("\033\143");
				// get car information from car class
				String carcolor = randominfo.CarColor();
				String numberplate = randominfo.Numberplate();
				String cartype = randominfo.CarType();

				parkingticket.setAssignedCar(car);
				parkingticket.getAssignedCar().setNumberPlate(numberplate);
				parkingticket.getAssignedCar().setCarColor(carcolor);
				parkingticket.getAssignedCar().setCarType(cartype);

				// get spot from parkingSpot class
				int spotnum = parkingspot.SpotNum();
				if(spotnum == 0){
					System.out.println("Sorry, spot is not available.");
					continue;
				}
				parkingticket.setSpotNumber(spotnum);


				// get parking ticket from parkingticket class
				String cardtype = randominfo.CardType();
				String time = randominfo.Time();
				String date = randominfo.Date();
				long cardnumber = randominfo.CardNumber();

				parkingticket.setCardType(cardtype);
				parkingticket.setTime(time);
				parkingticket.setDate(date);
				parkingticket.setCardNumber(cardnumber);



				System.out.println("\t\t== Parking Ticket ==\n" +
						"Car Number : " + numberplate + "    Car Color : " + carcolor + "    Car Type : " + cartype +
						"\nParking Time : " + time + "    Date : " + date +
						"\nSpot Number : " + spotnum + "\n"
				);


				parkingLot.asignarpotlist.add(parkingticket);
				System.out.println(parkingLot.asignarpotlist.size());

			}
			else if(size == 4){
				//System.out.print("\033\143");
				int cheakspot = parkingspot.si();
				if (cheakspot == 10 ){
					System.out.println("There is no car .");
					continue;
				}
				else {
					System.out.print("Enter your car number : ");
					String number = scan.nextLine();
					ScanTicket scanticket = new ScanTicket();
					TotalTime totaltime = new TotalTime();
					Payment payment = new Payment();

					for(ParkingTicket cp : parkingLot.asignarpotlist){
						String carnumber = cp.getAssignedCar().getNumberPlate();
						int item = scanticket.cheaknumber(number, carnumber);
						if( item == 0 ){
							continue;
						}
						else if(item == 1){
							int spot = parkingLot.asignarpotlist.indexOf(cp);
							//System.out.println("\n"+spot+"\n");

							String exitdate = randominfo.ExitDate();

							String exittime = randominfo.ExitTime();

							String enterdate = parkingLot.asignarpotlist.get(spot).getDate();
							String entertime = parkingLot.asignarpotlist.get(spot).getTime();


							int time[] = totaltime.CalculateTime(enterdate, exitdate, entertime, exittime);
							float amount = payment.TotalAmount(time[0], time[1]);

							System.out.println("\n\t\t=== Your Parking information ===\n" +
									"Car Number : " + parkingLot.asignarpotlist.get(spot).getAssignedCar().getNumberPlate() +
									"    Car Color : " + parkingLot.asignarpotlist.get(spot).getAssignedCar().getCarColor() +
									"    Car Type : "+parkingLot.asignarpotlist.get(spot).getAssignedCar().getCarType()+
									"\nParking Time : "+parkingLot.asignarpotlist.get(spot).getTime()+
									"    Exit Time : "+exittime+
									"\nParking Date : "+parkingLot.asignarpotlist.get(spot).getDate()+
									"    Exit Date :" +exitdate+
									"    Spot Number : "+parkingLot.asignarpotlist.get(spot).getSpotNumber()+
									"\nTotal Time : "+time[0]+" Hour "+time[1]+" Minute "+
									"\nTotal Amount : "+amount+" rupees\n"
							);

							parkingspot.FreeSpot(parkingLot.asignarpotlist.get(spot).getSpotNumber());
							parkingLot.asignarpotlist.remove(spot);

							break;
						}

					}

				}

			}

			else if(size == 6){

				System.out.println("All Car Information : \n");
				for(ParkingTicket pt : parkingLot.asignarpotlist){
					System.out.println("\n\ncar number : "+pt.getAssignedCar().getNumberPlate()+
							"       car color : "+pt.getAssignedCar().getCarColor()+
							"       car type : "+pt.getAssignedCar().getCarType()+
							"\nparking time : "+pt.getTime()+"    date : "+pt.getDate()+
							"       spot number : "+pt.getSpotNumber()

					);

				}
				parkingspot.sipe();
				System.out.println();
			}

		}

	}

}
