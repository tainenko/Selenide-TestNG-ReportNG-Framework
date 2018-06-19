package com.selenium.CommonLib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;

public class CSVData implements Iterator<Object[]> {
    BufferedReader in;
    ArrayList<String> csvList = new ArrayList<String>();
    int rowNum = 0;     //行數
    int columnNum = 0;  //列數
    int curRowNo = 0;   //當前行數
    String columnName[];  //當前列數

    /**
     * 實現CSVDataProvider的功能：
     * 在TestNG中由@DataProvider(dataProvider=("name")修飾的方法
     *取csv文件數據時，調用此類構造方法，此方法會得到列名，並將當前行往下移一行，執行後將數據return到
     * TestNG自己的方法中，然後它們調用此類實現的hasNext()、next()方法。
     * 得到一行數據，然後返回給由Test(dataProvider="name")修飾的方法，如此反覆直到數據讀完為止。
     * @param fileName
     * @throws IOException
     */
    public CSVData(String fileName) throws IOException {
        File directory = new File(".");
        String path = ".src.resources.";
        String absolutePath = directory.getCanonicalPath() + path.replaceAll("\\.", Matcher.quoteReplacement("/")) + fileName;
        System.out.println(absolutePath);
        File csv = new File(absolutePath);
        in = new BufferedReader(new FileReader(csv));
        while (in.ready()) {
            csvList.add(in.readLine());
            this.rowNum++;
        }
        String[] str = csvList.get(0).split(",");
        this.columnNum = str.length;
        columnName = new String[columnNum];
        //获取列名
        for (int i = 0; i < columnNum; i++) {
            columnName[i] = str[i];
        }
        this.curRowNo++;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if (rowNum == 0 || curRowNo >= rowNum) {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * 讀取一行，獲取一組數據
     */
    @Override
    public Object[] next() {
        // TODO Auto-generated method stub
        Map<String, String> s = new TreeMap<String, String>();
        String csvCell[] = csvList.get(curRowNo).split(",");
        for (int i = 0; i < this.columnNum; i++) {
            s.put(columnName[i], csvCell[i]);
        }
        Object[] d = new Object[1];
        d[0] = s;
        this.curRowNo++;
        return d;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("remove unsupported");
    }
}