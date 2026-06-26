package page.enums;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public enum LogisticsMenuEnum implements CharSequence {
    DASHBOARD("Dashboard"),
    LAST_MILE("Last Mile"),
    FIRST_MILE("First Mile"),
    FIRST_MILE_QCC("First Mile QCC"),
    QCC_MASTERPACK_CREATION("QCC Masterpack Creation"),
    QCC_MASTERPACK_TRANSFER("QCC Master Pack Transfer"),
    FIRST_MILE_RETURN("First Mile Return"),
    FMR_MASTERPACK_TRANSFER("FMR Masterpack Transfer"),
    FMR_LOAD_MASTERPACK("FMR Load Masterpack"),
    FMR_PACKAGE_RECEIVE("FMR Package Receive"),
    DROP_OFF_SELLER_DELIVERY("DropOff Seller Delivery"),
    SORT("Sort"),
    SORT_PACKAGE_RECEIVE("Sort Package Receive"),
    SORT_MASTER_PACK_CREATION("Sort Master Pack Creation"),
    SORT_MASTER_PACK_TRANSFER("Sort Master Pack Transfer"),
    SORT_LOAD_PACKAGE("Sort Load  Package"),
    FORWARD_PACKAGE_RECEIVE("Forward Package Receive"),
    WAITING_FOR_PICKUP("Waiting For Pick-Up"),
    PACKAGE_RECEIVE("Package Receive"),
    MU_PACKAGE_RECEIVE("MU Package Receive"),
    RETURN_MU_RECEIVE("Return MU Receive"),
    RETURN_ORDER_PACKAGE("Return Order Package"),
    MASTER_PACK_TRANSFER("Master Pack Transfer"),
    SAME_HUB_DELIVERY_REQUEST("Same Hub Delivery Request"),
    SAME_HUB_HANDOVER_REQUEST("Same hub Handover Request"),
    MASTERPACK_CREATION("Masterpack Creation"),
    MASTERPACK_TRANSFER("Masterpack Transfer"),
    LOAD_MASTERPACK("Load Masterpack"),
    MASTER_PACK_CREATION("Master Pack Creation"),
    First_Mile_QCC("First Mile QCC"),
    QCC_Package_Receive("QCC Package Receive"),
    QCC_APPROVAL("QCC Approval"),
    QCC_PACKAGING("QCC Packaging"),
    FMR_MASTERPACK_CREATION("FMR Masterpack Creation");



    private final String menuName;

    LogisticsMenuEnum(String menuName) {
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

