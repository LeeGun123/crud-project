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



}
