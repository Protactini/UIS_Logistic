package com.uis.uis_logistic.model.IDs;
import java.io.Serializable;
import java.util.Objects;

public class PurchasingApplicationItemId implements Serializable {

    private Integer orderDetailsId;
    private Integer itemId;

    // Constructors
    public PurchasingApplicationItemId() {
    }

    public PurchasingApplicationItemId(Integer orderDetailsId, Integer itemId) {
        this.orderDetailsId = orderDetailsId;
        this.itemId = itemId;
    }

    // Getters and setters
    // ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasingApplicationItemId that = (PurchasingApplicationItemId) o;
        return Objects.equals(orderDetailsId, that.orderDetailsId) &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailsId, itemId);
    }
}
