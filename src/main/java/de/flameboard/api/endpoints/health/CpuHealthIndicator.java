package de.flameboard.api.endpoints.health;

import org.apache.log4j.Logger;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * Created by Lobedan on 21.09.2014.
 * <p>
 * Checks the actual cpu situation on the server
 * if cpu usage is under 90% than helth.up is displayed else its down
 * Use cat /proc/cpuinfo unter linux
 * sysctl machdep hw under mac
 */
@Component
public class CpuHealthIndicator extends AbstractHealthIndicator {
  private static final Logger LOGGER = Logger.getLogger(CpuHealthIndicator.class);

  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {

  }
}
