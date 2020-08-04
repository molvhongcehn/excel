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
        //ָ���ļ����λ��
        OutputStream outputStream =new FileOutputStream("/Users/molv/opengit/myexcel.xlsx");
        ExcelWriter excelWriter =EasyExcelFactory.getWriter(outputStream);
        //��Ҫ�����������䵽Sheet��
        Sheet sheet =new Sheet(1,0,ExcelMode.class);
        //����sheet����
        sheet.setSheetName("my_three_excel");
        /**
         * д���ݵ�Write��������
         * ��һ��������Ҫд�������
         * �ڶ���������Ҫд���sheetĿ��
         */
        excelWriter.write(createModelList(),sheet);
        excelWriter.finish();
        outputStream.close();
    }
	
	
	private List<ExcelMode> createModelList (){
        List<ExcelMode> list = new ArrayList<>();
        for(int i=0; i<10000;i++){
            ExcelMode excelMode = new ExcelMode();
            excelMode.setUserName("����"+i);
            excelMode.setAge("22");
            excelMode.setAddress("����");
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
