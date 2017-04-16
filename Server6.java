//转发接收到的数据到另一个客户端

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
public class Server6{
  public static void main(String[] args) throws IOException
  {
    ServerSocket ss = new ServerSocket(20000);
    
    //send stream
    OutputStream sendBack = null;
    boolean isSending = false;
    Socket sendSock = null;
    
    while(true){
      Socket s = ss.accept();//收到请求就产生一个socket
      System.out.println("收到请求");

      //works
      File outf = new File("./rec.264");
      FileOutputStream fos = new FileOutputStream(outf);
      //ins: read data from client
      InputStream ins = s.getInputStream();
      sendBack = s.getOutputStream();
      //read
      int size  = 0;
      byte[] recBuff = new byte[1024];
      while((size = ins.read(recBuff))!=-1){
        fos.write(recBuff,0,size);
        fos.flush();
        
        // //转发
        // //10.105.38.208
        // if (sendSock == null) {
        //   try{
        //     Socket sendSock = new Socket("127.0.0.1",20000);
        //   }catch(IOException e){}
        // }
        // // if () {
        // // }
        // if (isSending) {
        //   sendBack.write(recBuff,0,size);
        //   sendBack.flush();
        // }
        
      }
      sendSock.close();
      

      System.out.println("发送成功");

      s.close();
    }
  }
}
