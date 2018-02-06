import java.util.*;

class Alg5_6 {

    public static void main(String[] args) {
        ArrayList<BankAccount> acctList = new ArrayList<BankAccount>();
        acctList.add(new BankAccount("Emilia Adelman", 1, 1000));
        acctList.add(new BankAccount("Lance Borger", 2, 1000));
        acctList.add(new BankAccount("Darryl Petrillose", 3, 1000));
        acctList.add(new BankAccount("Guy Yao", 4, 1000));
        acctList.add(new BankAccount("Darryl Petrillose", 5, 1000));
        acctList.add(new BankAccount("Clayton Laguardia", 6, 1000));
        acctList.add(new BankAccount("Neva Ballentine", 7, 1000));
        acctList.add(new BankAccount("Eve Ryburn", 8, 1000));
        acctList.add(new BankAccount("Matthew Housand", 9, 1000));
        acctList.add(new BankAccount("Clinton Castaldo", 10, 1000));

        System.out.println(getIndexOfGuard(acctList));
    }

    public static int getIndexOfGuard(ArrayList<BankAccount> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.split(" ")[1].contains("guard")) {
                System.out.println(list.get(i).name);
                return i;
            }
        }
        return -1;
    }
}
class BankAccount {
    public String name;
    public int acctNum;
    public int balance;

    public BankAccount(String n, int a, int b) {
        name = n;
        acctNum = a;
        balance = b;
    }
}
