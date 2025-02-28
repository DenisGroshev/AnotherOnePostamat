package Postamat;

import java.math.BigDecimal;

public record Dimensions(
    BigDecimal width,
    BigDecimal height,
    BigDecimal depth){

    public boolean canHold(Dimensions dimensions){
        return this.width.compareTo(dimensions.width)>=0&&
                this.height.compareTo(dimensions.height)>=0&&
                this.depth.compareTo(dimensions.depth)>=0;
    }
}
