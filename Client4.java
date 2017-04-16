//疯狂讲义上的java client
import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;

public class Client4{
  public static void main(String[] args) {
    //file input stream
    FileInputStream fis = null;
    try{
      File sendf = new File("/home/deonew/G/javaServer/tc10.264");
      fis = new FileInputStream(sendf);
    }catch(FileNotFoundException e){}
    if(fis == null){
      System.out.println("file error");
    }
    //socket output stream
    OutputStream os = null;
    try {
      //尝试一次连接
        // Socket socket = new Socket("10.8.191.213",20000);
        // Socket socket = new Socket("127.0.0.1",20000);
        Socket socket = new Socket("10.1.1.1",8888);
        //socket的输入流
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        //这里的out就是服务器的in
        os = socket.getOutputStream();
        byte[] buff = new byte[1024];
        int size = 0;
        int cnt = 1;//debug
        while((size = fis.read(buff)) != -1){//read file
          //write and flush
          os.write(buff,0,size);
          os.flush();
          try{
              Thread.sleep(10);
          }catch(InterruptedException e){}
          System.out.println(cnt++);
        //   if (cnt == 2) {
        //       System.out.println("one package sent");
        //       break;
        //   }
        }
        
        System.out.println(br.readLine());
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
