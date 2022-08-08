package View;

import Controller.AccountList;
import Model.Account;
import Model.AccountHistory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountHistory accountHistory = new AccountHistory();
        AccountList accountList = new AccountList();
        int luaChon =0;
        do {
            System.out.println("----------------Menu------------");
            System.out.println("1. Cho phép nhập Account");
            System.out.println("2. In ra màn hình danh sách Account");
            System.out.println("3. Nhập ID Account cho sửa thông tin Account: ");
            System.out.println("4. Nhập ID Account cho xóa thông tin Account và AccountHistory: ");
            System.out.println("5. Nhập tên vào tìm kiếm Account trong list đã nhập: ");
            System.out.println("6. In ra danh sách Account sắp xếp theo tên.");
            System.out.println("7. Lưu File");
            System.out.println("8. Đọc File");
            System.out.println("9. Chức năng trừ tiền (xử lý synchronized): ");
            System.out.println("10. Chức năng cộng tiền (xử lý synchronized): ");

            System.out.println("Chọn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();
            if (luaChon == 1) {
                System.out.println("Nhập fullName: ");
                String fullName = scanner.nextLine();
                System.out.println("Nhập accountNumber: ");
                int accountNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập amount");
                double amount = Double.parseDouble(scanner.nextLine());
                Account account = new Account(fullName,accountNumber,amount);
                accountList.addAccount(account);

            } else if (luaChon==2) {
                accountList.printAccount();
            } else if (luaChon==3) {
                accountList.editAccount();
            } else if (luaChon==4) {
                accountList.removeAccount();
            } else if (luaChon==5) {
                System.out.println("Nhập tên Account mà bạn muốn tìm: ");String ten = scanner.nextLine();
                accountList.searchAccount(ten);
            } else if (luaChon==6) {
                accountList.sortAccountByName();
                accountList.printAccount();
            } else if (luaChon==7) {
                accountList.writeToFile("C:\\Users\\hoangdm13\\IdeaProjects\\ExamPart3\\Exam3\\src\\Account");

            } else if (luaChon==8){
                List<Account> accountDataFromFile = accountList.readDataFromFile("C:\\Users\\hoangdm13\\IdeaProjects\\ExamPart3\\Exam3\\src\\Account");
                for (Account account : accountDataFromFile){
                    System.out.println(account);
                }
            } else if(luaChon==9){
                accountList.hamTruu();
                accountList.writeToFile("C:\\Users\\hoangdm13\\IdeaProjects\\ExamPart3\\Exam3\\src\\AccountHistory");

            } else if (luaChon==10){
                accountList.hamCongggg();
                List<Account> accountDataFromFile = accountList.readDataFromFile("C:\\Users\\hoangdm13\\IdeaProjects\\ExamPart3\\Exam3\\src\\AccountHistory");
                for (Account account : accountDataFromFile){
                    System.out.println(account);
                }
            }
        } while (luaChon != 0) ;
    }
}
