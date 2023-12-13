package project;

import java.util.*;

public class Modify extends ArticlesFile {

    // 글 수정 메서드
    public void modify (List<Map<String, String>> tableList) {

        Scanner scanner = new Scanner(System.in);
        Check listCheck = new Check();

        while (true) {
            // 수정할 글이 없으면 다시 선택으로
            if (listCheck.listCheck(tableList) == true) {
                return;
            }

            // 수정할 글 번호 입력
            System.out.println("-------------------------");
            System.out.println("수정할 글 번호를 입력해주세요.");
            System.out.println("-------------------------");

            list(tableList);

            int input = 0;
            try {
                input = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("-------------------------------");
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                System.out.println("-------------------------------");
                modify(tableList);
            }

            scanner.nextLine();

            System.out.println();

            if (input != 0 && input <= tableList.size()) {
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
                System.out.println("다 작성하셨으면 save!를 쳐주세요!");
                StringBuilder content = new StringBuilder();
                String line;

                while (true) {
                    line = scanner.nextLine();
                    if (line.equalsIgnoreCase("save!")) {
                        update.put("내용", content.toString());
                        System.out.println("저장되었습니다.");
                        break;
                    }
                    content.append(line).append("\n"); // 개행문자도 받을 수 있게함
                }
                update.put("내용", content.toString());

                System.out.println();

                // 기존 List에 덮어 넣는다.
                tableList.set(input - 1, update);
                System.out.println("-------------");
                System.out.println("수정되었습니다.");
                System.out.println("-------------");
                break;
            }
            //
            else {
                if (input != 0) {
                    System.out.println("-------------------------------");
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    System.out.println("-------------------------------");
                    modify(tableList);
                }
            }
            break;
        }
    }
}
