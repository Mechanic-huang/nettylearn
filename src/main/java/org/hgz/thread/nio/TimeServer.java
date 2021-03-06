package org.hgz.thread.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2017/9/6 11:08
 */
public class TimeServer {

  public static void main(String[] args) throws IOException {
    int port = 8080;
    MultiplexerTimeServer timeServer = new MultiplexerTimeServer (port);
    new Thread (timeServer, "NIO-TIME-SERVER").start ();
  }

  static class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;


    public MultiplexerTimeServer(int port) {
      try {
        selector = Selector.open ();
        serverSocketChannel = ServerSocketChannel.open ();
        serverSocketChannel.configureBlocking (false);
        serverSocketChannel.socket ().bind (new InetSocketAddress (port), 1024);
        serverSocketChannel.register (selector, SelectionKey.OP_ACCEPT);
        System.out.println ("The TimeServer Start in port " + port);
      } catch (Exception e) {
        e.printStackTrace ();
        System.exit (1);
      }
    }

    public void run() {
      while (!stop) {
        try {
          selector.select (1000);
          Set<SelectionKey> selectionKeys = selector.selectedKeys ();
          Iterator<SelectionKey> iterator = selectionKeys.iterator ();
          SelectionKey key = null;
          while (iterator.hasNext ()) {
            key = iterator.next ();
            iterator.remove ();
            try {
              handleInput (key);
            } catch (Exception e) {
              System.out.println (e);
              e.printStackTrace ();
              if (key != null) {
                key.cancel ();
                if (key.channel () != null) {
                  key.channel ().close ();
                }
              }
            }
          }
        } catch (Exception e) {
          e.printStackTrace ();
        }
      }
    }

    private void handleInput(SelectionKey key) throws IOException {
      if (key.isAcceptable ()) {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel ();
        SocketChannel socketChannel = ssc.accept ();
        socketChannel.configureBlocking (false);
        socketChannel.register (selector, SelectionKey.OP_READ);
      }

      if (key.isReadable ()) {
        SocketChannel socketChannel = (SocketChannel) key.channel ();
        ByteBuffer readBuffer = ByteBuffer.allocate (1024);
        int readBytes = socketChannel.read (readBuffer);
        if (readBytes > 0) {
          readBuffer.flip ();
          byte[] bytes = new byte[readBuffer.remaining ()];
          readBuffer.get (bytes);
          String body = new String (bytes, "UTF-8");
          System.out.println ("The TimeServer receive order: " + body);
          String currentTime =
              "QUERY TIME ORDER".equalsIgnoreCase (body) ? new Date (System.currentTimeMillis ())
                  .toString () : "DAD REQUEST";
          doWirte (socketChannel, currentTime);
        } else if (readBytes < 0) {
          key.cancel ();
          socketChannel.close ();
        }
      }
    }

    private void doWirte(SocketChannel channel, String response) throws IOException {
      if (response != null && response.trim ().length () > 0) {
        byte[] bytes = response.getBytes ();
        ByteBuffer writeBuffer = ByteBuffer.allocate (bytes.length);
        writeBuffer.put (bytes);
        writeBuffer.flip ();
        channel.write (writeBuffer);
      }
    }
  }




}