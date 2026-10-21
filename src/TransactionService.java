import java.util.ArrayList;

public class TransactionService {

    public int calculateTotal(ArrayList<Transaction> transactions) {
    int totalCost = 0;
    for (Transaction transaction : transactions) {
        totalCost += transaction.getCost();
    }
    return totalCost;
}

    public ArrayList<Transaction> foundCategory(ArrayList<Transaction> transactions, String foundName) {
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            String name = transaction.getCategory();
            if (foundName.equals(name)) {
                result.add(transaction);
            }
        }return result;
        }
    }
