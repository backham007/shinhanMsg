package com.igo.testro.logger;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.NullEnumeration;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;


public interface ITestroLogger {

	
	  /**
	     Add <code>newAppender</code> to the list of appenders of this
	     Category instance.

	     <p>If <code>newAppender</code> is already in the list of
	     appenders, then it won't be added again.
	  */
	    public abstract void addAppender(Appender newAppender);

	  /**
	     If <code>assertion</code> parameter is <code>false</code>, then
	     logs <code>msg</code> as an {@link #error(Object) error} statement.

	     <p>The <code>assert</code> method has been renamed to
	     <code>assertLog</code> because <code>assert</code> is a language
	     reserved word in JDK 1.4.

	     @param assertion
	     @param msg The message to print if <code>assertion</code> is
	     false.

	     @since 1.2 */
	  public
	  abstract void assertLog(boolean assertion, String msg) ;


	  /**
	     Call the appenders in the hierrachy starting at
	     <code>this</code>.  If no appenders could be found, emit a
	     warning.

	     <p>This method calls all the appenders inherited from the
	     hierarchy circumventing any evaluation of whether to log or not
	     to log the particular log request.

	     @param event the event to log.  */
	  public
	  abstract void callAppenders(LoggingEvent event) ;

	  /**
	    Log a message object with the {@link Level#DEBUG DEBUG} level.

	    <p>This method first checks if this category is <code>DEBUG</code>
	    enabled by comparing the level of this category with the {@link
	    Level#DEBUG DEBUG} level. If this category is
	    <code>DEBUG</code> enabled, then it converts the message object
	    (passed as parameter) to a string by invoking the appropriate
	    {@link org.apache.log4j.or.ObjectRenderer}. It then proceeds to call all the
	    registered appenders in this category and also higher in the
	    hierarchy depending on the value of the additivity flag.

	    <p><b>WARNING</b> Note that passing a {@link Throwable} to this
	    method will print the name of the <code>Throwable</code> but no
	    stack trace. To print a stack trace use the {@link #debug(Object,
	    Throwable)} form instead.

	    @param message the message object to log. */
	  public
	  abstract void debug(Object message);

	  /**
	   Log a message object with the <code>DEBUG</code> level including
	   the stack trace of the {@link Throwable} <code>t</code> passed as
	   parameter.

	   <p>See {@link #debug(Object)} form for more detailed information.

	   @param message the message object to log.
	   @param t the exception to log, including its stack trace.  */
	  public
	  abstract void debug(Object message, Throwable t);

	  /**
	    Log a message object with the {@link Level#ERROR ERROR} Level.

	    <p>This method first checks if this category is <code>ERROR</code>
	    enabled by comparing the level of this category with {@link
	    Level#ERROR ERROR} Level. If this category is <code>ERROR</code>
	    enabled, then it converts the message object passed as parameter
	    to a string by invoking the appropriate {@link
	    org.apache.log4j.or.ObjectRenderer}. It proceeds to call all the
	    registered appenders in this category and also higher in the
	    hierarchy depending on the value of the additivity flag.

	    <p><b>WARNING</b> Note that passing a {@link Throwable} to this
	    method will print the name of the <code>Throwable</code> but no
	    stack trace. To print a stack trace use the {@link #error(Object,
	    Throwable)} form instead.

	    @param message the message object to log */
	  public
	  abstract void error(Object message);

	  /**
	   Log a message object with the <code>ERROR</code> level including
	   the stack trace of the {@link Throwable} <code>t</code> passed as
	   parameter.

	   <p>See {@link #error(Object)} form for more detailed information.

	   @param message the message object to log.
	   @param t the exception to log, including its stack trace.  */
	  public
	  abstract void error(Object message, Throwable t);


