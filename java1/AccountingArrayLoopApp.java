public class AccountingArrayLoopApp {
    public static void main(String[] args) {
        double valueOfSupply = Double.parseDouble(args[0]);
        
        double vatRate = 0.1;
        double expenseRate = 0.3;

        double[] dividendRates = new double[3];

        dividendRates[0] = 0.5;
        dividendRates[1] = 0.3;
        dividendRates[2] = 0.2;

        double vat = valueOfSupply * vatRate;
        double total = valueOfSupply + vat;
        double expense = valueOfSupply * expenseRate;
        double income = valueOfSupply - expense;

        double[] dividends = new double[3];

        for(int i = 0; i < dividendRates.length; i++) {
            dividends[i] = income * dividendRates[i];
        }

        System.out.println("Value of supply: " + valueOfSupply);
        System.out.println("VAT: " + vat);
        System.out.println("Total: " + total);
        System.out.println("Expense:" + expense);
        System.out.println("Income:" + income);

        for(int i = 0; i < dividends.length; i++) {
            System.out.printf("Dividend %d: %.1f\n", i + 1, dividends[i]);
        }
    }   
}