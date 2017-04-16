// 发送数据给手机客户端

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Server1{
  public static void main(String[] args) throws IOException{
      FileInputStream fis = null;
      try{
        File sendf = new File("./carTemp.aac");
        fis = new FileInputStream(sendf);
      }catch(FileNotFoundException e){}
      if(fis == null){
        System.out.println("file error");
      }
      
    //   int n = 900/1000;
    //   System.out.println(n);
    //   System.out.println(0xff);
      
      //socket output stream
      OutputStream os = null;
      try {
          System.out.println("开始监听");
        ServerSocket ss = new ServerSocket(18888);
        while(true){
          Socket s = ss.accept();
          System.out.println("收到请求");

          os = s.getOutputStream();
          byte[] buff = new byte[1024];
          int size = 0;
          int cnt = 1;//debug
          while((size = fis.read(buff)) != -1){//read file
              System.out.println("send one");
            //write and flush
            os.write(buff,0,size);
            os.flush();
            try{
              Thread.sleep(1);
            }catch(InterruptedException e){}
            System.out.println(cnt++);
          }
          s.close();
        }
        } catch (IOException e) {
          e.printStackTrace();
        }
  }
}
