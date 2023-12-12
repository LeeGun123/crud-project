package project;

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
                default: // 잘못된 번호 입력시 예외처리
                    if (input != 0) {
                        System.out.println("-------------------------------");
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        System.out.println("-------------------------------");
                        break;
                    }
                    listarticles(tableList);
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

            // 글 목록 출력
            list(tableList);

            // 글 목록에서의 선택 기능 출력
            System.out.println("-----------------------");
            System.out.println("원하는 작업을 선택해주세요.");
            System.out.println("-----------------------");
            System.out.println("1. 글 수정 \n2. 글 삭제 \n3. 글 내용 조회 \n999. 돌아가기");

            System.out.println();

            int input = 0;
            try {
                input = scanner.nextInt();
            }
            catch (InputMismatchException e) { // 숫자가 아닌 문자 입력시 예외 처리
                System.out.println("-------------------------------");
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                System.out.println("-------------------------------");
            }

            // 선택 입력에 따라 구분
            return input;
        }
    }

    public void content(List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);
        Check listCheck = new Check();

        // 조회할 글이 없으면 다시 선택으로
        if (listCheck.listCheck(tableList) == true) {
            return;
        }

        System.out.println("------------------");
        System.out.println("조회할 글 번호를 선택하세요.");
        System.out.println("------------------");

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

        if(input != 0 && input <= tableList.size()) {
            Map<String, String> hashMap = tableList.get(input - 1);
            System.out.println("----");
            System.out.println(hashMap.get("내용"));
            System.out.println("----");
        }
        // 잘못된 번호 입력시 예외처리
        else {
            if (input != 0) {
                System.out.println("-------------------------------");
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                System.out.println("-------------------------------");
                content(tableList);
            }
        }
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
