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

                            //먼저 글이 있는지 체크(비어있는지 확인)
                            if(table.isEmpty()){
                                System.out.println("<<<<<글이 없습니다.>>>>>");
                                continue;
                            } 
                            System.out.println("삭제할 글 번호를 입력해주세요.");
                            input = scanner.nextInt();
                            scanner.nextLine();

                            //입력한 글 번호가 현재 작성된 글 번호 내에 존재하는지 확인
                            // ex) 5개 글이 존재하면, 사용자가 1~5를 입력했는지 체크
                            //존재한다면?(테이블의 사이즈보다 작거나 같을때) and 0이 아닐때(0번 글은 없음)
                            if(input != 0 && input <= table.size()){
                                //인덱스번호를 맞추기 위해 -1 하여 삭제
                                table.remove(input-1);
                                System.out.println("<<<<<삭제가 완료되었습니다.>>>>>");
                                continue;
                            }
                            //존재하지 않는다면?(사용자가 생뚱맞은 번호를 입력했다면?)
                            else {
                                System.out.println("잘못된 글번호입니다.");
                                continue;
                            }

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