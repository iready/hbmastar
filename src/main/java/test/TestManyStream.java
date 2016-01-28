package test;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class TestManyStream {

    public static void main(String[] args) throws Exception {
        //文件输出流1
        FileOutputStream fo1 = new FileOutputStream("E:\\file1.txt", true);

        //文件输出流2
        FileOutputStream fo2 = new FileOutputStream("E:\\file2.txt", true);

        //PrintStream1
        PrintStream ps1 = new PrintStream(fo1);

//PrintStream1  
        PrintStream ps2 = new PrintStream(fo2);
        //代理被调用时的处理类
        StreamHandler sHandler = new StreamHandler();
        sHandler.addStream(ps1);
        sHandler.addStream(ps2);
        sHandler.addStream(System.out);
        sHandler.validate();
        PrintStream streamProxy = StreamHandler.proxyFor(sHandler);

        //系统输出流重定向到代理
        System.setOut(streamProxy);
        System.setErr(streamProxy);
        System.out.println("All stream print this out!");
        try {
            throw new Exception("An Exception Occured!");
        } catch (Exception e) {

            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("12");
            TimeUnit.SECONDS.sleep(1);
        }
        streamProxy.close();
    }
}  