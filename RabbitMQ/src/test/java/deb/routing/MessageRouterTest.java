/**
 * 
 */
package deb.routing;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Debmalya
 *
 */
public class MessageRouterTest {

	/**
	 * Test method for {@link deb.routing.MessageRouter#routeMessage(java.lang.String)}.
	 */
	@Test
	public void testRouteMessage() {
		MessageRouter router = new MessageRouter();
		Assert.assertTrue(router.routeMessage("Hello Java"));
	}

}
