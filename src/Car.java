public class Car {
    private String Register_num;
    private String Manufacturer;
    private String Model;
    private String Plate;
    private int Year;
    private int Price;
    private int Branch_id;

    public Car(String Register_num, String Manufacturer, String Model, String Plate, int Year, int Price, int Branch_id) {
        this.Register_num = Register_num;
        this.Manufacturer = Manufacturer;
        this.Model = Model;
        this.Plate = Plate;
        this.Year = Year;
        this.Price = Price;
        this.Branch_id = Branch_id;
    }

    public String getRegister_num() {
        return Register_num;
    }

    public void setRegister_num(String Register_num) {
        this.Register_num = Register_num;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getPlate() {
        return Plate;
    }

    public void setPlate(String Plate) {
        this.Plate = Plate;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getBranch_id() {
        return Branch_id;
    }

    public void setBranch_id(int Branch_id) {
        this.Branch_id = Branch_id;
    }
    
    
}
