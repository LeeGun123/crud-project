import java.util.*;

public class ArticlesFile {

    // 글 목록 조회 메서드
    public void listarticles (List<Map<String, String>> tableList) {

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
            int input = scanner.nextInt();

            System.out.println();

            switch(input) {

                case 1: // 수정

                    Modify modify = new Modify();
                    modify.modify(tableList);
                    System.out.println();
                    break;

                case 2: // 삭제

                    // 먼저 글이 있는지 체크(비어있는지 확인)
                    if(tableList.isEmpty()){
                        System.out.println("------------");
                        System.out.println("글이 없습니다.");
                        System.out.println("------------");
                        // 글 목록이 없다면 다시 선택으로
                        break;
                    }

                    // 삭제할 글 번호 입력
                    System.out.println("-------------------------");
                    System.out.println("삭제할 글 번호를 입력해주세요.");
                    System.out.println("-------------------------");

                    input = scanner.nextInt();
                    scanner.nextLine();

                    //입력한 글 번호가 현재 작성된 글 번호 내에 존재하는지 확인
                    // ex) 5개 글이 존재하면, 사용자가 1~5를 입력했는지 체크
                    //존재한다면?(테이블의 사이즈보다 작거나 같을때) and 0이 아닐때(0번 글은 없음)
                    if(input != 0 && input <= tableList.size()){

                        //인덱스번호를 맞추기 위해 -1 하여 삭제
                        tableList.remove(input-1);

                        System.out.println("------------------");
                        System.out.println("삭제가 완료되었습니다.");
                        System.out.println("------------------");
                        System.out.println();
                        break;
                    }

                    //존재하지 않는다면?(사용자가 생뚱맞은 번호를 입력했다면?)
                    else {

                        System.out.println("----------------");
                        System.out.println("잘못된 글번호입니다.");
                        System.out.println("----------------");
                        break;
                    }

                // 999입력시 메인화면으로
                case 999:
                    return;
            }
            continue;
        }
    }
}
