package connection;


public class Employee {
    private int id;
    private String name;
    private String lastname;
    private String gender;
    private String tc;
    private String address;
    private String userName;
    private String phoneNumber;
    private int salary;

    public Employee(int id, String name, String lastname, String gender, String tc, String address, String userName,String phoneNumber, int salary) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.tc = tc;
        this.address = address;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}