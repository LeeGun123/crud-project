package project;

import java.util.List;
import java.util.Map;

public class Check {
    public static boolean listCheck(List<Map<String, String>> tableList) {
        // 작성된 글이 있는지 확인

        if (tableList.isEmpty()) {
            System.out.println("------------");
            System.out.println("작성된 글이 없습니다.\n");
            System.out.println("돌아가서 글을 작성해주세요!");
            System.out.println("------------");

            // 글 목록이 없다면 다시 선택으로
            return true;
        }
        return false;
    }
}