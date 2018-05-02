package org.cpm.zwl.util;

import java.util.Stack;

public class Cleaner {

  private Stack<AutoCloseable> stack;
  private Throwable leadException;
  private CleanupException outgoingCleanupException;

  private Cleaner() {
    this.stack = new Stack<>();
    this.leadException = null;
    this.outgoingCleanupException = null;
  }

  static public Cleaner newInstance() {
    return new Cleaner();
  }

  public <T extends AutoCloseable> T push(T obj) {
    return (T) stack.push(obj);
  }

  public void setLeadException(Throwable lead) {
    this.leadException = lead;
  }

  public void clear() {
    while (!stack.isEmpty()) {
      AutoCloseable auto = stack.pop();
      try {
        if (null != auto)
          auto.close();
      } catch (Exception e) {
        if (hasLeadException())
          leadException.addSuppressed(new CleanupException(e));
        else if (!hasOutgoingCleanupException())
          outgoingCleanupException = new CleanupException(e);
        else
          outgoingCleanupException.addSuppressed(new CleanupException(e));
      }
    }
    if (hasOutgoingCleanupException())
      throw outgoingCleanupException;
  }

  public boolean hasLeadException() {
    return (null != leadException) ? true : false;
  }

  public boolean hasOutgoingCleanupException() {
    return (null != outgoingCleanupException) ? true : false;
  }

}
