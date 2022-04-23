
package connection;

public class Requirement {
    private String requirementId;
    private String requirement;
    private String name;
    private String lastName;
    private String tc;
    private String result;

    public Requirement(String requirementId, String requirement, String name, String lastName, String tc, String result) {
        this.requirementId = requirementId;
        this.requirement = requirement;
        this.name = name;
        this.lastName = lastName;
        this.tc = tc;
        this.result = result;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
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
