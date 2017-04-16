//接收来自服务器的文件

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//写入手机

public class TextClient1{
  public static void main(String[] args) {
    try {
        Socket socket = new Socket("10.105.39.47",20001);
        DataOutputStream os =  new DataOutputStream(socket.getOutputStream());
        os.writeUTF("from client");
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
