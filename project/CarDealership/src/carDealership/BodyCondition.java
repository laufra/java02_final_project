package carDealership;

public enum BodyCondition {

    USED,
    NEW;

    private String condition;

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
