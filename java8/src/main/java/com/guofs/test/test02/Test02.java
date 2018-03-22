package com.guofs.test.test02;

import com.guofs.test.test02.fi.BufferedReaderProcessor;

import java.io.*;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/22 12:46
 */
public class Test02 {
    private final static String filePathName = "/test02/data.txt";

    public static void main(String[] args) throws IOException {
        String result = processFile((BufferedReader::readLine));
        System.out.println(result);
    }

    private static String processFile(BufferedReaderProcessor bp) throws IOException {
        InputStream in = Test02.class.getResourceAsStream(filePathName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            return bp.process(br);
        }
    }
}
