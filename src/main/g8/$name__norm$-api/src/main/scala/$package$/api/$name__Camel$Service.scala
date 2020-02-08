package $package$.api

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import play.api.libs.json.{Format, Json}

/**
  * The $name$ service interface.
  * <p>
  * This describes everything that Lagom needs to know about how to serve and
  * consume the $name;format="Camel"$Service.
  */
trait $name;format="Camel"$Service extends Service {

  /**
    * Example: curl http://localhost:9000/api/hello/Alice
    */
  def hello(id: String): ServiceCall[NotUsed, String]

  /**
    * Example: curl -H "Content-Type: application/json" -X POST -d '{"message":
    * "Hi"}' http://localhost:9000/api/hello/Alice
    */
  def useGreeting(id: String): ServiceCall[GreetingMessage, Done]


  override final def descriptor: Descriptor = {
    import Service._
    // @formatter:off
    named("$name;format="norm"$")
      .withCalls(
        pathCall("/api/hello/:id", hello _),
        pathCall("/api/hello/:id", useGreeting _)
      )
      .withAutoAcl(true)
    // @formatter:on
  }
}
