import java.util.Arrays;
import java.util.Scanner;

class incomeExpenser {
    public static double incomeTotal;
    public static double expenseTotal;
    public static int borderWidth = 107;
    public static String User;
    public static char[] expenseType = new char[80];
    public static double[] income = new double[80];
    public static double[] expenses = new double[80];

    public incomeExpenser() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        System.out.print("Type your name: ");
        User = var1.nextLine();
        System.out.printf("%s, what do you want to do? (Type 'income' or 'expenses') ", User);
        String var2 = var1.nextLine();
        if (var2.equalsIgnoreCase("expenses") && chosenExpenses(var2)) {
            expenseCalculator();
        } else if (var2.equalsIgnoreCase("income")) {
            trackIncome();
        }

        if (chosenExpenses(var2)) {
            System.out.println("Now enter your income!");
            trackIncome();
        } else {
            System.out.println("Now enter your expenses!");
            expenseCalculator();
        }

        output();
    }

    public static void expenseCalculator() {
        Scanner var0 = new Scanner(System.in);
        int var1 = 0;
        System.out.print("Input your expense: ");
        double var3;
        expenses[0] = var3 = var0.nextDouble();
        System.out.print("What type of expense is this(L-luxury,B-bills,G-groceries,P-personal)? ");
        char var2 = var0.next().charAt(0);

        for(expenseType[0] = var2; var3 != 0.0; var2 = var0.next().charAt(0)) {
            expenseType[var1] = var2;
            expenses[var1++] = var3;
            System.out.print("Input your expense: ");
            var3 = var0.nextDouble();
            System.out.print("What type of expense is this(L-luxury,B-bills,G-groceries,P-personal)? ");
        }

        expenseTotal = Arrays.stream(expenses).sum();
    }

    public static void trackIncome() {
        Scanner var0 = new Scanner(System.in);
        int var3 = 0;
        System.out.print("Input your income: ");
        double var1 = var0.nextDouble();

        for(income[var3] = var1; !(var1 <= 0.0); var1 = var0.nextDouble()) {
            income[var3++] = var1;
            System.out.print("Input your income: ");
        }

        incomeTotal = Arrays.stream(income).sum();
    }

    public static void output() {
        String var0 = "Income";
        String var1 = "Expense";
        String var2 = "Total";

        int var3;
        for(var3 = 0; var3 < borderWidth; ++var3) {
            System.out.print("=");
        }

        System.out.println();
        System.out.printf("|| %-31s |", var0);
        System.out.printf("| %-31s |", var1);
        System.out.printf("| %-31s ||", var2);
        System.out.println();

        for(var3 = 0; var3 < borderWidth; ++var3) {
            System.out.print("=");
        }

        System.out.println();

        for(var3 = 0; var3 < expenses.length - 1; ++var3) {
            while(income[var3] != 0.0 || expenses[var3] != 0.0) {
                System.out.printf("|| $%-30.2f || $%-23.2f %-6c ||\t\t\t \t ||\n", income[var3], expenses[var3], expenseType[var3]);
                ++var3;
            }
        }

        for(var3 = 0; var3 < borderWidth; ++var3) {
            System.out.print("=");
        }

        System.out.println();
        double var6 = actualIncome();
        System.out.printf("|| $%-30.2f || $%-30.2f |", incomeTotal, expenseTotal);
        System.out.printf("|  $%-29.2f ||", var6);
        System.out.println();

        for(int var5 = 0; var5 < borderWidth; ++var5) {
            System.out.print("=");
        }

        System.out.println();
    }

    public static double actualIncome() {
        double var0 = Arrays.stream(income).sum();
        double var2 = Arrays.stream(expenses).sum();
        return var0 - var2;
    }

    public static boolean chosenExpenses(String var0) {
        return var0.equalsIgnoreCase("expenses");
    }
}
