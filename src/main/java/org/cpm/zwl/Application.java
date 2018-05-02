package org.cpm.zwl;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @author CPM
 *
 */
@SpringBootApplication
@ServletComponentScan
public class Application {

  @PostConstruct
  void init() {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
  }

  public static void main(String[] args) throws Exception {
    SpringApplication application = new SpringApplication(Application.class);
    application.run(args);
  }
}
