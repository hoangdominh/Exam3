package Controller;

import Model.Account;
import Model.AccountHistory;
import Model.SortAccountByName;
import sun.rmi.runtime.NewThreadAction;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AccountList {
    public ArrayList<Account> accountList;

    public ArrayList<AccountHistory> accountHistoryList = new ArrayList<AccountHistory>();

    Scanner scanner = new Scanner(System.in);

    public AccountList() {
        this.accountList = new ArrayList<Account>();
    }

    public AccountList(ArrayList<Account> accountList, ArrayList<AccountHistory> accountHistoryList) {
        this.accountList = accountList;
        this.accountHistoryList = accountHistoryList;
    }

    //    Nhap account
    public void addAccount(Account account) {
        this.accountList.add(account);
    }

    //    In ra man hinh danh sach account
    public void printAccount() {
        for (Account o : accountList) {
            System.out.println(o.toString());
        }
    }


    //    Nhap ID cho sửa thông tin Account
    public void editAccount() {
        System.out.println("Nhập id account bạn muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Account account : accountList) {
            if (account.getId() == id) {
                account.input();
                break;
            }
        }
    }


    //    Nhap ID cho xoa thong tin Account va AccountHistory
    public void removeAccount() {
        System.out.println("Nhập id account mà bạn muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Account account : accountList) {
            if (account.getId() == id) {
                accountList.remove(account);
                break;
            }
        }
    }

//    Nhập tên và tìm kiếm Account đã nhập

    public void searchAccount(String fullName) {
        for (Account account : accountList) {
            if (account.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println(account);
            }
        }
    }

    //    In ra danh sách Account sắp xếp theo tên
    public void sortAccountByName() {
        Collections.sort(accountList, new SortAccountByName());
    }

    //    Ghi file
    public void writeToFile(String path) {
        try {
            System.out.println("Luu thanh cong");
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accountList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//        Đọc File

    public List<Account> readDataFromFile(String path) {
        List<Account> arrayList = new ArrayList<>();
        try {
            System.out.println("Đọc thành công");
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            arrayList = (List<Account>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

//    public void withDraw() {
//        System.out.println("Nhap id account can tru tien: ");
//        int id = scanner.nextInt();
//        for (Account account : accountList) {
//            if (account.getId() == id) {
//                hamTru(account);
//                break;
//            }
//        }
//
//    }
//
//    public void withDraw2() {
//        System.out.println("Nhap id account can tru tien: ");
//        int id = scanner.nextInt();
//        for (Account account : accountList) {
//            if (account.getId() == id) {
//                hamCong(account);
//                break;
//            }
//        }
//
//    }
//
//    public void hamTru(Account account){
//        System.out.println("Nhap so tien muon tru: ");
//        Double money = scanner.nextDouble();
//        Double newAmount = account.getAmount() - money;
////        System.out.println("Nhập mô tả: ");
////        String des = scanner.nextLine();
//        account.setAmount(newAmount);
//        accountHistoryList.add(new AccountHistory(3,account.getId(),true,newAmount,"Mô tả 1"));
//        account.setAccountHistories(accountHistoryList);
//        System.out.println("Da tru tien account thanh cong");
//    }
//
//
//    public void hamCong(Account account){
//        System.out.println("Nhap so tien muon cong: ");
//        Double money = scanner.nextDouble();
//        Double newAmount = account.getAmount() + money;
//        account.setAmount(newAmount);
//        System.out.println("Da cong tien account thanh cong");
//    }

    public void hamCongggg(){
        System.out.println("Nhap id accout muon cong tien");
        int id = scanner.nextInt();
        for (Account account : accountList){
            if (account.getId() ==id){
                boolean check = false;
                while (check==false){
                    System.out.println("Nhajp so tien ban muon cong them: ");
                    double money = scanner.nextDouble();
                    Double newAmount = account.getAmount() + money;
                    account.setAmount(newAmount);
                    String des = scanner.nextLine();
                    accountHistoryList.add(new AccountHistory(2,account.getId(),true,money,"Cong"));
                    account.setAccountHistories(accountHistoryList);
                    check=true;
                }
            }
        }
    }


    public void hamTruu(){
        System.out.println("Nhap id accout muon cong tien");
        int id = scanner.nextInt();
        for (Account account : accountList){
            if (account.getId() ==id){
                boolean check = false;
                while (check==false){
                    System.out.println("Nhap so tien ban muon tru them: ");
                    double money = scanner.nextDouble();
                    if (account.getAmount()< money){
                        System.out.println("So tien khong du !!!");
                    } else {
                        Double newAmount = account.getAmount() - money;
                        account.setAmount(newAmount);
                        String des = scanner.nextLine();
                        accountHistoryList.add(new AccountHistory(3,account.getId(),true,money,"Rut tien"));
                        account.setAccountHistories(accountHistoryList);
                        check=true;
                    }
                }
            }
        }
    }
}


