// package com.defonds.socket.begin;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.*;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client2 {
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
                  try {
                    //尝试一次连接
                      Socket socket = new Socket("192.168.0.120 ",40004);
                      socket.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }

          }

      }.start();
      // tv.setText(str);
    }
}
