package page.enums;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public enum CustomerProfileMenuEnum implements CharSequence{
    MY_ORDERS("My Orders"),
    MY_RETURNS("My Returns");

    private final String menuName;

    CustomerProfileMenuEnum(String menuName) {
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
