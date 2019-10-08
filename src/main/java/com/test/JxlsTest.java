    package main.java.com.test;

    import net.sf.jxls.transformer.XLSTransformer;
    import org.apache.poi.ss.usermodel.Workbook;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

public class JxlsTest {
    public static void main(String[] args) {
        String outPath = "E:/excel/output.xlsx";
        String templatePath = "E:/excel/template_demo.xlsx";

               Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", "标题");

        List<UserVo> userList = new ArrayList<UserVo>();
        userList.add(new UserVo("张三", 29));
        userList.add(new UserVo("李四", 23));
        params.put("users", userList);

        List<String> headers = new ArrayList<String>();
        headers.add("标题1");
        headers.add("标题2");
        headers.add("标题3");
        params.put("headers", headers);


        //模板
        try {
            InputStream is = new FileInputStream(templatePath);
            XLSTransformer xlsTransformer = new XLSTransformer();
            Workbook workbook =  xlsTransformer.transformXLS(is, params);
            OutputStream os = new BufferedOutputStream(new FileOutputStream(outPath));
            workbook.write(os);
            // 关闭和刷新管道，不然可能会出现表格数据不齐，打不开之类的问题
            is.close();
            os.flush();
            os.close();

            System.out.println("文件已导出：" + outPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
