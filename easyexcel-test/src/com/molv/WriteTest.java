package com.molv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;

public class WriteTest {
	@Test
    public void  ExportTest() throws IOException {
        //指定文件输出位置
        OutputStream outputStream =new FileOutputStream("/Users/molv/opengit/myexcel.xlsx");
        ExcelWriter excelWriter =EasyExcelFactory.getWriter(outputStream);
        //将要输出的内容填充到Sheet里
        Sheet sheet =new Sheet(1,0,ExcelMode.class);
        //设置sheet表名
        sheet.setSheetName("my_three_excel");
        /**
         * 写数据到Write上下文中
         * 第一个参数：要写入的内容
         * 第二个参数：要写入的sheet目标
         */
        excelWriter.write(createModelList(),sheet);
        excelWriter.finish();
        outputStream.close();
    }
	
	
	private List<ExcelMode> createModelList (){
        List<ExcelMode> list = new ArrayList<>();
        for(int i=0; i<10000;i++){
            ExcelMode excelMode = new ExcelMode();
            excelMode.setUserName("哒哒"+i);
            excelMode.setAge("22");
            excelMode.setAddress("广西");
            list.add(excelMode);
        }
        return list;
    }
	
	public static void main(String[] args) {
		WriteTest nTest = new WriteTest();
		try {
			nTest.ExportTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
