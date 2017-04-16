//接收来自服务器的文件
//写入手机

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

public class Client5{
  public static void main(String[] args) {
    try {
        // Socket socket = new Socket("10.8.191.213",20000);
        Socket socket = new Socket("10.105.36.224",18888);
        // Socket socket = new Socket("127.0.0.1",8888);
        //works
        // File outf = new File("/storage/emulated/0/carTempRecv.264");
        File outf = new File("./carTempRecv.264");
        FileOutputStream fos = new FileOutputStream(outf);
        //ins: read data from client
        InputStream ins = socket.getInputStream();
        //read
        int size  = 0;
        byte[] recBuff = new byte[1024];
        //buffer
        byte[] totalBuff = new byte[5000000];
        int totalBuffIndex =0 ;
        while((size = ins.read(recBuff))!=-1){
          fos.write(recBuff,0,size);
          fos.flush();
          
          //byte[]
        //   System.arraycopy(recBuff,0,totalBuff,totalBuffIndex,size);
        //   totalBuffIndex = totalBuffIndex + size;
          
        }
        
        //write totalBuff
        fos.write(totalBuff,0,totalBuffIndex);
        fos.flush();
        
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
