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
public class RabbitMQExchangeFactoryTest {

	/**
	 * Test method for {@link deb.util.RabbitMQExchangeFactory#createDefaulChannel(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateDefaulChannel() {
		Assert.assertTrue(RabbitMQExchangeFactory.getInstance().createDefaulChannel(RabbitMQConstants.DIRECT_EXCHANGE_NAME, RabbitMQConstants.DIRECT_EXCHANGE_TYPE));
	}

}
