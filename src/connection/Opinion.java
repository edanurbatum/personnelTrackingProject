
package connection;

public class Opinion {
    private String opinionId;
    private String tc;
    private String name;
    private String lastName;
    private String opinion;

    public Opinion(String opinionId, String tc, String name, String lastName, String opinion) {
        this.opinionId = opinionId;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.opinion = opinion;
    }

    public String getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(String opinionId) {
        this.opinionId = opinionId;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
