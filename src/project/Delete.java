package project;

import java.util.*;
public class Delete extends ArticlesFile {
    public void delete (List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);
        Check listCheck = new Check();

        while (true) {
            // 삭제할 글이 없으면 다시 선택으로
            if (listCheck.listCheck(tableList) == true) {
                return;
            }

            // 삭제할 글 번호 입력
            System.out.println("-------------------------");
            System.out.println("삭제할 글 번호를 입력해주세요.");
            System.out.println("-------------------------");

            list(tableList);


            // 숫자가 아닌 문자 입력시 예외 처리
            int input = 0;
            try {
                input = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("-------------------------------");
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                System.out.println("-------------------------------");
            }

            scanner.nextLine();

            //입력한 글 번호가 현재 작성된 글 번호 내에 존재하는지 확인
            // ex) 5개 글이 존재하면, 사용자가 1~5를 입력했는지 체크
            //존재한다면?(테이블의 사이즈보다 작거나 같을때) and 0이 아닐때(0번 글은 없음)
            if(input != 0 && input <= tableList.size()){

                //인덱스번호를 맞추기 위해 -1 하여 삭제
                tableList.remove(input - 1);

                System.out.println("------------------");
                System.out.println("삭제가 완료되었습니다.");
                System.out.println("------------------");
                break;
            }

            // 잘못된 번호 입력시 예외처리
            else {
                if (input != 0) {
                    System.out.println("-------------------------------");
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요!!.");
                    System.out.println("-------------------------------");
                    delete(tableList);
                    break;
                }
            }
        }
    }
}
