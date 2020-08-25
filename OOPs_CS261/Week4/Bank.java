package OOPs_CS261.Week4;

import java.util.Scanner;

class User {
    String username;
    int pin;
    int accountType;
    double balance;
    int duration;

    User() {
        this.username = "";
        this.pin = -1;
        this.balance = 0.0;
        this.duration = 0;

    }

    User(String username, int pin, int accountType, double balance) {
        this.username = username;
        this.pin = pin;
        this.accountType = accountType;
        this.balance = balance;
    }

    void depositMoney(int money, int duration, int accountType) {
        System.out.println("Your Balance is ");
        if (accountType == 1) {
            for (int i = 1; i <= duration; i++) {
                if (balance < 500) {
                    balance -= 100;

                } else {
                    if (50 <= (0.1 * balance)) {
                        balance = balance - 50;

                    } else {
                        balance = balance - (0.1 * balance);

                    }

                }
                balance += money;
            }

        } else if (accountType == 2) {
            for (int i = 1; i <= duration; i++) {
                if (50 < (0.1 * balance)) {
                    balance = balance - 50;
                } else {
                    balance = balance - (0.1 * balance);
                }

                balance += balance * 0.07;
            }
            balance += money;
        } else if (accountType == 3) {
            for (int i = 1; i <= duration; i++) {
                if (balance < 1000) {
                    balance -= 50;
                } else {
                    if (50 < (0.1 * balance)) {
                        balance = balance - 50;
                    } else {
                        balance -= (0.1 * balance);
                    }
                }
            }
            balance += balance * (0.07 / 12);
            balance += money;
            balance -= money * 0.001;
        } else {
            for (int i = 1; i <= duration; i++) {
                if (50 < (0.1 * balance)) {
                    balance = balance - 50;
                } else {
                    balance = balance - (0.1 * balance);
                }
                if (i % 12 == 0) {
                    balance += balance * (0.15);
                }

            }
            balance += money;

        }
        System.out.println("Money is deposited");
    }

    void withdrawMoney(int money, int duration, int accountType) {

        if (accountType == 1) {
            for (int i = 1; i <= duration; i++) {
                if (balance < 500) {
                    balance -= 100;

                } else {
                    if (50 <= (0.1 * balance)) {
                        balance = balance - 50;

                    } else {
                        balance = balance - (0.1 * balance);

                    }

                }
                balance -= money;
            }

        } else if (accountType == 2) {
            for (int i = 1; i <= duration; i++) {
                if (50 < (0.1 * balance)) {
                    balance = balance - 50;
                } else {
                    balance = balance - (0.1 * balance);
                }

                balance += balance * 0.07;
            }
            balance -= money;
        } else if (accountType == 3) {
            for (int i = 1; i <= duration; i++) {
                if (balance < 1000) {
                    balance -= 50;
                } else {
                    if (50 < (0.1 * balance)) {
                        balance = balance - 50;
                    } else {
                        balance -= (0.1 * balance);
                    }
                }
            }
            balance += balance * (0.07 / 12);
            balance -= money;
            balance -= money * 0.001;
        } else {
            for (int i = 1; i <= duration; i++) {
                if (50 < (0.1 * balance)) {
                    balance = balance - 50;
                } else {
                    balance = balance - (0.1 * balance);
                }
                if (i % 12 == 0) {
                    balance += balance * (0.15);
                }

            }
            balance -= money;
            if (duration > 12) {
                balance -= (balance * 0.2);

            }

        }
        System.out.println("Money is withdrawn");
    }

