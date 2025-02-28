package Postamat;

import java.math.BigDecimal;

public class Postamat {
    private final PostCell[] cells;

    public Postamat(PostCell[] cells) {
        this.cells = cells;
    }

    public Integer putShipment(Shipment shipment) {
        for (int cellNumber = 0; cellNumber <= cells.length; cellNumber++) {
            PostCell cell = cells[cellNumber];
            if (cell.canAcceptShipment(shipment)) {
                boolean isPutSucces=cell.putShipment(shipment);
                if (isPutSucces) {
                    System.out.println("Груз успешно размещён в ячейке");
                }
                return cellNumber;
            }
        }
        System.out.println("Не удалось поместить груз, нет подходящей ячейки");
        return null;
    }
    public Shipment getShipment(int numberOfCell){
        if(numberOfCell<0||numberOfCell>cells.length){
            System.out.println("Ячейки с этим номером не найдено");
        }
        return cells[numberOfCell].extractShipment();
    }
    public BigDecimal weightAllShipments() {
        BigDecimal weightAll = BigDecimal.valueOf(0);
        for (PostCell cell : cells) {
            if (cell.hasShipment()) {
                weightAll = weightAll.add(cell.extractShipment().getWeight());
            }
        }
        return weightAll;
    }

}

