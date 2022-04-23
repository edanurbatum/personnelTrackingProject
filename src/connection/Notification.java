
package connection;

public class Notification {
    private String notificationId;
    private String notification;
    private String result;

    public Notification(String notificationId, String notification, String result) {
        this.notificationId = notificationId;
        this.notification = notification;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
   
}
