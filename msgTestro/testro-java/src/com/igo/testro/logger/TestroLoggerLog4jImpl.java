package com.igo.testro.logger;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

/**
 * <p>
 * 프로그램명:TestroLoggerLog4jImpl.java<br/>
 * 설명 : Log4J Logger Wrapping<br/>
 * 변경이력<br/>
 * <ul>
 *	  <li>2008. 06. 10 : 이름(T001255) : 내용
 * </ul> 
 * </p>
 */
public class TestroLoggerLog4jImpl implements ITestroLogger {

	private Logger logger;

	public TestroLoggerLog4jImpl(Logger logger){
		this.logger = logger;
	}

	public void addAppender(Appender newAppender) {
		logger.addAppender(newAppender);
	}

	public void assertLog(boolean assertion, String msg) {
		logger.assertLog(assertion, msg);
	}

	public void callAppenders(LoggingEvent event) {
		logger.callAppenders(event);
	}

	public void debug(Object message, Throwable t) {
		logger.debug(message, t);
	}

	public void debug(Object message) {
		logger.debug(message);
	}

	public boolean equals(Object o) {
		return logger.equals(o);
	}

	public void error(Object message, Throwable t) {
		logger.error(message, t);
	}

	public void error(Object message) {
		logger.error(message);
	}

	public void fatal(Object message, Throwable t) {
		logger.fatal(message, t);
	}

	public void fatal(Object message) {
		logger.fatal(message);
	}

	public boolean getAdditivity() {
		return logger.getAdditivity();
	}

	public Enumeration getAllAppenders() {
		return logger.getAllAppenders();
	}

	public Appender getAppender(String name) {
		return logger.getAppender(name);
	}

	@Deprecated
	public Priority getChainedPriority() {
		return logger.getChainedPriority();
	}

	public Level getEffectiveLevel() {
		return logger.getEffectiveLevel();
	}

	@Deprecated
	public LoggerRepository getHierarchy() {
		return logger.getHierarchy();
	}

	public Level getLevel() {
		return logger.getLevel();
	}

	public LoggerRepository getLoggerRepository() {
		return logger.getLoggerRepository();
	}

	public String getName() {
		return logger.getName();
	}

	public Category getParent() {
		return logger.getParent();
	}
	
	@Deprecated
	public Level getPriority() {
		return logger.getPriority();
	}

	public ResourceBundle getResourceBundle() {
		return logger.getResourceBundle();
	}

	public int hashCode() {
		return logger.hashCode();
	}

	public void info(Object message, Throwable t) {
		logger.info(message, t);
	}

	public void info(Object message) {
		logger.info(message);
	}

	public boolean isAttached(Appender appender) {
		return logger.isAttached(appender);
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public boolean isEnabledFor(Priority level) {
		return logger.isEnabledFor(level);
	}

	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	public void l7dlog(Priority priority, String key, Object[] params, Throwable t) {
		logger.l7dlog(priority, key, params, t);
	}

	public void l7dlog(Priority priority, String key, Throwable t) {
		logger.l7dlog(priority, key, t);
	}

	public void log(Priority priority, Object message, Throwable t) {
		logger.log(priority, message, t);
	}

	public void log(Priority priority, Object message) {
		logger.log(priority, message);
	}

	public void log(String callerFQCN, Priority level, Object message, Throwable t) {
		logger.log(callerFQCN, level, message, t);
	}

	public void removeAllAppenders() {
		logger.removeAllAppenders();
	}

	public void removeAppender(Appender appender) {
		logger.removeAppender(appender);
	}

	public void removeAppender(String name) {
		logger.removeAppender(name);
	}

	public void setAdditivity(boolean additive) {
		logger.setAdditivity(additive);
	}

	public void setLevel(Level level) {
		logger.setLevel(level);
	}

	@Deprecated
	public void setPriority(Priority priority) {
		logger.setPriority(priority);
	}

	public void setResourceBundle(ResourceBundle bundle) {
		logger.setResourceBundle(bundle);
	}

	public String toString() {
		return logger.toString();
	}

	public void warn(Object message, Throwable t) {
		logger.warn(message, t);
	}

	public void warn(Object message) {
		logger.warn(message);
	}

	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	public void trace(Object message) {
		logger.trace(message);
	}

	public void trace(Object message, Throwable t) {
		logger.trace(message, t);
	}
}
