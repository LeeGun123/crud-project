import java.util.ArrayList;
import java.util.List;

public class CRUD {


    // 데이터를 저장할 공간을 변수 database로 선언
    private List<String> database = new ArrayList<>();

    // Create
    public void create(String data) {
        database.add(data);
    }

    // Read List<String>으로 반환
    public List<String> read(){
        return database;
    }
    
    //삭제기능 추가
    //삭제할 글 번호를 String으로 받아 삭제 진행
    public void delete(String boardContent){
        if(database.contains(boardContent)){
            int boardIdx = database.indexOf(boardContent);
            database.remove(boardIdx);
        } else{
            System.out.println("존재하지 않는 글입니다.");
        }
    }


}