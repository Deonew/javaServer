// 疯狂讲义上的java server
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.IOException;

public class Server3{
  public static void main(String[] args) throws IOException
  {
    ServerSocket ss = new ServerSocket(20000);
    while(true){
      Socket s = ss.accept();//收到请求就产生一个socket
      System.out.println("收到请求");
      InputStream is = s.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      System.out.println(br.readLine());
      // OutputStream os = s.getOutputStream();//具体到一个socket才能写
      // os.write("from server".getBytes("utf-8"));
      // os.close();
      s.close();
    }
  }
}
