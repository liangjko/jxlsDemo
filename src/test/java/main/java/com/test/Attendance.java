package main.java.com.test;


import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jxls.command.EachCommand;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attendance {
    public static void main(String[] args) {
        String outPath = "E://4.xlsx";
        String templatePath = "E://template.xlsx";

        Map<String, Object> params = new HashMap<String, Object>();


        List<String> headers = new ArrayList<String>();
        headers.add("项目编号");
        headers.add("项目名称");
        headers.add("人员编号");
        headers.add("姓名");
        headers.add("年月");
        params.put("headers", headers);

        List<StaffVo> staffList = new ArrayList<StaffVo>();
        staffList.add(new StaffVo("IDS19007","科勒MES系统软件开发项目","119007","陈速俊"));
        staffList.add(new StaffVo("IDS19007","科勒MES系统软件开发项目","119088","乔莉"));
        params.put("projects", staffList);

        List<Object> dateList = new ArrayList<Object>();
        for (int i=1;i<31;i++){
            dateList.add(i+"号");
        }
        dateList.add("本月出勤汇总天数");
        params.put("dates",dateList);

        //模板
        try {
            InputStream is = new FileInputStream(templatePath);
            XLSTransformer xlsTransformer = new XLSTransformer();
            Workbook workbook =  xlsTransformer.transformXLS(is, params);
            Sheet sheet = workbook.getSheetAt(0);
            sheet.addMergedRegion(new CellRangeAddress(10,11,0,0));
            //添加样式





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
