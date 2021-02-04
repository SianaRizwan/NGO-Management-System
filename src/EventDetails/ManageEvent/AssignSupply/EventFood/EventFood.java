package EventDetails.ManageEvent.AssignSupply.EventFood;

public class EventFood {
    int availableQty,reqQty;
    String name;

    public EventFood(int availableQty, int reqQty, String name) {
        this.availableQty = availableQty;
        this.reqQty = reqQty;
        this.name = name;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public int getReqQty() {
        return reqQty;
    }

    public void setReqQty(int reqQty) {
        this.reqQty = reqQty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
