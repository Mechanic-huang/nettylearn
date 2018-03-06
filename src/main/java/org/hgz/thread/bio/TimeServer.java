package org.hgz.thread.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author huang_guozhong
 * @Description 阻塞IO的
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/8 11:59
 */
public class TimeServer {

  public static void main(String[] args) {
    int port = 8080;
    ServerSocket server = null;

    try{
      server = new ServerSocket (port);
      System.out.println ("The time server is start in port : " + port);
      Socket socket = null;
      while(true) {
        socket = server.accept ();
        new Thread ();
      }

    } catch (Exception e) {
      e.printStackTrace ();
    }
  }

  static class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
      this.socket = socket;
    }

    public void run() {
      BufferedReader in = null;
      PrintWriter out = null;

      try {
        in = new BufferedReader (new InputStreamReader (this.socket.getInputStream ()));
        out = new PrintWriter (this.socket.getOutputStream (), true);
        String currentTime = null;
        String body = null;
        while(true) {
          body = in.readLine ();
          if (body == null) {
            break;
          }
          System.out.println ("The time server receive order: " + body);
          currentTime = "QUERY TIME ORDER".equalsIgnoreCase (body)? null:null;
        }
      }catch (Exception e) {
        e.printStackTrace ();
      }
    }
  }


}