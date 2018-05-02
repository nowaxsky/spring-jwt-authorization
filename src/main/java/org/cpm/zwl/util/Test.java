//package org.cpm.zwl.util;
//
//import java.io.IOException;
//
//public class Test {
//
//  public static void failureException() throws Exception {
//
//    MyOutputStream mos = null;
//    MyConnection mc = null;
//    MyInputStream mis = null;
//    Cleaner cln = Cleaner.newInstance();
//    try {
//      mos = cln.push(new MyOutputStream());
//      mc = cln.push(new MyConnection());
//      mis = cln.push(new MyInputStream());
////      throw new IOException("Function failure");
//    } catch (Exception e) {
//      cln.setLeadException(e);
//      throw e;
//    } finally {
//      cln.clear();
//    }
//
//  }
//
//  public static void main(String[] args) {
//    try {
//      failureException();
//    } catch (Exception e) {
//      e.printStackTrace();
//      Throwable[] t = e.getSuppressed();
//      System.err.println("suppressed exception size = " + t.length);
//    }
//  }
//}
