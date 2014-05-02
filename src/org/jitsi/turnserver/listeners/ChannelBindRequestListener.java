/**
 * 
 */
package org.jitsi.turnserver.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ice4j.StunMessageEvent;
import org.ice4j.message.Message;
import org.ice4j.message.Response;
import org.ice4j.stack.RequestListener;
import org.ice4j.stack.StunStack;

/**
 * The class that would be handling and responding to incoming ChannelBind requests that are
 * validated and sends a success or error response
 * 
 * @author Aakash Garg
 */
public class ChannelBindRequestListener 
		implements RequestListener 
{

	/**
	 * The <tt>Logger</tt> used by the <tt>ChannelBindRequestListener</tt> class
	 * and its instances for logging output.
	 */
	private static final Logger logger 
		= Logger.getLogger(ChannelBindRequestListener.class.getName());

	private final StunStack stunStack;

	/**
	 * The indicator which determines whether this
	 * <tt>ChannelBindrequestListener</tt> is currently started.
	 */
	private boolean started = false;

	/**
	 * Creates a new ChannelBindRequestListener
	 * 
	 * @param stunStack
	 */
	public ChannelBindRequestListener(StunStack stunStack) 
	{
		this.stunStack = stunStack;
	}

	@Override
	public void processRequest(StunMessageEvent evt)
			throws IllegalArgumentException 
	{
		if (logger.isLoggable(Level.FINER))
		{
			logger.finer("Received request " + evt);
		}
		Message message = evt.getMessage();
		if(message.getMessageType()==Message.CHANNELBIND_REQUEST)
		{
		    Response response = null;
		    //processing logic
		}
		else
		{
		    return;
		}
	}
	
	/**
	 * Starts this <tt>ChannelBindRequestListener</tt>. If it is not currently
	 * running, does nothing.
	 */
	public void start() 
	{
		if (!started) 
		{
			stunStack.addRequestListener(this);
			started = true;
		}
	}

	/**
	 * Stops this <tt>ChannelBindRequestListenerr</tt>. A stopped
	 * <tt>ChannelBindRequestListenerr</tt> can be restarted by calling
	 * {@link #start()} on it.
	 */
	public void stop() 
	{
		stunStack.removeRequestListener(this);
		started = false;
	}
}
