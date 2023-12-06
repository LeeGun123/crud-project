import java.util.*;

public class Create {

    // 글 작성 메서드
    public void writing (List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // 제목과 내용을 담을 map 생성
            Map<String, String> titleOrTextMap = new HashMap<>();

            // 제목 입력 key값 "제목"
            System.out.println("----------------");
            System.out.println("제목을 입력하세요.");
            System.out.println("----------------");
            titleOrTextMap.put("제목", scanner.nextLine());

            System.out.println();

            // 내용 입력 key값 "내용"
            System.out.println("----------------");
            System.out.println("내용을 입력하세요.");
            System.out.println("----------------");
            titleOrTextMap.put("내용", scanner.nextLine());

            System.out.println();

            // List에 추가
            tableList.add(titleOrTextMap);
            break;
        }
    }
}


