/**
 * 
 */
package deb.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Debmalya
 *
 */
public class RabbitMQConnectionFactory {
	
	private static Connection defaultConnection = null;
	
	private static Connection connection = null;

	public static Connection getDefaultConnection() throws Throwable {
		if (defaultConnection == null) {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setUri("amqp://test:test@localhost:5672");
			defaultConnection = factory.newConnection();
		}
		return defaultConnection;
		
	}
	
	public static Connection getConnection(String URI) throws Throwable {
		if (connection == null) {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setUri(URI);
			defaultConnection = factory.newConnection();
		}
		return connection;
		
	}
}
