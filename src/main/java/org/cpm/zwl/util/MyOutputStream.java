package org.cpm.zwl.util;

import java.io.IOException;

public class MyOutputStream implements AutoCloseable {

  @Override
  public void close() throws Exception {
    throw new IOException();
  }

}