	  /**
	    Log a message object with the {@link Level#FATAL FATAL} Level.

	    <p>This method first checks if this category is <code>FATAL</code>
	    enabled by comparing the level of this category with {@link
	    Level#FATAL FATAL} Level. If the category is <code>FATAL</code>
	    enabled, then it converts the message object passed as parameter
	    to a string by invoking the appropriate
	    {@link org.apache.log4j.or.ObjectRenderer}. It
	    proceeds to call all the registered appenders in this category and
	    also higher in the hierarchy depending on the value of the
	    additivity flag.

	    <p><b>WARNING</b> Note that passing a {@link Throwable} to this
	    method will print the name of the Throwable but no stack trace. To
	    print a stack trace use the {@link #fatal(Object, Throwable)} form
	    instead.

	    @param message the message object to log */
	  public
	  abstract void fatal(Object message);

	  /**
	   Log a message object with the <code>FATAL</code> level including
	   the stack trace of the {@link Throwable} <code>t</code> passed as
	   parameter.

	   <p>See {@link #fatal(Object)} for more detailed information.

	   @param message the message object to log.
	   @param t the exception to log, including its stack trace.  */
	  public
	  abstract void fatal(Object message, Throwable t);

	  /**
	     Get the additivity flag for this Category instance.
	  */
	  public
	  abstract boolean getAdditivity();

	  /**
	     Get the appenders contained in this category as an {@link
	     Enumeration}. If no appenders can be found, then a {@link NullEnumeration}
	     is returned.

	     @return Enumeration An enumeration of the appenders in this category.  */
	  public
	  abstract Enumeration getAllAppenders();

	  /**
	     Look for the appender named as <code>name</code>.

	     <p>Return the appender with that name if in the list. Return
	     <code>null</code> otherwise.  */
	  public abstract 
	  Appender getAppender(String name);

	  /**
	     Starting from this category, search the category hierarchy for a
	     non-null level and return it. Otherwise, return the level of the
	     root category.

	     <p>The Category class is designed so that this method executes as
	     quickly as possible.
	   */
	  public abstract 
	  Level getEffectiveLevel();

	  /**
	    *
	    * @deprecated Please use the the {@link #getEffectiveLevel} method
	    * instead.  
	    * */
	  public abstract 
	  Priority getChainedPriority();



	  /**
	     Return the the {@link Hierarchy} where this <code>Category</code>
	     instance is attached.

	     @deprecated Please use {@link #getLoggerRepository} instead.

	     @since 1.1 */
	  public abstract 
	  LoggerRepository  getHierarchy() ;

	  /**
	     Return the the {@link LoggerRepository} where this
	     <code>Category</code> is attached.

	     @since 1.2 */
	  public abstract 
	  LoggerRepository  getLoggerRepository();


	  /**
	     Return the category name.  */
	  public
	  abstract 
	  String getName();


	  /**
	     Returns the parent of this category. Note that the parent of a
	     given category may change during the lifetime of the category.

	     <p>The root category will return <code>null</code>.

	     @since 1.2
	  */
	  abstract public
	  Category getParent();


	  /**
	     Returns the assigned {@link Level}, if any, for this Category.

	     @return Level - the assigned Level, can be <code>null</code>.
	  */
	  abstract public
	  Level getLevel();

	  /**
	     @deprecated Please use {@link #getLevel} instead.
	  */
	  public
	  abstract Level getPriority();


	  /**
	     Return the <em>inherited</em> {@link ResourceBundle} for this
	     category.

	     <p>This method walks the hierarchy to find the appropriate
	     resource bundle. It will return the resource bundle attached to
	     the closest ancestor of this category, much like the way
	     priorities are searched. In case there is no bundle in the
	     hierarchy then <code>null</code> is returned.

	     @since 0.9.0 */
	  public
	  abstract ResourceBundle getResourceBundle();

	  /**
	    Log a message object with the {@link Level#INFO INFO} Level.

	    <p>This method first checks if this category is <code>INFO</code>
	    enabled by comparing the level of this category with {@link
	    Level#INFO INFO} Level. If the category is <code>INFO</code>
	    enabled, then it converts the message object passed as parameter
	    to a string by invoking the appropriate
	    {@link org.apache.log4j.or.ObjectRenderer}. It
	    proceeds to call all the registered appenders in this category and
	    also higher in the hierarchy depending on the value of the
	    additivity flag.

	    <p><b>WARNING</b> Note that passing a {@link Throwable} to this
	    method will print the name of the Throwable but no stack trace. To
	    print a stack trace use the {@link #info(Object, Throwable)} form
	    instead.

	    @param message the message object to log */
	  public
	  abstract void info(Object message);
	  
