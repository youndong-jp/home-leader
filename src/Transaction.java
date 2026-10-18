import java.util.InputMismatchException;

public class Transaction {

    private String category;
    private int cost;

    public void setCost(int cost){
            if(cost<=0){
                throw new IllegalArgumentException("금액은 0 보다 커야합니다 ");
            }
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