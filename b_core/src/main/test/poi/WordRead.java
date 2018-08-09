package poi;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WordRead {

    public static void main(String[] args) throws Exception {
        String BASE_PATH = "D:\\1\\";
        File file = new File(BASE_PATH + "1.doc");
        HWPFDocument doc = new HWPFDocument(new FileInputStream(file));

//通过 Doc对象直接获取Text
        StringBuilder sb = doc.getText();
        System.out.println(sb.toString());


    }

}
