public class Transaction {

    private String category;
    private int cost;

    Transaction(String category, int cost) {
        this.category = category;
        this.cost = cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }
    public int getCost(){
        return cost;
    }
}