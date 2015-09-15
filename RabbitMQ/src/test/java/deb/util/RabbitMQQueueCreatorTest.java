/**
 * 
 */
package deb.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import deb.constants.RabbitMQConstants;

/**
 * @author Debmalya
 *
 */
public class RabbitMQQueueCreatorTest {

	/**
	 * Test method for
	 * {@link deb.util.RabbitMQQueueCreator#createQueueInExchange(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testCreateQueueInExchange() {
		Assert.assertTrue(RabbitMQQueueCreator.getInstance().createQueueInExchange(
				RabbitMQConstants.QUEUE_JAVA,
				RabbitMQConstants.DIRECT_EXCHANGE_NAME,
				RabbitMQConstants.DIRECT_EXCHANGE_TYPE,
				RabbitMQConstants.ROUTING_KEY_JAVA));
	}

}
