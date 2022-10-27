import java.util.ArrayList;
import java.util.*;


public class ParkingLot{

	public static void main(String[] args){

		ArrayList<ParkingTicket> assignedspotlist = new ArrayList<>();


		ParkingSpot parkingspot = new ParkingSpot();
		RandomInfo randominfo = new RandomInfo();
		Scanner scan = new Scanner(System.in);

		while( true ) {

			System.out.print("You want to parked your vehicle : ");
			String userinput = scan.nextLine();
			int size = userinput.length();

			ParkingTicket parkingticket = new ParkingTicket();
			Car car = new Car();

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


				assignedspotlist.add(parkingticket);
				System.out.println(assignedspotlist.size());

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

					for(ParkingTicket cp : assignedspotlist){
						String carnumber = cp.getAssignedCar().getNumberPlate();
						int item = scanticket.cheaknumber(number, carnumber);
						if( item == 0 ){
							continue;
						}
						else if(item == 1){
							int spot = assignedspotlist.indexOf(cp);
							//System.out.println("\n"+spot+"\n");

							String exitdate = randominfo.ExitDate();

							String exittime = randominfo.ExitTime();

							String enterdate = assignedspotlist.get(spot).getDate();
							String entertime = assignedspotlist.get(spot).getTime();


							int time[] = totaltime.CalculateTime(enterdate, exitdate, entertime, exittime);
							float amount = payment.TotalAmount(time[0], time[1]);

							System.out.println("\n\t\t=== Your Parking information ===\n" +
									"Car Number : " + assignedspotlist.get(spot).getAssignedCar().getNumberPlate() +
									"    Car Color : " + assignedspotlist.get(spot).getAssignedCar().getCarColor() +
									"    Car Type : "+assignedspotlist.get(spot).getAssignedCar().getCarType()+
									"\nParking Time : "+assignedspotlist.get(spot).getTime()+
									"    Exit Time : "+exittime+
									"\nParking Date : "+assignedspotlist.get(spot).getDate()+
									"    Exit Date :" +exitdate+
									"    Spot Number : "+assignedspotlist.get(spot).getSpotNumber()+
									"\nTotal Time : "+time[0]+" Hour "+time[1]+" Minute "+
									"\nTotal Amount : "+amount+" rupees\n"
							);

							parkingspot.FreeSpot(assignedspotlist.get(spot).getSpotNumber());
							assignedspotlist.remove(spot);

							break;
						}

					}

				}

			}

			else if(size == 6){

				System.out.println("All Car Information : \n");
				for(ParkingTicket pt : assignedspotlist){
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
