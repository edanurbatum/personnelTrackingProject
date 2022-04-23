
package connection;

public class Refectory {
    private String date;
    private String day;
    private String food1;
    private String food2;
    private String food3;
    private String food4;
    private String food5;

    public Refectory(String date, String day, String food1, String food2, String food3, String food4, String food5) {
        this.date = date;
        this.day = day;
        this.food1 = food1;
        this.food2 = food2;
        this.food3 = food3;
        this.food4 = food4;
        this.food5 = food5;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFood1() {
        return food1;
    }

    public void setFood1(String food1) {
        this.food1 = food1;
    }

    public String getFood2() {
        return food2;
    }

    public void setFood2(String food2) {
        this.food2 = food2;
    }

    public String getFood3() {
        return food3;
    }

    public void setFood3(String food3) {
        this.food3 = food3;
    }

    public String getFood4() {
        return food4;
    }

    public void setFood4(String food4) {
        this.food4 = food4;
    }

    public String getFood5() {
        return food5;
    }

    public void setFood5(String food5) {
        this.food5 = food5;
    }

    
}
