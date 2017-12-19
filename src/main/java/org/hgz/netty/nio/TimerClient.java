package org.hgz.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/6 15:33
 */
public class TimerClient {

  public static void main(String[] args) {
    TimeClientHandler timeClient = new TimeClientHandler ("localhost", 8080);
    new Thread (timeClient, "TIME CLIENT").start ();
  }



  static class TimeClientHandler implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandler(String host, int port) {
      this.host = host == null ? "localhost" : host;
      this.port = port;
      try {
        selector = Selector.open ();
        socketChannel = SocketChannel.open ();
        socketChannel.configureBlocking (false);

      }catch (Exception e) {
        e.printStackTrace ();
        System.exit (1);
      }
    }

    public void run() {
      try {
        doConnect ();
      } catch (IOException e) {
        System.out.println (e);
        e.printStackTrace ();
        System.exit (1);
      }

      while(!stop) {
        try {
          selector.select (1000);
          Set<SelectionKey> selectionKeys = selector.selectedKeys ();
          Iterator<SelectionKey> iterator = selectionKeys.iterator ();
          SelectionKey key = null;
          while(iterator.hasNext ()) {
            key = iterator.next ();
            iterator.remove ();
            try {
              handleInput (key);
            } catch (Exception e) {
              e.printStackTrace ();
              if (key != null) {
                key.cancel ();
                if (key.channel ()!= null) {
                  key.channel ().close ();
                }
              }
            }
          }
        } catch (Exception e) {
          e.printStackTrace ();
          System.exit (1);
        }
      }


    }

    private void handleInput(SelectionKey key) throws IOException {
      if (key.isValid ()) {
        SocketChannel socketChannel = (SocketChannel) key.channel ();
        if (key.isConnectable ()) {
          if (socketChannel.finishConnect ()) {
            socketChannel.register (selector, SelectionKey.OP_READ);
            doWrite (socketChannel);
          } else {
            System.exit (1);
          }
        }

        if (key.isReadable ()) {
          ByteBuffer readBuffer = ByteBuffer.allocate (1024);
          int readBytes = socketChannel.read (readBuffer);
          if (readBytes > 0) {
            readBuffer.flip ();
            byte[] bytes = new byte[readBuffer.remaining ()];
            readBuffer.get (bytes);
            String body = new String (bytes, "UTF-8");
            System.out.println ("NOW IS " + body);
            this.stop = stop;
          } else {
            key.cancel ();
            socketChannel.close ();
          }
        }
      }
    }

    private void doConnect() throws IOException {
      if(socketChannel.connect (new InetSocketAddress (host, port))) {
        socketChannel.register (selector, SelectionKey.OP_READ);
        doWrite (socketChannel);
      } else {
        socketChannel.register (selector, SelectionKey.OP_CONNECT);
      }
    }

    private void doWrite(SocketChannel sc) throws IOException {
      byte[] req = "QUERY TIME ORDER".getBytes ();
      ByteBuffer writeBuffer = ByteBuffer.allocate (req.length);
      writeBuffer.put (req);
      writeBuffer.flip();
      socketChannel.write (writeBuffer);

      if (!writeBuffer.hasRemaining ()) {
        System.out.println ("Send order 2 server success");
      }
    }
  }
}