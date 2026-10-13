import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();

        int menu = -1;

        while (menu != 0) {

            System.out.println("===== Home Ledger =====");
            System.out.println("1. 지출 등록");
            System.out.println("2. 지출 목록");
            System.out.println("3. 총 지출 확인");
            System.out.println("0. 종료");

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("지출 등록 선택");
                    Transaction transaction = new Transaction();
                    System.out.println("카테고리를 입력하세요:");
                    transaction.category=sc.nextLine();
                    System.out.println("금액을 입력하세요:");
                    transaction.cost=sc.nextInt();
                    transactions.add(transaction);
                    break;

                case 2:
                    System.out.println("지출 목록 ");
                    for(int i=0;i<transactions.size();i++ ){
                        System.out.println(
                                "번호:"+(i+1 )
                                +"지출 카테고리: "+transactions.get(i).category
                                +"지출비용: "+transactions.get(i).cost+"원"
                        );
                    }
                    break;

                case 3: {
                    System.out.println("총 지출 확인 선택");
                    int totalCost = 0;
                    for (int i = 0; i < transactions.size(); i++) {
                        totalCost += transactions.get(i).cost;
                    }

                    System.out.println("총 지출: " + totalCost + "원");
                    break;
                }
                case 0:
                    System.out.println("종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }

    }
}