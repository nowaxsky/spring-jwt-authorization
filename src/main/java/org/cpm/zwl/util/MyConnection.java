package org.cpm.zwl.util;

import java.sql.SQLException;

public class MyConnection implements AutoCloseable {

  @Override
  public void close() throws Exception {
    throw new SQLException();
  }

}
