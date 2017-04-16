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
public class Server7{
  public static void main(String[] args) throws IOException
  {
      new Send().start();
    ServerSocket ss = new ServerSocket(9999);
    //send stream
    OutputStream sendBack = null;
    boolean isSending = false;
    Socket sendSock = null;
    
    while(true){
      Socket s = ss.accept();//收到请求就产生一个socket
      System.out.println("收到请求");
      
      InputStream ins = s.getInputStream();
      int n = 0;
      byte[] r = new byte[1024];
      //等待接收数据
      while((n = ins.read(r))!=-1){
          String str = new String(r);
          System.out.println("收到数据"+str);
      }
      s.close();
      }
  }
}
class Send extends Thread{
    public void run(){
            try{
            ServerSocket ss = new ServerSocket(9998);
            //send stream
            OutputStream sendBack = null;
            boolean isSending = false;
            Socket sendSock = null;
            while(true){
                Socket s = ss.accept();//收到请求就产生一个socket
                System.out.println("发送收到请求");
                
                sendBack = s.getOutputStream();
                String str = "message send back";
                sendBack.write(str.getBytes());
                sendBack.flush();
                System.out.println("发送数据完成");
            }
        }catch (IOException e) {
        }
    }
}












