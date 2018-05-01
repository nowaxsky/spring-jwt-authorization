package org.cpm.zwl.util;

import java.io.FileNotFoundException;

public class MyInputStream implements AutoCloseable {

  @Override
  public void close() throws Exception {
    throw new FileNotFoundException();
  }

}
