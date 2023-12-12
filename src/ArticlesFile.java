import java.util.*;

public class ArticlesFile {

    // 글 목록 조회 메서드
    public void listarticles (List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // 목록 표시 및 사용자 입력 메서드
            int input = ui(tableList);

            switch(input) {

                case 1: // 수정

                    Modify modify = new Modify();
                    modify.modify(tableList);
                    System.out.println();
                    break;

                case 2: // 삭제

                    Delete delete = new Delete();
                    delete.delete(tableList);
                    System.out.println();
                    break;

                case 3: // 글 내용 조회

                    content(tableList);
                    System.out.println();
                    break;

                // 999 입력시 메인화면으로
                case 999:
                    return;
                default:
                    return;
            }
            continue;
        }
    }

    public int ui (List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // 글 목록 출력
            list(tableList);

            // 글 목록에서의 선택 기능 출력
            System.out.println("-----------------------");
            System.out.println("원하는 작업을 선택해주세요.");
            System.out.println("-----------------------");
            System.out.println("1. 글 수정 \n2. 글 삭제 \n3. 글 내용 조회 \n999. 돌아가기");

            System.out.println();

            // 선택 입력에 따라 구분
            return scanner.nextInt();
        }
    }

    public void content(List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------");
        System.out.println("조회할 글 번호를 선택하세요.");
        System.out.println("------------------");

        list(tableList);

        int input = scanner.nextInt();
        Map<String, String> hashMap = tableList.get(input - 1);
        System.out.println("----");
        System.out.println(hashMap.get("내용"));
        System.out.println("----");
    }

    public void list(List<Map<String, String>> tableList) {

        for (int i = 0; i < tableList.size(); i++){

            // 글 목록 출력
            // List를 순회하며 Map을 대입하여 키값을 넣어 제목과 내용을 출력
            System.out.print((i + 1) + ". ");
            Map<String, String> hashMap = tableList.get(i);
            System.out.println(hashMap.get("제목"));
        }
        System.out.println();
    }
}
