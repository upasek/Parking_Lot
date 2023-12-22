public class Car{
	public static final String TYPE_SEDAN = "sedan";
    public static final String TYPE_SUV = "suv";
    public static final String TYPE_COUPE = "coupe";
    
    private String NumberPlate;
    private String CarColor;
    private String CarType;
 
    
   private Car() {}

    
    public static Car createCar(String type) {
        switch (type.toLowerCase()) {
            case TYPE_SEDAN:
                return new Sedan();
            case TYPE_SUV:
                return new Suv();
            case TYPE_COUPE:
                return new Coupe();
            default:
                throw new IllegalArgumentException("Tipo de auto no válido");
        }
    }

    // Subclases internas para cada tipo de auto
    private static class Sedan extends Car{}
    private static class Suv extends Car{}
    private static class Coupe extends Car{}
	
    public String getNumberPlate(){
		return NumberPlate;
	}

	public void setNumberPlate(String NumberPlate){
		this.NumberPlate = NumberPlate;
	}

	public String getCarColor(){
		return CarColor;
	}

	public void setCarColor(String CarColor){
		this.CarColor = CarColor;
	}

	public String getCarType(){
		return CarType;
	}

	public void setCarType(String CarType){
		this.CarType = CarType;
	}
}