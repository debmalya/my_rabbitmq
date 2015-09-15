/**
 * 
 */
package deb.consumer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Debmalya
 *
 */
public class MessageDefaultConsumerTest {

	/**
	 * Test method for {@link deb.consumer.MessageDefaultConsumer#receiveMessage()}.
	 */
	@Test
	public void testReceiveMessage() {
		MessageDefaultConsumer consumer = new MessageDefaultConsumer();
		Assert.assertTrue(consumer.receiveMessage());
	}

}