	  /**
	   Log a message object with the <code>INFO</code> level including
	   the stack trace of the {@link Throwable} <code>t</code> passed as
	   parameter.

	   <p>See {@link #info(Object)} for more detailed information.

	   @param message the message object to log.
	   @param t the exception to log, including its stack trace.  */
	  public
	  abstract void info(Object message, Throwable t);

	  /**
	     Is the appender passed as parameter attached to this category?
	   */
	  public
	  abstract boolean isAttached(Appender appender);
	  
	  /**
	    *  Check whether this category is enabled for the <code>DEBUG</code>
	    *  Level.
	    *
	    *  <p> This function is intended to lessen the computational cost of
	    *  disabled log debug statements.
	    *
	    *  <p> For some <code>cat</code> Category object, when you write,
	    *  <pre>
	    *      cat.debug("This is entry number: " + i );
	    *  </pre>
	    *
	    *  <p>You incur the cost constructing the message, concatenatiion in
	    *  this case, regardless of whether the message is logged or not.
	    *
	    *  <p>If you are worried about speed, then you should write
	    *  <pre>
	    * 	 if(cat.isDebugEnabled()) {
	    * 	   cat.debug("This is entry number: " + i );
	    * 	 }
	    *  </pre>
	    *
	    *  <p>This way you will not incur the cost of parameter
	    *  construction if debugging is disabled for <code>cat</code>. On
	    *  the other hand, if the <code>cat</code> is debug enabled, you
	    *  will incur the cost of evaluating whether the category is debug
	    *  enabled twice. Once in <code>isDebugEnabled</code> and once in
	    *  the <code>debug</code>.  This is an insignificant overhead
	    *  since evaluating a category takes about 1%% of the time it
	    *  takes to actually log.
	    *
	    *  @return boolean - <code>true</code> if this category is debug
	    *  enabled, <code>false</code> otherwise.
	    *   */
	  public
	  abstract boolean isDebugEnabled();

	  /**
	     Check whether this category is enabled for a given {@link
	     Level} passed as parameter.

	     See also {@link #isDebugEnabled}.

	     @return boolean True if this category is enabled for <code>level</code>.
	  */
	  public
	  abstract boolean isEnabledFor(Priority level);

	  /**
	    Check whether this category is enabled for the info Level.
	    See also {@link #isDebugEnabled}.

	    @return boolean - <code>true</code> if this category is enabled
	    for level info, <code>false</code> otherwise.
	  */
	  public
	  abstract boolean isInfoEnabled();


	  /**
	     Log a localized message. The user supplied parameter
	     <code>key</code> is replaced by its localized version from the
	     resource bundle.

	     @see #setResourceBundle

	     @since 0.8.4 */
	  public
	  abstract void l7dlog(Priority priority, String key, Throwable t);
	  /**
	     Log a localized and parameterized message. First, the user
	     supplied <code>key</code> is searched in the resource
	     bundle. Next, the resulting pattern is formatted using
	     {@link java.text.MessageFormat#format(String,Object[])} method with the
	     user supplied object array <code>params</code>.

	     @since 0.8.4
	  */
	  public
	  abstract void l7dlog(Priority priority, String key,  Object[] params, Throwable t);

	  /**
	     This generic form is intended to be used by wrappers.
	   */
	  public
	  abstract void log(Priority priority, Object message, Throwable t);

	 /**
	    This generic form is intended to be used by wrappers.
	 */
	  public
	  abstract void log(Priority priority, Object message);
	  /**

	     This is the most generic printing method. It is intended to be
	     invoked by <b>wrapper</b> classes.

	     @param callerFQCN The wrapper class' fully qualified class name.
	     @param level The level of the logging request.
	     @param message The message of the logging request.
	     @param t The throwable of the logging request, may be null.  */
	  public
	  abstract void log(String callerFQCN, Priority level, Object message, Throwable t);

