/**
 * 
 */
package deb.consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import deb.constants.RabbitMQConstants;
import deb.util.RabbitMQConnectionFactory;

/**
 * @author Debmalya
 *
 */
public class MessageDefaultConsumer {

	public boolean receiveMessage() {
		boolean isOK = false;
		Connection connection = null;
		Channel channel = null;
		try {
			connection = RabbitMQConnectionFactory.getDefaultConnection();
			channel = connection.createChannel();
			channel.queueBind(RabbitMQConstants.QUEUE_JAVA, RabbitMQConstants.DIRECT_EXCHANGE_NAME, RabbitMQConstants.ROUTING_KEY_JAVA);
			
			Consumer consumer = new DefaultConsumer(channel) {
			      @Override
			      public void handleDelivery(String consumerTag, Envelope envelope,
			                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
			        String message = new String(body, "UTF-8");
			        System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			      }
			    };
			    channel.basicConsume(RabbitMQConstants.QUEUE_JAVA, true, consumer);
			isOK = true;
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
			if (connection != null) {
				try {
					connection.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isOK;
	}
}
