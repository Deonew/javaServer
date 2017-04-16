// package com.defonds.socket.begin;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.*;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client1 {
    // public static final String IP_ADDR = "10.202.0.204";//服务器地址
    public static final String IP_ADDR = "192.168.0.105";//服务器地址
    public static final int PORT = 40004;//服务器端口号

    public static void main(String[] args) {
      // Socket socket = new Socket("192.168.0.105",40004);
      new Thread(){
          //建一个线程防止阻塞UI线程
          public void run(){
              super.run();
              // System.out.println("nihao");
              while (true){
                  try {
                      // Socket socket = new Socket("192.168.0.120",40004);
                      Socket socket = new Socket("localhost",40004);
                      //建立连接,因为genymotion的模拟器的本地ip不同于一般的模拟器，所以ip地址要用这个
                      sleep(1000);
                      // 获取服务器返回的数据
                      BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                      // System.out.println("服务器数据：" + (str = br.readLine()));
                      // os.close();
                      br.close();
                      socket.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }

      }.start();
      // tv.setText(str);
    }
}
