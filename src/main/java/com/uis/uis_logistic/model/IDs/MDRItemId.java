package com.uis.uis_logistic.model.IDs;
import java.io.Serializable;
import java.util.Objects;

public class MDRItemId implements Serializable {

    private Integer mdrId;
    private Integer itemId;

    // Constructors
    public MDRItemId() {
    }

    public MDRItemId(Integer mdrId, Integer itemId) {
        this.mdrId = mdrId;
        this.itemId = itemId;
    }

    // Getters and setters
    // ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MDRItemId that = (MDRItemId) o;
        return Objects.equals(mdrId, that.mdrId) &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mdrId, itemId);
    }
}