    void displayBalance(int duration, int accountType) {
        // System.out.println("Your Balance is " + balance);
        if (accountType == 1) {
            for (int i = 1; i <= duration; i++) {
                if (balance < 500) {
                    balance -= 100;

                } else {
                    if (50 <= (0.1 * balance)) {
                        balance = balance - 50;

                    } else {
                        balance = balance - (0.1 * balance);

                    }

                }

            }

        } else if (accountType == 2) {
            for (int i = 1; i <= duration; i++) {
                if (50 < (0.1 * balance)) {
                    balance = balance - 50;
                } else {
                    balance = balance - (0.1 * balance);
                }

                balance += balance * 0.07;
            }

        } else if (accountType == 3) {
            for (int i = 1; i <= duration; i++) {
                if (balance < 1000) {
                    balance -= 50;
                } else {
                    if (50 < (0.1 * balance)) {
                        balance = balance - 50;
                    } else {
                        balance -= (0.1 * balance);
                    }
                }
            }
            balance += balance * (0.07 / 12);

        } else {
            for (int i = 1; i <= duration; i++) {
                if (50 < (0.1 * balance)) {
                    balance = balance - 50;
                } else {
                    balance = balance - (0.1 * balance);
                }
                if (i % 12 == 0) {
                    balance += balance * (0.15);
                }

            }

        }
        System.out.println("Your Balance is " + balance);
    }

}

class Bank {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        User customer[] = new User[100];
        int totalUsers = 0;
        int ch = 1;
        String name;
        int pin, accountType, initialBalace;
        while (ch != 0) {
            ch = 0;
            System.out.println("Type\n 1. New User \n 2. Old User \n0.Exit");
            ch = sc.nextInt();
            if (ch != 0) {
                if (ch == 1) {

                    System.out.println("Enter your name");
                    name = sc.next();
                    System.out.println("Enter your pin");
                    pin = sc.nextInt();
                    System.out.println(
                            "Enter your account type \n 1.Regular Account \n 2. Interest Account \n 3. Checking Account \n 4. CD Account");
                    accountType = sc.nextInt();
                    System.out.println("Enter your Iniatial Amount");
                    initialBalace = sc.nextInt();

                    User users = new User(name, pin, accountType, initialBalace);
                    totalUsers++;
                    customer[totalUsers] = users;
                    System.out.println("New User Created Successfully\n");

                }

                if (totalUsers >= 1) {
                    int currentUser = 1;
                    System.out.println("Enter your name");
                    name = sc.next();
                    System.out.println("Enter your pin");
                    pin = sc.nextInt();

                    int i = 1;
                    // System.out.println(name + " $");
                    while (i < totalUsers && !name.equals(customer[i].username)) {
                        i++;
                    }
                    // System.out.println(name.equals(customer[1].username) + " %");
                    if (!name.equals(customer[i].username)) {
                        System.out.println("No User Found.\nTry Again");
                    } else {
                        currentUser = i;
                        while (pin != customer[currentUser].pin) {
                            System.out.println("Wrong Pin.\nEnter your pin");
                            pin = sc.nextInt();

                        }
                        System.out.println(customer[currentUser].username + "Logined Successfully\n");
                        int ch2 = 1;
                        while (ch2 != 0) {
                            System.out.println("Type\n 1.Withdraw\n 2. Deposit\n 3. Display\n 0. Log out");
                            ch2 = sc.nextInt();
                            if (ch2 == 1) {
                                int money;
                                int duration;
                                System.out.println("Enter the amount to be withdrawn");
                                money = sc.nextInt();
                                System.out.println("Enter the duration since your last transaction");
                                duration = sc.nextInt();
                                customer[i].depositMoney(money, duration, customer[i].accountType);
                                customer[i].displayBalance(0, customer[i].accountType);

                            } else if (ch2 == 2) {
                                int money;
                                int duration;
                                System.out.println("Enter the amount to be deposit");
                                money = sc.nextInt();
                                System.out.println("Enter the duration since your last transaction");
                                duration = sc.nextInt();
                                customer[i].depositMoney(money, duration, customer[i].accountType);
                                customer[i].displayBalance(0, customer[i].accountType);

                            } else if (ch2 == 3) {
                                int duration;
                                System.out.println("Enter the duration since your last transaction");
                                duration = sc.nextInt();
                                customer[i].displayBalance(duration, customer[i].accountType);

                            }

                        }

                    }

                } else 
                {
                    System.out.println("No User in the bank.\nPlz create an account\n");

                }

            }

        }
        sc.close();
    }

}
