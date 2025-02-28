package Postamat;
public class PostCell {
    private final Dimensions dimensions;
    private CellStatus cellStatus;
    private Shipment shipment;

    public PostCell(Dimensions dimensions){
        this.dimensions=dimensions;
        cellStatus=CellStatus.WORK;
    }
    public boolean hasShipment(){
        return shipment!=null;
    }

    public boolean canAcceptShipment(Shipment shipment) {
        if (hasShipment()) {
            return false;
        }
        if (cellStatus != CellStatus.WORK){
            return false;
        }
        return dimensions.canHold(shipment.dimensions());
    }

    public boolean putShipment(Shipment shipment){
        if(!canAcceptShipment(shipment)){
            System.out.println("Груз невозможно разместить в ячейке "+this);
            return false;
        }
        this.shipment=shipment;
        return true;
    }
    public Shipment extractShipment(){
        var extractedShipment=this.shipment;
        this.shipment=null;
        return extractedShipment;
    }
    public void turnMaintenanceMode(){
        if(hasShipment()){
            System.out.println("Невозможно включить режим обслуживания - в ячейке есть груз");
            return;
        }
        cellStatus=CellStatus.AT_MAINTENANCE;
    }
    public void turnWorkingMode(){
        cellStatus=CellStatus.WORK;
    }


}
