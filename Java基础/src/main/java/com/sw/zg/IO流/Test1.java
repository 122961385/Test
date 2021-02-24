package com.sw.zg.IO流;

import java.io.*;

/**
 * 字节流
 */
public class Test1 {

    public static void main(String[] args) {
        demo1();
    }

    //字节流读取中文的问题  字节流在读中文的时候有可能会读到半个中文,造成乱码
    //字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组  写出回车换行 write("\r\n".getBytes());
    public static void demo7() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("zzz.txt");
        fos.write("我读书少,你不要骗我".getBytes());
        fos.write("\r\n".getBytes());
        fos.close();
    }

    //定义小数组如果是8192个字节大小和Buffered比较的话 定义小数组会略胜一筹,因为读和写操作的是同一个数组 而Buffered操作的是两个数组
    private static void demo6() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("E:\\4、MySQL性能管理及架构设计.zip");	    //创建文件输入流对象,
        BufferedInputStream bis = new BufferedInputStream(fis);			//创建缓冲区对fis装饰
        FileOutputStream fos = new FileOutputStream("D:\\WINDOWSA.GHO");		//创建输出流对象,
        BufferedOutputStream bos = new BufferedOutputStream(fos);		//创建缓冲区对fos装饰
        int b;
        while((b = bis.read()) != -1) {
            System.out.println(b);
            bos.write(b);
        }
        bis.close();						//只关装饰后的对象即可
        bos.close();
    }

    //第三种拷贝   字节流一次读写一个数组的速度明显比一次读写一个字节的速度快很多，这是加入了数组这样的缓冲区效果，java本身在设计的时候，
    private static void demo5() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("conf/xxx.text");
        FileOutputStream fos = new FileOutputStream("copy.text");
        //byte[] arr = new byte[2];					//根据文件大小做一个字节数组，一般字节数组不定义2，一般定义1024*8
        byte[] arr = new byte[8];
        int len;
        while((len=fis.read(arr))!=-1){
            System.out.println(len);
            fos.write(arr,0,len);
//			fos.write(arr);
        }
        fis.close();
        fos.close();
    }

    //第二种拷贝,不推荐使用,因为有可能会导致内存溢出
    private static void demo4() throws FileNotFoundException, IOException {
        //担心内存溢出
        FileInputStream fis = new FileInputStream("conf/xxx.text");
        FileOutputStream fos = new FileOutputStream("copy.text");
        byte[] arr = new byte[fis.available()];					//根据文件大小做一个字节数组
        fis.read(arr);											//将文件上的所有字节读取到数组中
        fos.write(arr);											//将数组中的所有字节一次写到了文件上
        fis.close();
        fos.close();
    }

    //拷贝文件1
    private static void demo3() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("conf/xxx.text");	//创建输入流对象,关联致青春.mp3
        FileOutputStream fos = new FileOutputStream("pp.text");//创建输出流对象,关联copy.mp3
        int b;
        while((b = fis.read()) != -1) {
            System.out.println(b);//在不断的读取每一个字节
            fos.write(b);//将每一个字节写出
        }

        fis.close();
        fos.close();
    }

    //写入字节
    private static void demo2() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("conf/xxx.text",true);	//如果没有bbb.txt,会创建出一个
        //fos.write(97);						//虽然写出的是一个int数,但是在写出的时候会将前面的24个0去掉,所以写出的一个byte
        fos.write(98);
        fos.write(99);
        fos.close();
    }

    //读取字节
    private static void demo1() {
        try {
            FileInputStream fileInputStream=new FileInputStream("conf/xxx.text");
            int b;													//定义变量,记录每次读到的字节
//			System.out.println(fileInputStream.read()+"---"+fileInputStream.read());
            while((b = fileInputStream.read()) != -1) {							//将每次读到的字节赋值给b并判断是否是-1
                System.out.println(b);								//打印每一个字节
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
