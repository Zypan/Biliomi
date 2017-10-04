package nl.juraji.biliomi.io.console;

import nl.juraji.biliomi.io.console.support.ConsoleListener;
import nl.juraji.biliomi.io.console.support.LegacyConsoleListener;
import nl.juraji.biliomi.io.console.support.ModernConsoleListener;
import nl.juraji.biliomi.utility.commandrouters.cmd.CliCommandRouter;
import nl.juraji.biliomi.utility.events.EventBus;
import nl.juraji.biliomi.utility.factories.concurrent.DefaultThreadFactory;
import nl.juraji.biliomi.utility.types.Init;
import org.apache.logging.log4j.Logger;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ExecutionException;

/**
 * Created by Juraji on 1-5-2017.
 * Biliomi v3
 */
@Default
@Singleton
public class ConsoleApi implements Init {

  private ConsoleListener consoleListener;

  @Inject
  private Logger logger;

  @Inject
  private EventBus eventBus;

  @Override
  public void init() {
    DefaultThreadFactory threadFactory = DefaultThreadFactory.newFactory("ConsoleApi", true);

    // Select the CliCommandrouter so it bootstraps
    CDI.current().select(CliCommandRouter.class).get();

    if (System.console() == null) {
      logger.info("Your system does not support console input via the Console API. Using legacy console input.");
      consoleListener = new LegacyConsoleListener(eventBus, logger);
    } else {
      consoleListener = new ModernConsoleListener(eventBus, logger);
    }

    threadFactory.newThread(consoleListener).start();
  }

  @PreDestroy
  private void destroy() {
    consoleListener.stop();
  }

  public String waitForInput() throws ExecutionException, InterruptedException {
    return consoleListener.nextInput().get();
  }
}