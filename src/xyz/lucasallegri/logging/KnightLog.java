package xyz.lucasallegri.logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import xyz.lucasallegri.launcher.LauncherConstants;

public class KnightLog {

	public final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public final static String curTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	private static FileHandler fileHandler;
	private static ConsoleHandler consoleHandler;
	private static SimpleFormatter formatterTxt;

	public static void setup() throws IOException {
	
		//new File("KnightLauncher.log").delete();
		//new File("KnightLauncher.log.lck").delete();
		//new File("KnightLauncher.log.1").delete();
		
		// get the global logger to configure it
	    consoleHandler = new ConsoleHandler();
	    fileHandler = new FileHandler("KnightLauncher/logs/" + curTime + "_KnightLauncher.log", true);
	
	    log.setLevel(Level.ALL);
	    fileHandler.setLevel(Level.ALL);
	    consoleHandler.setLevel(Level.ALL);
	    
	    // create a TXT formatter
	    formatterTxt = new SimpleFormatter();
	    fileHandler.setFormatter(formatterTxt);
	    log.addHandler(fileHandler);
	    log.addHandler(consoleHandler);
	    log.setUseParentHandlers(false);
	    
	    log.info("Running on version: " + LauncherConstants.VERSION);
	    log.info("Logging further interactions...");
	}
    
	public static void logException(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		log.severe(sw.toString());
	}
    
	public static void logException(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		log.severe(sw.toString());
	}
	
}
