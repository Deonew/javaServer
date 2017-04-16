import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server1 {


      /**
       * 服务器端
       *
       * @author Administrator
       *
       */
          // 程序入口
          public static void main(String args[]) {
              try {
                  // 建立一个ServletSocket ，监听对应的端口,用于监听客户端的连接请求
                  ServerSocket serverSocket = new ServerSocket(40004);
                  while (true) { // 循环不断接收客户端的请求
                      System.out.println("等待客户端请求....");
                      Socket socket = serverSocket.accept(); // 等待接收
                      System.out.println("收到请求，服务器建立连接...");
                      // 返回数据
                      OutputStream os = socket.getOutputStream();
                      String msg = "服务器已连接成功...";
                      os.write(msg.getBytes("utf-8"));
                      os.close();
                      socket.close();
                  }

              } catch (Exception e) {
                  e.printStackTrace();
              }
          }


}
