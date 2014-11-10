package de.flameboard.api.endpoints.health;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * Created by Sven on 07.11.2014.
 *
 * Checks actual disc space situation
 * if theres enough space builder.up is called else its down
 *
 * Marked as @Deprecated because it will be released with Spring Boot 1.2
 */
@Deprecated
@Component
public class DiskSpaceHealthIndicator extends AbstractHealthIndicator {

  private final FileStore fileStore;
  private final long thresholdBytes;

  @Autowired
  public DiskSpaceHealthIndicator(@Value("${health.filestore.path:${user.dir}}") String path,
                                  @Value("${health.filestore.threshold.bytes:10485760}") long aThresholdBytes) throws
                                                                                                               IOException {
    fileStore = Files.getFileStore(Paths.get(path));
    this.thresholdBytes = aThresholdBytes;
  }

  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {
    long diskFreeInBytes = fileStore.getUnallocatedSpace();
    if (diskFreeInBytes >= thresholdBytes) {
      builder.up();
    } else {
      builder.down();
    }
    long totalSpaceInBytes = fileStore.getTotalSpace();
    builder.withDetail("disk.free", diskFreeInBytes);
    builder.withDetail("disk.used", (totalSpaceInBytes - diskFreeInBytes));
    builder.withDetail("disk.total", totalSpaceInBytes);
  }
}
