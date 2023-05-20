public class Customer {
    private String National_id;
    private String Fname;
    private String Mname;
    private String Lname;
    private String Phone;
    private String Street;
    private String City;
    private String Zip_code;
    private String Dob; 

    public Customer(String National_id, String Fname, String Mname, String Lname, String Phone, String Street, String City, String Zip_code, String Dob) {
        this.National_id = National_id;
        this.Fname = Fname;
        this.Mname = Mname;
        this.Lname = Lname;
        this.Phone = Phone;
        this.Street = Street;
        this.City = City;
        this.Zip_code = Zip_code;
        this.Dob = Dob;
    }



    public String getNational_id() {
        return National_id;
    }

    public void setNational_id(String National_id) {
        this.National_id = National_id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String Mname) {
        this.Mname = Mname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getZip_code() {
        return Zip_code;
    }

    public void setZip_code(String Zip_code) {
        this.Zip_code = Zip_code;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }
}
