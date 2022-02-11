package com.hcw.framework;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MongoTools {

    public static void main(String[] args) throws Exception {
        String pathname1 = "D:\\workspace\\hcw-framework\\ExcelExportMongo\\src\\main\\resources\\fund-prod.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        String sql = getMongoSql(pathname1,0,15745);
        String pathname2 = "D:\\workspace\\hcw-framework\\ExcelExportMongo\\src\\main\\resources\\fundzh-prod.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        sql = sql.concat(getMongoSql(pathname2,1,15745));
        writeTxt(sql,"fund.sql");

//        String pathname3 = "D:\\workspace\\hcw-framework\\ExcelExportMongo\\src\\main\\resources\\deleteFund.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
//        deleteMongoSql(pathname1,0,40578);
    }

    public  static String getMongoSql(String path,int type,int userId) throws Exception{
        File filename = new File(path); // 要读取以上路径的input。txt文件

        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        //line = br.readLine();
        List<String> funds = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            //line = br.readLine(); // 一次读入一行数据
            if (StringUtils.trimWhitespace(line)!=null) {
                funds.add(line);
            }else {
                System.out.println("line:"+line);
            }
        }
        StringBuffer sb = new StringBuffer();
        String content1 ="\"content\" : \"长期持有vs择时买卖<br/>" +
                "投资想要获取更好的收益，两种方式，一是长期持有优质基金或者个股，通过时间来沉淀价值。二是择时，低买高卖，获取比较好的差价收益。不过，择时是比较困难的，并没有完全准确的方法，只能说大概率的确定相对合适的位置。<br/>" +
                "风险揭示：理财有风险，投资需谨慎\",";

        String content2 ="\"content\" : \"发行规模vs市场情绪<br/>" +
                "基金发行规模和市场密切相关，历来都是“好发不好做，好做不好发”。发行规模和数量的降低，也意味着投资者情绪低迷。从行为金融学的角度来说，这时候就是反向操作比较好的时机了。越是大多数人低迷的时候，可能蕴含着更多布局投资的机会，剩下的就交给时间了。<br/>" +
                "风险揭示：理财有风险，投资需谨慎 风险揭示：理财有风险，投资需谨慎\",";

        String content3 ="\"content\" : \"定投VS追涨杀跌<br/>" +
                "跌了就卖，涨了就追，短期波动对普通人来说很难把握，但一旦拉长投资期限，通过定投来提升投资获胜的概率就变得容易很多，因此定投比较适合长期执行，对普通老百姓来讲，有利于树立正确的理财观，更容易达到“积少成多”的目的。<br/>" +
                "风险揭示：理财有风险，投资需谨慎\",";

        List<String> contents = new ArrayList<>();
        contents.add(content1);
        contents.add(content2);
        contents.add(content3);



        for (int i = 0; i <  funds.size(); i++) {
            for (int j = 0; j < contents.size(); j++) {

                Long _id = 2021120000001l+type*1000000+j*100000;

                sb.append("db.comment.insert({");
                sb.append("\"_id\" : NumberLong(").append((_id+i)).append("),");
                sb.append("\"_class\" : \"com.sinolink.ycomment.entity.Comment\",");
                sb.append(" \"target\" : {\"_id\" : \"").append(funds.get(i)).append("\",\"type\" : \"FMALL00").append(type).append("\"},");
                sb.append("\"userId\" : NumberLong("+userId+"),");
                sb.append(contents.get(j));
                sb.append("\"createTime\" : NumberLong(1796518841000),");
                sb.append("\"updateTime\" : NumberLong(1796518841000),");
                sb.append(" \"status\" : NumberInt(1),");
                sb.append("\"auditMode\" : NumberInt(1),");
                sb.append("\"commentedNum\" : NumberLong(0),");
                sb.append("\"praiseNum\" : NumberLong(0),");
                sb.append("\"bizType\" : \"FMALL00").append(type).append("\"});\n");
            }
        }

       return sb.toString();
    }



//    public  static String deleteMongoSql(String path,int type,int userId) throws Exception{
//        File filename = new File(path); // 要读取以上路径的input。txt文件
//
//        InputStreamReader reader = new InputStreamReader(
//                new FileInputStream(filename)); // 建立一个输入流对象reader
//        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
//        String line = "";
//        line = br.readLine();
//        List<String> funds = new ArrayList<>();
//        while (line != null) {
//            line = br.readLine(); // 一次读入一行数据
//            if (StringUtils.trimWhitespace(line)!=null) {
//                funds.add(line);
//            }
//        }
//        StringBuffer sb = new StringBuffer();
//        String content1 ="\"content\" : \"长期持有vs择时买卖<br/>" +
//                "投资想要获取更好的收益，两种方式，一是长期持有优质基金或者个股，通过时间来沉淀价值。二是择时，低买高卖，获取比较好的差价收益。不过，择时是比较困难的，并没有完全准确的方法，只能说大概率的确定相对合适的位置。<br/>" +
//                "风险揭示：理财有风险，投资需谨慎\",";
//
//        String content2 ="\"content\" : \"发行规模vs市场情绪<br/>" +
//                "基金发行规模和市场密切相关，历来都是“好发不好做，好做不好发”。发行规模和数量的降低，也意味着投资者情绪低迷。从行为金融学的角度来说，这时候就是反向操作比较好的时机了。越是大多数人低迷的时候，可能蕴含着更多布局投资的机会，剩下的就交给时间了。<br/>" +
//                "风险揭示：理财有风险，投资需谨慎 风险揭示：理财有风险，投资需谨慎\",";
//
//        String content3 ="\"content\" : \"定投VS追涨杀跌<br/>" +
//                "跌了就卖，涨了就追，短期波动对普通人来说很难把握，但一旦拉长投资期限，通过定投来提升投资获胜的概率就变得容易很多，因此定投比较适合长期执行，对普通老百姓来讲，有利于树立正确的理财观，更容易达到“积少成多”的目的。<br/>" +
//                "风险揭示：理财有风险，投资需谨慎\",";
//
//        List<String> contents = new ArrayList<>();
//        contents.add(content1);
//        contents.add(content2);
//        contents.add(content3);
//
//
//
//        for (int i = 0; i <  funds.size(); i++) {
//            for (int j = 0; j < contents.size(); j++) {
//
//                Long _id = 2021120000001l+type*1000000+j*100000;
//
//                sb.append("db.comment.delete({");
//                sb.append("\"_id\" : NumberLong(").append((_id+i)).append(")}");
//            }
//        }
//
//        return sb.toString();
//    }


    public  static void writeTxt(String sql,String filename) throws Exception{
        File writename = new File("D:\\workspace\\hcw-framework\\ExcelExportMongo\\src\\main\\resources\\"+filename); // 相对路径，如果没有则要建立一个新的output。txt文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        out.write(sql); // \r\n即为换行
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
        System.out.println("生成完成！！！！！");
    }
}
