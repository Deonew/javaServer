//疯狂讲义上的java client
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client3{
  public static void main(String[] args) {
    try {
      //尝试一次连接
        Socket socket = new Socket("10.8.191.213",20000);
        
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
