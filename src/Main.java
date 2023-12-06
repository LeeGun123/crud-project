import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Map의 자료형을 담을수있는 리스트;
        List<Map<String, String>> tableList = new ArrayList<>();

        while(true) {

            // 사용자 화면 출력
            System.out.println("원하는 작업을 선택해주세요.");
            System.out.println("1. 글작성 \n2. 글목록 \n3. 종료");

            // 작업 선택
            int input = scanner.nextInt();
            scanner.nextLine();

            // 작업 선택 값에 따라 구분
            switch(input) {

                case 1: // 글 작성 (create)

                    // 제목과 내용을 담을 map 생성
                    Map<String, String> titleOrTextMap = new HashMap<>();

                    // 제목 입력 key값 "제목"
                    System.out.println("제목을 입력하세요 ");
                    titleOrTextMap.put("제목", scanner.nextLine());

                    // 내용 입력 key값 "내용"
                    System.out.println("내용을 입력하세요 ");
                    titleOrTextMap.put("내용", scanner.nextLine());

                    // List에 추가
                    tableList.add(titleOrTextMap);
                    break;


                case 2: // 글 목록 조회 (list)

                    System.out.println("글 목록을 출력합니다.");

                    // List가 가진 데이터 만큼 제목과 내용 출력
                    for (int i = 0; i < tableList.size(); i++){

                        // 글 목록 출력
                        // List를 순회하며 Map을 대입하여 키값을 넣어 제목과 내용을 출력
                        Map<String, String> hashMap = tableList.get(i);
                        System.out.println(hashMap.get("제목") + " " + hashMap.get("내용"));
                        System.out.println();
                    }

                    // 글 목록에서의 선택 기능 출력
                    System.out.println("원하는 작업을 선택해주세요.");
                    System.out.println("1. 글수정 \n2. 글삭제 \n999. 돌아가기");

                    // 선택 입력에 따라 구분
                    input = scanner.nextInt();
                    switch(input) {

                        case 1: // 수정

                            // 수정할 글 번호 입력
                            System.out.println("수정할 글 번호를 입력해주세요.");
                            input = scanner.nextInt();
                            scanner.nextLine();

                            // 제목과 내용을 가진 새로운 Map을 만든다.
                            Map<String, String> update = new HashMap<>();
                            System.out.println("제목을 입력하세요 ");
                            update.put("제목", scanner.nextLine());
                            System.out.println("내용을 입력하세요 ");
                            update.put("내용", scanner.nextLine());

                            // 기존 List에 덮어 넣는다.
                            tableList.set(input,update);
                            break;

                        case 2: // 삭제

                            // 삭제할 글 번호 입력
                            System.out.println("삭제할 글 번호를 입력해주세요.");
                            input = scanner.nextInt();
                            scanner.nextLine();

                            // 기존 리스트에서 입력 번호 제거
                            tableList.remove(input);
                            break;

                            // 999입력시 메인화면으로
                        case 999:
                            continue;
                    }
                    break;

                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}