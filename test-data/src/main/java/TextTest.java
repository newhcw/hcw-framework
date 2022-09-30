import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextTest {

    public static void main(String[] args) {


        StringBuffer resultString = new StringBuffer();

        List<String> getId_usrId = parseText();
        List<String> normalGetIds = parseGetIds();
        List<String> parseUserIds = parseUserIds();
        for (int i = 0; i < getId_usrId.size(); i++) {
            String getId_userId = getId_usrId.get(i);
            String[] getId_userIdArray = getId_userId.split("@@@");
            if (getId_userIdArray.length>3){
                String timestamp = getId_userIdArray[0];
                String userId = getId_userIdArray[1];
                String getId = getId_userIdArray[2];
                String txt = getId_userIdArray[3];
                if (parseUserIds.contains(userId)){
                    boolean contains = normalGetIds.contains(getId);
                    if (!contains){
                        //resultList.add(getId_userId);
                        //System.out.println(getId_userId);
                       // resultString.append(timestamp+","+userId+","+getId+"\r");
                        resultString.append(txt + "\r");
                    }
                }
            }

        }

        try {
            /* 写入Txt文件 */
            File writename = new File("C:\\Users\\user\\Desktop\\log\\errorGetId.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(String.valueOf(resultString)); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        }catch (Exception e){
            e.printStackTrace();
        }




    }


    public static List<String> parseText(){
        List<String> list = Arrays.asList("market-activity-provider.log",
                "market-activity-provider.2022-02-18.log",
                "market-activity-provider.2022-02-19.log",
                "market-activity-provider.2022-02-20.log",
                "market-activity-provider.2022-02-21.log",
                "market-activity-provider.2022-02-22.log",
                "market-activity-provider.2022-02-23.log"
        );

        List<String> result = new ArrayList<>();

        for (int i=0;i<list.size();i++){
            String pathname = "C:\\Users\\user\\Desktop\\log\\" + list.get(i); // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = null; // 建立一个输入流对象reader
            try {
                reader = new InputStreamReader(
                        new FileInputStream(filename));
                BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
                String line = "";
                line = br.readLine();
                while (line != null) {
                    line = br.readLine(); // 一次读入一行数据
                    if (line !=null){
                        int tt = line.indexOf("market/activity/recommend/receive/reward");
                        if (tt>0){
                            String substring = line.substring(tt, line.length());
//                        System.out.println(substring);
                            String timestamp = line.substring(0,23);
                            int getIdIndex = substring.indexOf("getId");
                            int userIdIndex = substring.indexOf("userId");
                            String getId = substring.substring(getIdIndex+6,userIdIndex);
//                            System.out.println("getId:" +getId);

                            String userId = substring.substring(userIdIndex+7,substring.length()-2);
//                            System.out.println("userId:" + userId);

                            String st = timestamp + "@@@"+userId+"@@@"+getId+"@@@"+line;
                            result.add(st);
                        }

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static List<String> parseGetIds(){

        List<String> result = new ArrayList<>();

        String pathname = "C:\\Users\\user\\Desktop\\log\\getid.txt" ; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = null; // 建立一个输入流对象reader
        try {
            reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if (line !=null){
                    System.out.println("getId:" + line);
                    result.add(line);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<String> parseUserIds(){

        List<String> result = new ArrayList<>();

        String pathname = "C:\\Users\\user\\Desktop\\log\\userid.txt" ; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = null; // 建立一个输入流对象reader
        try {
            reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if (line !=null){
                    System.out.println("useid:" + line);
                    result.add(line);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
