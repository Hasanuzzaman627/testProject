package page.enums;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public enum InventoryMenuEnum implements CharSequence {

    OPERATION("Operation"),
    OUTBOUND("Outbound"),
    OUTBOUND_ORDERS("Outbound Orders"),
    COMMERCIAL("Commercial"),
    OUTBOUND_ORDERS_Approval("Outbound Order Approval"),
    PACKING ("Packing"),
    MASTER_PACK_CREATE("Master Pack Create");

    private final String menuName;

    InventoryMenuEnum(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @NotNull
    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @NotNull
    @Override
    public String toString() {
        return menuName;
    }
}
