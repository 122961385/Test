package com.sw.zg.IO流;

import java.io.*;

/**
 * 字符流是什么 字符流是可以直接读写字符的IO流 字符流读取字符, 就要先读取到字节数据,
 * 然后转为字符. 如果要写出字符, 需要把字符转为字节再写出.
 */
public class Test2 {

    /*
     * * BufferedReader的readLine()方法可以读取一行字符(不包含换行符号)
     * BufferedWriter的newLine()可以输出一个跨平台的换行符号"\r\n"
     */
    public static void demo6() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            // bw.write("\r\n"); //只支持windows系统
            bw.newLine(); // 跨平台的
        }
        br.close();
        bw.close();
    }

    /**
     * * BufferedReader的read()方法读取字符时会一次读取若干字符到缓冲区, 然后逐个返回给程序, 降低读取文件的次数, 提高效率
     * BufferedWriter的write()方法写出字符时会先写到缓冲区, 缓冲区写满时才会写到文件, 降低写文件的次数, 提高效率
     */
    private static void demo5() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt")); // 创建字符输入流对象,关联aaa.txt
        BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt")); // 创建字符输出流对象,关联bbb.txt

        int ch;
        while ((ch = br.read()) != -1) { // read一次,会先将缓冲区读满,从缓冲去中一个一个的返给临时变量ch
            bw.write(ch); // write一次,是将数据装到字符数组,装满后再一起写出去
        }

        br.close(); // 关流
        bw.close();
    }

    /*
     * * 字符流也可以拷贝文本文件, 但不推荐使用. 因为读取时会把字节转为字符, 写出时还要把字符转回字节. 程序需要读取一段文本,
     * 或者需要写出一段文本的时候可以使用字符流 读取的时候是按照字符的大小读取的,不会出现半个中文 写出的时候可以直接将字符串写出,不用转换为字节数组 *
     * 不可以拷贝非纯文本的文件 因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替,写出的时候会将字符转换成字节写出去
     * 如果是?,直接写出,这样写出之后的文件就乱了,看不了了
     */
    private static void demo4() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("aaa.txt"); // 创建字符输入流,关联aaa.txt
        FileWriter fw = new FileWriter("bbb.txt"); // 创建字符输出流,关联bbb.txt

        int len;
        char[] arr = new char[1024 * 8]; // 创建字符数组
        while ((len = fr.read(arr)) != -1) { // 将数据读到字符数组中
            fw.write(arr, 0, len); // 从字符数组将数据写到文件上
        }

        fr.close(); // 关流释放资源
        fw.close();
    }

    // 字符流的拷贝
    private static void demo3() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("conf/xxx.text");
        FileWriter fw = new FileWriter("b.txt"); // 会自动创建文件
        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }
        fr.close();
        fw.close();
    }

    // FileWriter类的write()方法可以自动把字符转为字节写出
    private static void demo2() throws IOException {
        FileWriter fw = new FileWriter("conf/xxx.text");
        fw.write("aawwa");
        fw.close();
    }

    // 先读取字节，在转成字符
    private static void demo1() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("conf/xxx.text"); // 创建输入流对象,关联aaa.txt
        int ch;
        while ((ch = fr.read()) != -1) { // 将读到的字符赋值给ch
            System.out.println((char) ch); // 将读到的字符强转后打印
        }
        fr.close();
    }
}
