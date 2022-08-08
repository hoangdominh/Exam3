package Model;

import java.util.Comparator;
import java.util.Locale;

public class SortAccountByName implements Comparator<Account> {
    public int compare(Account o1, Account o2) {
        String ac1 = o1.getFullName();
        String ac2 = o2.getFullName();
        ac1 = ac1.replaceAll(" ", "");
        ac2 = ac2.replaceAll(" ", "");
        return ac1.toUpperCase(Locale.ROOT).compareTo(ac2.toUpperCase(Locale.ROOT));
    }

}
