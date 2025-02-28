package Postamat;

import java.math.BigDecimal;

public record Shipment(
        Dimensions dimensions, String description, BigDecimal weight
) {

    public BigDecimal getWeight() {
        return weight;
    }
}
