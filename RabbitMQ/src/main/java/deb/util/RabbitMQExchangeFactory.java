/**
 * 
 */
package deb.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.rabbitmq.client.Channel;

/**
 * @author Debmalya This one creates different types of RabbitMQ exchange
 *         fanout,topic,headers,direct.
 */
public class RabbitMQExchangeFactory {
	private static final Logger LOGGER = Logger
			.getLogger(RabbitMQExchangeFactory.class);

	/**
	 * @param exchangeName
	 *            to be created.
	 * @return true if exchange created successfully.
	 * @throws IOException
	 * @throws Throwable
	 */
	public boolean createDefaulFanoutChannel(String exchangeName) {
		Channel channel;
		boolean isOK = true;
		try {
			channel = RabbitMQConnectionFactory.getDefaultConnection()
					.createChannel();
			channel.exchangeDeclare(exchangeName, "fanout");
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
			isOK = false;
		} catch (Throwable e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
			isOK = false;
		}

		return isOK;
	}

	
	/**
	 * @param exchangeName
	 *            to be created.
	 * @param exchangeType to be created.           
	 * @return true if exchange created successfully.
	 * @throws IOException
	 * @throws Throwable
	 */
	public boolean createDefaulChannel(String exchangeName,String exchangeType) {
		Channel channel;
		boolean isOK = true;
		try {
			channel = RabbitMQConnectionFactory.getDefaultConnection()
					.createChannel();
			channel.exchangeDeclare(exchangeName, exchangeType);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
			isOK = false;
		} catch (Throwable e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
			isOK = false;
		}

		return isOK;
	}

	

	private static class GCEExchangeFactoryHolder {
		private final static RabbitMQExchangeFactory instance = new RabbitMQExchangeFactory();
	}

	public static RabbitMQExchangeFactory getInstance() {
		try {
			return GCEExchangeFactoryHolder.instance;
		} catch (ExceptionInInitializerError ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
		return null;
	}
}