	    /**
	      *  LoggerRepository forgot the fireRemoveAppenderEvent method,
	      *     if using the stock Hierarchy implementation, then call its fireRemove.
	      *     Custom repositories can implement HierarchyEventListener if they
	      *     want remove notifications.
	     * @param appender appender, may be null.
	     */

	  /**
	     Remove all previously added appenders from this Category
	     instance.

	     <p>This is useful when re-reading configuration information.
	  */
	  public
	  abstract void removeAllAppenders();


	  /**
	     Remove the appender passed as parameter form the list of appenders.

	     @since 0.8.2
	  */
	  public
	  abstract void removeAppender(Appender appender);

	  /**
	     Remove the appender with the name passed as parameter form the
	     list of appenders.

	     @since 0.8.2 */
	  public
	  abstract void removeAppender(String name);

	  /**
	     Set the additivity flag for this Category instance.
	     @since 0.8.1
	   */
	  public
	  abstract void setAdditivity(boolean additive);

	  
	  /**
	     Set the level of this Category. If you are passing any of
	     <code>Level.DEBUG</code>, <code>Level.INFO</code>,
	     <code>Level.WARN</code>, <code>Level.ERROR</code>,
	     <code>Level.FATAL</code> as a parameter, you need to case them as
	     Level.

	     <p>As in <pre> &nbsp;&nbsp;&nbsp;logger.setLevel((Level) Level.DEBUG); </pre>


	     <p>Null values are admitted.  */
	  public
	  abstract void setLevel(Level level);


	  /**
	     Set the level of this Category.

	     <p>Null values are admitted.

	     @deprecated Please use {@link #setLevel} instead.
	  */
	  public
	  abstract void setPriority(Priority priority);


	  /**
	     Set the resource bundle to be used with localized logging
	     methods {@link #l7dlog(Priority,String,Throwable)} and {@link
	     #l7dlog(Priority,String,Object[],Throwable)}.

	     @since 0.8.4
	   */
	  public
	  abstract void setResourceBundle(ResourceBundle bundle);


	  /**
	    Log a message object with the {@link Level#WARN WARN} Level.

	    <p>This method first checks if this category is <code>WARN</code>
	    enabled by comparing the level of this category with {@link
	    Level#WARN WARN} Level. If the category is <code>WARN</code>
	    enabled, then it converts the message object passed as parameter
	    to a string by invoking the appropriate
	    {@link org.apache.log4j.or.ObjectRenderer}. It
	    proceeds to call all the registered appenders in this category and
	    also higher in the hieararchy depending on the value of the
	    additivity flag.

	    <p><b>WARNING</b> Note that passing a {@link Throwable} to this
	    method will print the name of the Throwable but no stack trace. To
	    print a stack trace use the {@link #warn(Object, Throwable)} form
	    instead.  <p>

	    @param message the message object to log.  */
	  public
	  abstract void warn(Object message);

	  /**
	   Log a message with the <code>WARN</code> level including the
	   stack trace of the {@link Throwable} <code>t</code> passed as
	   parameter.

	   <p>See {@link #warn(Object)} for more detailed information.

	   @param message the message object to log.
	   @param t the exception to log, including its stack trace.  */
	  public
	  abstract void warn(Object message, Throwable t);
	  
	  
	   /**
	     * Log a message object with the {@link org.apache.log4j.Level#TRACE TRACE} level.
	     *
	     * @param message the message object to log.
	     * @see #debug(Object) for an explanation of the logic applied.
	     * @since 1.2.12
	     */
	    public void trace(Object message);

	    /**
	     * Log a message object with the <code>TRACE</code> level including the
	     * stack trace of the {@link Throwable}<code>t</code> passed as parameter.
	     *
	     * <p>
	     * See {@link #debug(Object)} form for more detailed information.
	     * </p>
	     *
	     * @param message the message object to log.
	     * @param t the exception to log, including its stack trace.
	     * @since 1.2.12
	     */
	    public void trace(Object message, Throwable t);

	    /**
	     * Check whether this category is enabled for the TRACE  Level.
	     * @since 1.2.12
	     *
	     * @return boolean - <code>true</code> if this category is enabled for level
	     *         TRACE, <code>false</code> otherwise.
	     */
	    public boolean isTraceEnabled() ;
}
