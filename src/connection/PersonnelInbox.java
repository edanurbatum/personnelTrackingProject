
package connection;

public class PersonnelInbox {
    private String notificationId;
    private String notification;
    private String name;
    private String lastName;
    private String tc;
    private String result;

    public PersonnelInbox(String notificationId, String notification, String name, String lastName, String tc, String result) {
        this.notificationId = notificationId;
        this.notification = notification;
        this.name = name;
        this.lastName = lastName;
        this.tc = tc;
        this.result = result;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
