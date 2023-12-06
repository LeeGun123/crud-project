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

                // 999 입력시 메인화면으로
                case 999:
                    return;
            }
            continue;
        }
    }

    public int ui (List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("------------------");
            System.out.println("글 목록을 출력합니다.");
            System.out.println("------------------");

            System.out.println();

            // List가 가진 데이터 만큼 제목과 내용 출력
            for (int i = 0; i < tableList.size(); i++){

                // 글 목록 출력
                // List를 순회하며 Map을 대입하여 키값을 넣어 제목과 내용을 출력
                System.out.print((i + 1) + ". ");
                Map<String, String> hashMap = tableList.get(i);
                System.out.println(hashMap.get("제목") + " " + hashMap.get("내용"));
            }

            System.out.println();

            // 글 목록에서의 선택 기능 출력
            System.out.println("-----------------------");
            System.out.println("원하는 작업을 선택해주세요.");
            System.out.println("-----------------------");
            System.out.println("1. 글수정 \n2. 글삭제 \n999. 돌아가기");

            System.out.println();

            // 선택 입력에 따라 구분
            return scanner.nextInt();
        }
    }
}
