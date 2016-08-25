import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/8/23.
 */
public class testReadExcel {
    public void testReadExcel() {
        try {
            // 读取Excel
            Workbook wb = new HSSFWorkbook(new FileInputStream("d:\\2.xls"));

            // 获取sheet数目
            for (int t = 0; t < wb.getNumberOfSheets(); t++) {
                Sheet sheet = wb.getSheetAt(t);
                Row row = null;
                int lastRowNum = sheet.getLastRowNum();

                // 循环读取
                for (int i = 0; i <= lastRowNum; i++) {
                    row = sheet.getRow(i);
                    if (row != null) {
                        // 获取每一列的值
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            Cell cell = row.getCell(j);
                            String value = getCellValue(cell);
                            if (!value.equals("")) {
                                System.out.print(value + " | ");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    result = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    result = cell.getNumericCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                      result = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    result = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }


    public void testWriteExcel() {
        String excelPath = "d:/3.xls";

        Workbook workbook = null;
        try {
            // XSSFWorkbook used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
            workbook = new HSSFWorkbook();// XSSFWorkbook();//WorkbookFactory.create(inputStream);
        } catch (Exception e) {
            System.out.println("创建Excel失败: ");
            e.printStackTrace();
        }
        if (workbook != null) {
            Sheet sheet = workbook.createSheet("测试数据");
            Row row0 = sheet.createRow(0);
            for (int i = 0; i < 6; i++) {
                Cell cell = row0.createCell(i, Cell.CELL_TYPE_STRING);
                cell.setCellValue("列标题" + i );
                //sheet.autoSizeColumn(i);//自动调整宽度
            }
            for (int rowNum = 1; rowNum < 10; rowNum++) {
                Row row = sheet.createRow(rowNum);
                for (int i = 0; i < 6; i++) {
                    Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
                    cell.setCellValue("单元格" + String.valueOf(rowNum + 1)
                            + String.valueOf(i + 1));
                }
            }
            try {
                FileOutputStream outputStream = new FileOutputStream(excelPath);
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                System.out .println("写入Excel失败: ");
                e.printStackTrace();
            }
        }
    }
}
