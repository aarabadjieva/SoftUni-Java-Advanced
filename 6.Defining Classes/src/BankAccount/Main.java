package BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<BankAccount> clients = new ArrayList<>();
        while (!input.equals("End")){
            String[] cmd = input.split("\\s+");
            switch (cmd[0]){
                case "Create":
                    BankAccount account = new BankAccount();
                    System.out.printf("Account ID%d created%n",account.getId());
                    clients.add(account);
                    break;
                case "Deposit":
                    int id = Integer.parseInt(cmd[1])-1;
                    double amount = Double.parseDouble(cmd[2]);
                    if (id<clients.size()&&id>=0){
                        clients.get(id).deposit(amount);
                        System.out.printf("Deposited %s to ID%d%n",cmd[2],clients.get(id).getId());
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                        BankAccount.setInterestRate(Double.parseDouble(cmd[1]));
                    break;
                case "GetInterest":
                    id = Integer.parseInt(cmd[1])-1;
                    int years = Integer.parseInt(cmd[2]);
                    if (id>=0&&id<clients.size()){
                        System.out.printf("%.2f%n",clients.get(id).getInterestRate(years));
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
