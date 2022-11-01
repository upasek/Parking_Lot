package alphateam;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ParkingTicketTest {
    ParkingTicket parkingTicket;
    Car truck;

    @Before
    public void setUp() {
        // TODO apply car refactor
        truck = new Car();
        truck.CarColor = "Red";
	    truck.NumberPlate = "ZZT-0420";
		truck.CarType = "Pickup Truck";

        parkingTicket = new ParkingTicket("11/27/2020", "05:35:00", 1337, "Credit", 14, truck);
    }

    @Test 
    public void testToString() {
        String expectedStr = "----- Parking Ticket -----" +
        "\nCar Number: " + parkingTicket.getAssignedCar().getNumberPlate() +
        "\nCar Color: " + parkingTicket.getAssignedCar().getCarColor() + 
        "\nCar Type: " + parkingTicket.getAssignedCar().getCarType() +
        "\nTime: " + parkingTicket.getTime() + 
        "\nDate: " +  parkingTicket.getDate() +
        "\nSpot Number: " + parkingTicket.getSpotNumber();

        String actualStr = parkingTicket.toString();
        assertEquals(expectedStr, actualStr);
    }
}
