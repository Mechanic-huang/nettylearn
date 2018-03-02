package org.hgz.netty.proxy;

/**
 * @author huang_guozhong
 * @Description
 * @Copyright 2015 © anzhi.com
 * @Created 2018/1/10 16:52
 */
public class Station implements TicketService  {

  @Override
  public void sellTicket() {
    System.out.println("\n\t售票.....\n");
  }

  @Override
  public void inquire() {
    System.out.println("\n\t问询。。。。\n");
  }

  @Override
  public void withdraw() {
    System.out.println("\n\t退票......\n");
  }
}