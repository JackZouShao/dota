package com.alex.common.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @version 1.0.0
 * @className JavaStreamTest.java
 * @author: yz
 * @date: 2021/8/2 23:37
 */
@RunWith(JUnit4.class)
public class JavaStreamTest {

    public static void main(String[] args) {

    }

    @Test
    public void testBuffer() throws Exception {
        File file;
        // 缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("/Users" + File.separator + "yz/jbr_err_pid15465.log"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(("/Users" + File.separator + "yz/jbr_err_pid143771.log")));
        byte[] buffers = new byte[2048];

        int i = 0;
        while ((i = bufferedInputStream.read(buffers)) != -1){
            System.out.println(new String(buffers,0, i, StandardCharsets.UTF_8));
            bufferedOutputStream.write(buffers, 0, i);
        }
        bufferedInputStream.close();

        // usage of StringReader
        StringReader stringReader = new StringReader("123");
        int c = 0;
        while((c = stringReader.read()) != -1){
            char a = (char)c;
            System.out.println(a);
            bufferedOutputStream.write(a);
        }

        bufferedOutputStream.close();
    }

    @Test
    public void testStreamBuffer() {

        try (
            //  字节 --> 字符
            InputStream in = new FileInputStream("/Users" + File.separator + "yz/jbr_err_pid15465.log");
            InputStreamReader inputStreamReader = new InputStreamReader(in)) {

            char[] chars = new char[1024];
            int index = 0;
            while((index = inputStreamReader.read(chars)) != -1){
                for (int i = 0; i < index; i++) {
                    System.out.print(chars[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // test OutputStreamBuffer
        OutputStream out;
        // 字符 --> 字节流
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(("/Users" + File.separator + "yz/jbr_err_pid143771.log")))){
            outputStreamWriter.write("1232323232");
            StringBuffer s = new StringBuffer();
        }
         catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testPrinter(){
        try (BufferedReader br = new BufferedReader(new FileReader("/Users" + File.separator + "yz/jbr_err_pid15465.log"))) {
            OutputStream out;
            PrintWriter writer = new PrintWriter("/Users" + File.separator + "yz/x.log");
            String line = "";
            while ((line = br.readLine()) != null){
                writer.println(line);
            }
            writer.flush();
            writer.close();
        }catch (Exception e){

        }
    }

    @Test
    public void testProperties(){
        Properties properties = new Properties();
        properties.setProperty("1", "2");
        System.out.println(properties.getProperty("1"));
    }














}
