import java.util.LinkedList;
import java.util.List;

public class BankUserList {
    private LinkedList<BankUser> list = new LinkedList<BankUser>();

    public BankUserList() {
        BankUser user1 = new BankUser("admin", "admin", 12345450);
        list.add(user1);
        BankUser user2 = new BankUser("avesh", "12345678", 675680);
        list.add(user2);
        BankUser user3 = new BankUser("purvi", "12345678", 234460);
        list.add(user3);
        BankUser user4 = new BankUser("nitin", "12345678", 12323550);
        list.add(user4);
        BankUser user5 = new BankUser("survesh", "12345678", 233450);
        list.add(user5);
    }

    public BankUser getBankUser(String username, String password) {
        for (BankUser temp : list) {
            if (temp.getUsername().equals(username) && temp.getPassword().equals(password))
                return temp;
        }
        return null;
    }
}
