import java.util.*;

public class Main {

    public static void main(String[] args) {
        // CRUD crud = new CRUD();
        // Create create = new Create();

        ArrayList<HashMap<String, Object>> table = new ArrayList<>();

        while(true) {
            System.out.println("원하는 작업을 선택해주세요.");
            System.out.println("1. 글작성");
            System.out.println("2. 글목록");
            System.out.println("3. 종료");

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            scanner.nextLine();
            switch(input) {
                case 1: // create 부분
                    HashMap<String, Object> map = new HashMap<>();
                    System.out.println("제목을 입력하세요 ");
                    map.put("제목", scanner.nextLine());
                    System.out.println("내용을 입력하세요 ");
                    map.put("내용", scanner.nextLine());
                    table.add(map);

                    break;

                case 2:
                    System.out.println("글 목록을 출력합니다.");
                    for (int i = 0; i < table.size(); i++){
                        HashMap<String,Object> hashMap = table.get(i);
                        System.out.println(hashMap.get("제목") + " " + hashMap.get("내용"));
                    }

                    System.out.println("원하는 작업을 선택해주세요.");
                    System.out.println("1. 글수정");
                    System.out.println("2. 글삭제");
                    System.out.println("999. 돌아가기");

                    input = scanner.nextInt();
                    switch(input) {
                        case 1: // 수정
                            System.out.println("수정할 글 번호를 입력해주세요.");
                            input = scanner.nextInt();
                            scanner.nextLine();
                            HashMap<String, Object> update = new HashMap<>();
                            System.out.println("제목을 입력하세요 ");
                            update.put("제목", scanner.nextLine());
                            System.out.println("내용을 입력하세요 ");
                            update.put("내용", scanner.nextLine());
                            table.set(input,update);
                            break;

                        case 2: // 삭제
                            System.out.println("삭제할 글 번호를 입력해주세요.");
                            input = scanner.nextInt();
                            scanner.nextLine();
                            table.remove(input);
                            break;

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