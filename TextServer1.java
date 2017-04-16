// 发送数据给手机客户端

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TextServer1{
    public static void main(String[] args) throws IOException{
        TextServer1 ts = new TextServer1();
        ts.init();
  }
  public void init(){
      try {
          ServerSocket ss = new ServerSocket(20001);
              while(true){
                  Socket s = ss.accept();
                  System.out.println("收到请求");  
                  new MyHandle(s);
              }        
          } catch (IOException e) {
              e.printStackTrace();
        }
  }
  private class MyHandle implements Runnable {
    private Socket mSocket;
    public MyHandle(Socket s){
      mSocket = s;
      new Thread(this).start();
    }
    public void run(){
        //handle data here
        try{
            //
            DataInputStream input = new DataInputStream(mSocket.getInputStream());
            String s = input.readUTF();
            System.out.println("received text: "+s);
            
        }catch (Exception e) {
        }
        
    }
    }
}











