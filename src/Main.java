import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();

        int menu = -1;
        while (menu != 0) {
            printMenu();
            try {
                menu = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("메뉴는 숫자로 입력해주세요");
                sc.nextLine();
                continue;
            }
            switch (menu) {
                case 1:
                    System.out.println("지출 등록 선택");
                    System.out.println("카테고리를 입력하세요:");
                    String category = sc.nextLine();
                    int cost = 0;
                    while(true){
                        try{System.out.println("금액을 입력하세요:");
                            cost = sc.nextInt();
                           if(cost<=0){
                               System.out.println("잘못된 금액입니다.");
                               continue;
                           }else{
                               break;
                           }
                    }catch (InputMismatchException e) {
                        System.out.println("숫자만 입력해주세요");
                        sc.nextLine();
                        }
                        }
                    Transaction transaction = new Transaction(category,cost);
                    transactions.add(transaction);
                    System.out.println("지출이 등록되었습니다");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("지출 목록 ");
                    for (int i = 0; i < transactions.size(); i++) {
                        System.out.println("번호:" + (i + 1)
                                + "지출 카테고리: " + transactions.get(i).getCategory()
                                + "지출비용: " + transactions.get(i).getCost() + "원");
                    }
                    break;

                case 3: {
                    System.out.println("총 지출 확인 선택");
                    int totalCost = calculateTotal(transactions);
                    System.out.println("총 지출: " + totalCost + "원");
                    break;
                }
                case 4: {
                    System.out.println("검색할 카테고리를 입력하세요:");
                    String foundCategory = sc.nextLine();
                    foundCategory(transactions,foundCategory);
                }
                break;
                case 0:
                    System.out.println("종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        }
    }

    static void printMenu() {

        System.out.println("===== Home Ledger =====");
        System.out.println("1. 지출 등록");
        System.out.println("2. 지출 목록");
        System.out.println("3. 총 지출 확인");
        System.out.println("4. 카테고리 검색");
        System.out.println("0. 종료");
    }

    static int calculateTotal(ArrayList<Transaction> transactions) {
        int totalCost = 0;
        for (int i = 0; i < transactions.size(); i++) {
            totalCost += transactions.get(i).getCost();
        }
        return totalCost;
    }

    static void foundCategory(ArrayList<Transaction> transactions, String foundName) {
        boolean found = false;
        for (Transaction transaction : transactions) {
            String name = transaction.getCategory();
            if (foundName.equals(name)) {
                found = true;
                System.out.println("카테고리: " + transaction.getCategory()
                        +
                        "\n 지출비용: " + transaction.getCost() + "원");
            }
        }
        if (! found) {
            System.out.println("검색 결과가 없습니다");
        }
    }

}