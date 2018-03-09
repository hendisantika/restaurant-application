import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

/**
 * Created by IntelliJ IDEA.
 * Project : restaurant-application
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/03/18
 * Time: 06.31
 * To change this template use File | Settings | File Templates.
 */

@Configuration
class ReservationRoutes {
    @Bean
    fun routes(handler: ReservationHandler) = router {
        GET("/restaurants/{name}/availability", handler::checkAvailability)
    }
}