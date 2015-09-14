/**
 * 
 */
package deb.consumer;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

/**
 * @author Debmalya
 *
 */
public class RabbitQueueConsumer implements Consumer{

	/* (non-Javadoc)
	 * @see com.rabbitmq.client.Consumer#handleCancel(java.lang.String)
	 */
	public void handleCancel(String arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.rabbitmq.client.Consumer#handleCancelOk(java.lang.String)
	 */
	public void handleCancelOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.rabbitmq.client.Consumer#handleConsumeOk(java.lang.String)
	 */
	public void handleConsumeOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.rabbitmq.client.Consumer#handleDelivery(java.lang.String, com.rabbitmq.client.Envelope, com.rabbitmq.client.AMQP.BasicProperties, byte[])
	 */
	public void handleDelivery(String arg0, Envelope arg1,
			BasicProperties arg2, byte[] arg3) throws IOException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.rabbitmq.client.Consumer#handleRecoverOk(java.lang.String)
	 */
	public void handleRecoverOk(String arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.rabbitmq.client.Consumer#handleShutdownSignal(java.lang.String, com.rabbitmq.client.ShutdownSignalException)
	 */
	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		// TODO Auto-generated method stub
		
	}

}
