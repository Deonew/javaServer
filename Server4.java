// 接收来自客户端的文件

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
public class Server4{
  public static void main(String[] args) throws IOException
  {
    ServerSocket ss = new ServerSocket(8888);
    while(true){
      Socket s = ss.accept();//收到请求就产生一个socket
      System.out.println("收到请求");

      // OutputStream os = s.getOutputStream();//具体到一个socket才能写
      // PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
      // pw.write("hello");
      // pw.flush();

      //works
      File outf = new File("./rec.264");
      FileOutputStream fos = new FileOutputStream(outf);
      //ins: read data from client
      InputStream ins = s.getInputStream();
      //read
      int size  = 0;
      byte[] recBuff = new byte[1024];
      while((size = ins.read(recBuff))!=-1){
        fos.write(recBuff,0,size);
        fos.flush();
      }
      

      System.out.println("发送成功");

      s.close();
    }
  }
}
