
package connection;

public class Permit {
    private int permitRecordNo;
    private String tc;
    private String name;
    private String lastname;
    private int remainingPermitAmount;
    private String permitStart;
    private String permitFinish;
    private String permitType;
    private int usedPermitAmount;
    
    public Permit(int permitRecordNo, String tc, String name, String lastname, int remainingPermitAmount, String permitStart, String permitFinish, String permitType, int usedPermitAmount) {
        this.permitRecordNo = permitRecordNo;
        this.tc = tc;
        this.name = name;
        this.lastname = lastname;
        this.remainingPermitAmount = remainingPermitAmount;
        this.permitStart = permitStart;
        this.permitFinish = permitFinish;
        this.permitType = permitType;
        this.usedPermitAmount = usedPermitAmount;
    }

    public Permit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPermitRecordNo() {
        return permitRecordNo;
    }

    public void setPermitRecordNo(int permitRecordNo) {
        this.permitRecordNo = permitRecordNo;
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

    
}
