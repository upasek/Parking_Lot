

public interface ParkinglotObserver {
	void carPark(Car parkCar, int spotNumber);
    void carNoPark(Car noParkedCar, int spotNumber);
}
