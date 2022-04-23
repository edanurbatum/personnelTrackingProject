
package connection;

public class PermitRequest {
    
    private String tc;
    private String name;
    private String lastname;
    private int remainingPermitAmount;
    private String permitStart;
    private String permitFinish;
    private String permitType;
    private int usedPermitAmount;
    private String response;

    
    public PermitRequest(String tc, String name, String lastname, int remainingPermitAmount, String permitStart, String permitFinish, String permitType, int usedPermitAmount, String response) {
        this.tc = tc;
        this.name = name;
        this.lastname = lastname;
        this.remainingPermitAmount = remainingPermitAmount;
        this.permitStart = permitStart;
        this.permitFinish = permitFinish;
        this.permitType = permitType;
        this.usedPermitAmount = usedPermitAmount;
        this.response = response;
    }
    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
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

    public int getRemainingPermitAmount() {
        return remainingPermitAmount;
    }

    public void setRemainingPermitAmount(int remainingPermitAmount) {
        this.remainingPermitAmount = remainingPermitAmount;
    }

    public String getPermitStart() {
        return permitStart;
    }

    public void setPermitStart(String permitStart) {
        this.permitStart = permitStart;
    }

    public String getPermitFinish() {
        return permitFinish;
    }

    public void setPermitFinish(String permitFinish) {
        this.permitFinish = permitFinish;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public int getUsedPermitAmount() {
        return usedPermitAmount;
    }

    public void setUsedPermitAmount(int usedPermitAmount) {
        this.usedPermitAmount = usedPermitAmount;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}