import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Map의 자료형을 담을수있는 리스트
        List<Map<String, String>> tableList = new ArrayList<>();


        while(true) {

            // 사용자 화면 출력
            System.out.println("-----------------------");
            System.out.println("원하는 작업을 선택해주세요.");
            System.out.println("-----------------------");
            System.out.println("1. 글작성 \n2. 글목록 \n3. 종료");
            System.out.println();

            // 작업 선택
            int input = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            // 작업 선택 값에 따라 구분
            switch(input) {

                case 1: // 글 작성 (create)

                    Create create = new Create();
                    create.writing(tableList);
                    break;

                case 2: // 글 목록 조회 (list)

                    // 글 목록이 있는지 확인
                    if (listCheck(tableList)) continue;

                    System.out.println("------------------");
                    System.out.println("글 목록을 출력합니다.");
                    System.out.println("------------------");

                    ArticlesFile articlesFile = new ArticlesFile();
                    articlesFile.listarticles(tableList);
                    break;

                case 3:

                    System.out.println("-------------------");
                    System.out.println("프로그램을 종료합니다.");
                    System.out.println("-------------------");
                    scanner.close();
                    return;

                default:
                    System.out.println("-------------------------------");
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    System.out.println("-------------------------------");
                    break;
            }
        }
    }

    public static boolean listCheck(List<Map<String, String>> tableList) {

        if (tableList.isEmpty()) {
            System.out.println("------------");
            System.out.println("글이 없습니다.");
            System.out.println("------------");

            // 글 목록이 없다면 다시 선택으로
            return true;
        }
        return false;
    }
}