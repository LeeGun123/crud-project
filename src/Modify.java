import java.util.*;

public class Modify {

    // 글 수정 메서드
    public void modify (List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // 수정할 글 번호 입력
            System.out.println("-------------------------");
            System.out.println("수정할 글 번호를 입력해주세요.");
            System.out.println("-------------------------");

            int input = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            // 제목과 내용을 가진 새로운 Map을 만든다.
            Map<String, String> update = new HashMap<>();

            System.out.println("---------------");
            System.out.println("제목을 입력하세요 ");
            System.out.println("---------------");
            update.put("제목", scanner.nextLine());

            System.out.println();

            System.out.println("---------------");
            System.out.println("내용을 입력하세요 ");
            System.out.println("---------------");
            update.put("내용", scanner.nextLine());

            System.out.println();

            // 기존 List에 덮어 넣는다.
            tableList.set(input - 1, update);
            System.out.println("-------------");
            System.out.println("수정되었습니다.");
            System.out.println("-------------");
            break;
        }
    }
}
