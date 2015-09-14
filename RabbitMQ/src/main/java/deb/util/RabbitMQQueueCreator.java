/**
 * 
 */
package deb.util;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * @author Debmalya
 *
 */
public class RabbitMQQueueCreator {
	
	private static final Logger LOGGER = Logger.getLogger(RabbitMQQueueCreator.class);
	private RabbitMQQueueCreator() {

	}

	public boolean createQueueInExchange(String queueName, String exchangeName,String routingKey) {
		boolean isOK = false;
		 try {
			com.rabbitmq.client.Channel channel = RabbitMQConnectionFactory.getDefaultConnection().createChannel();
			channel.exchangeDeclare(exchangeName, "fanout");
			channel.queueBind(queueName, exchangeName, routingKey);
			isOK = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(e.getMessage(),e);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error(e.getMessage(),e);
		}
//		.q
		return isOK;
	}

	private static class QueueCreatorFactoryHolder {
		private static final RabbitMQQueueCreator queueCreator = new RabbitMQQueueCreator();
	}

	public static RabbitMQQueueCreator getInstance() {
		try {
			return QueueCreatorFactoryHolder.queueCreator;
		} catch (Exception exc) {
			LOGGER.error(exc.getMessage(),exc);
		}
		return null;
	}
}
