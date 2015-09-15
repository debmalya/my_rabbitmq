/**
 * 
 */
package deb.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

import deb.constants.RabbitMQConstants;
import deb.util.RabbitMQConnectionFactory;

/**
 * @author Debmalya
 *
 */
public class MessageRouter {
	
	public boolean routeMessage(String message) {
		boolean isOK = false;
		Channel channel = null;
		try {
			channel = RabbitMQConnectionFactory.getDefaultConnection().createChannel();
			channel.basicPublish(RabbitMQConstants.DIRECT_EXCHANGE_NAME, RabbitMQConstants.ROUTING_KEY_JAVA, null, message.getBytes());
			
			
			isOK = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return isOK;
	}

}
