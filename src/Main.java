import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CRUD crud = new CRUD();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("원하는 작업을 선택해주세요.");
            System.out.println("1. 글작성");
            System.out.println("2. 글목록");
            System.out.println("3. 종료");

            int input = scanner.nextInt();

            switch(input) {
                //1번 입력시 값을 data 변수에 저장하고 crud클래스 create메소드에 전달되어 ArrayList에 추가함
                case 1:
                    System.out.println("작성할 글을 입력해주세요.");
                    String data = scanner.next();
                    crud.create(data);
                    break;

                case 2:
                    //데이터
                    System.out.println("글 목록을 출력합니다.");
                    List<String> dataList = crud.read();
                    for(String d : dataList) {
                        System.out.println(d);
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
