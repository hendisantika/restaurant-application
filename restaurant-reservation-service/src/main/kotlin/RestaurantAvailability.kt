/**
 * Created by IntelliJ IDEA.
 * Project : restaurant-application
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/03/18
 * Time: 06.43
 * To change this template use File | Settings | File Templates.
 */

data class RestaurantAvailability(
        val name: String,
        val available: Boolean,
        val confirmationUri: URI? = null
)