import java.util.*;

public class Main {
    static ArrayList<HashMap<String, Object>> table = new ArrayList<>(); // 글 저장/관리할 수 있게 분리

    public static void main(String[] args) {
        int postNumber = 1; // 글 번호 지정하려고 분리함
        boolean backToMenu = false; // 이전 메뉴로 돌아갈 수 있게..

        while (true) {
            displayMenu(); // 메뉴 출력 메서드 분리함
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    createPost(scanner, postNumber); // 글 작성 메서드 분리함
                    postNumber++; // 글 번호 증가
                    break;
                case 2:
                    viewPosts(scanner); // 글 목록 조회하기 만들어서 메서드 분리함
                    break;
                case 3:
                    backToMenu = true; // 메인 메뉴 못 돌아가게 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

            if (backToMenu) {
                break; // 메뉴 돌아가기
            }
        }
    }

    private static void displayMenu() {
        System.out.println("원하는 작업을 선택해 주세요.");
        System.out.println("1. 글 작성");
        System.out.println("2. 글 목록");
        System.out.println("3. 종료");
    }

    private static void createPost(Scanner scanner, int postNumber) { // 글 작성하기
        HashMap<String, Object> map = new HashMap<>();
        System.out.println("제목을 입력하세요 ");
        String title = scanner.nextLine();
        map.put("제목", title);

        System.out.println("내용을 입력하세요 ");
        System.out.println("저장하려면 `save!`을 입력한 후 Enter키를 입력하세요.");
        // 내용에 개행문자 추가하여 저장하고 싶어 저장키 생성함
        StringBuilder content = new StringBuilder();
        String line;

        while (true) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase("save!")) {
                map.put("내용", content.toString());
                map.put("글 번호", postNumber);
                table.add(map);
                System.out.println("저장되었습니다.");
                break;
            }
            content.append(line).append("\n"); // 개행문자도 받을 수 있게함
        }
    }

    private static void viewPosts(Scanner scanner) { // 글 번호와 제목 먼저 리스트로 볼 수 있음 수정, 삭제 기능 넣음
        System.out.println("글 목록을 출력합니다.");
        if (table.isEmpty()) {
            System.out.println("저장된 글이 없습니다.");
            return;
        }
        for (HashMap<String, Object> hashMap : table) {
            System.out.println(hashMap.get("글 번호") + " | " + hashMap.get("제목"));
        } // 게시판처럼 글번호와 제목만 먼저 노출되도록 만듦

        System.out.println("글 번호를 입력하시면 글 내용 확인이 가능합니다.");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("back!")) {
            return;
        }
        try {
            int inputPostNumber = Integer.parseInt(choice);
            boolean found = false;
            for (HashMap<String, Object> hashMap : table) {
                if (hashMap.get("글 번호").equals(inputPostNumber)) {
                    System.out.println("제목: " + hashMap.get("제목"));
                    System.out.println("내용:\n " + hashMap.get("내용"));
                    found = true; // 글 번호 누르면 안에 내용 확인 가능

                    System.out.println("원하는 작업을 선택하세요:");
                    System.out.println("1. 글 수정");
                    System.out.println("2. 글 삭제");
                    System.out.println("3. 이전 화면");

                    int actionChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (actionChoice) {
                        case 1: // 글 수정하기
                            System.out.println("제목을 입력하세요:");
                            String newTitle = scanner.nextLine();
                            System.out.println("내용을 입력하세요. (저장하려면 '!수정'을 입력한 후 Enter 키를 누르세요)");
                            StringBuilder newContentBuilder = new StringBuilder();
                            String save;
                            while (true) {
                                save = scanner.nextLine();
                                if (save.equals("!수정")) {
                                    break;
                                }
                                newContentBuilder.append(save).append("\n");
                            } // 수정시에도 개행문자 받을 수 있도록 만듦
                            String newContent = newContentBuilder.toString();

                            hashMap.put("제목", newTitle);
                            hashMap.put("내용", newContent);

                            System.out.println("글이 수정되었습니다.");
                            break;

                        case 2: // 글 삭제
                            table.remove(hashMap);
                            System.out.println("글이 삭제되었습니다.");
                            break;

                        case 3:
                            return;

                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("해당 글이 존재하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}