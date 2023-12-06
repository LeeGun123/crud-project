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
                    System.out.println("999. 메인화면으로 이동");
                    String data = scanner.next();
                    crud.create(data);
                    if(data.equals("999")){
                        System.out.println("메인화면으로 돌아갑니다.");
                        continue;
                    }else {
                        System.out.println("글이 작성 되었습니다");
                        break;
                    }




                case 2:
                    //글 목록을 출력한다.
                    //1 입력 시 글 수정 / 2 입력 시 글 삭제 / 999 입력 시 메인화면으로
                    //데이터 출력.
                    int articleNum = 1; //글 번호를 보여준다.
                    System.out.println("글 목록을 출력합니다.");
                    List<String> dataList = crud.read();
                    if(dataList.isEmpty()){
                        System.out.println("<<<<<글이 없습니다.>>>>>");
                        continue;
                    }
                    for(String d : dataList) {
                        System.out.println(articleNum+". "+d);
                        articleNum++;
                    }
                    System.out.println("1. 글 수정");
                    System.out.println("2. 글 삭제");
                    System.out.println("999. 메인화면으로 이동");
                    int select = scanner.nextInt();
                    
                    //글 수정
                    if(select == 1){
                        System.out.println("글을 수정합니다.");
                    } 
                    //글 삭제
                    else if(select == 2){
                        if(dataList.isEmpty()){
                            System.out.println("<<<<<글이 없습니다.>>>>>");
                            continue;
                        }
                        System.out.println("삭제할 글 번호를 입력해주세요.");
                        select = scanner.nextInt();
                        //입력한 글 번호가 현재 작성된 글 번호 내에 존재하는지 확인
                        if(select != 0 && select <= articleNum){
                            crud.delete(select-1);
                            System.out.println("<<<<<삭제가 완료되었습니다.>>>>>");
                            continue;
                        } else {
                            System.out.println("잘못된 글번호입니다.");
                            continue;
                        }
                    } 
                    //메인메뉴 이동
                    else if (select == 999) {
                        continue;
                    } else{
                        System.out.println("잘못된 입력입니다.");
                        
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