package Model;

public class AccountHistory {
    private int id;
    private int accountId;
    private Boolean type;
    private double amount;
    private String description;

    double balance =0;

    Account account = new Account();
    public AccountHistory() {
    }

    public AccountHistory(int id, int accountId, Boolean type, double amount, String description) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public Boolean getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public synchronized void withDraw(int amount) {
//        System.out.println("Đang thực hiện giao dịch rút tiền " + amount);
//        while (balance < amount) {
//            System.out.println("Không đủ tiền rút!!!");
//            try {
//                wait(); // Chờ nạp tiền
//            } catch (InterruptedException ie) {
//                System.out.println(ie.toString());
//            }
//        }
//        balance -= amount;
//        System.out.println("Rút tiền thành công. Tài khoản của bạn hiện tại là " + balance);
//    }
//
//
//    public synchronized void dePosit(int amount) {
//        System.out.println("Đang thực hiện giao dịch nạp tiền " + amount);
//        balance += amount;
//        System.out.println("Nạp tiền thành công. Tài khoản của bạn hiện tại là " + balance);
//        notify(); // Thông báo đã nạp tiền
//    }





    @Override
    public String toString() {
        return "AccountHistory{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
