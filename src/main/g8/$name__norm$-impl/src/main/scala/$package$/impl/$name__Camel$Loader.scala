package $package$.impl

import akka.cluster.sharding.typed.scaladsl.Entity
import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.server._
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import play.api.libs.ws.ahc.AhcWSComponents
import $package$.api.$name;format="Camel"$Service
import com.softwaremill.macwire._

class $name;format="Camel"$Loader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new $name;format="Camel"$Application(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new $name;format="Camel"$Application(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[$name;format="Camel"$Service])
}

abstract class $name;format="Camel"$Application(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  // Bind the service that this server provides
  override lazy val lagomServer: LagomServer = serverFor[$name;format="Camel"$Service](wire[$name;format="Camel"$ServiceImpl])

}
