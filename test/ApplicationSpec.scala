import com.typesafe.scalalogging.LazyLogging
import controllers.TestController1
import modules.{Hello, TestHello}
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.time.{Millis, Minutes, Span}
import org.scalatestplus.play.{ConfiguredApp, OneAppPerSuite}
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.inject.bind

class TestServiceSuite extends Suites(
  new TestServiceSpec
) with OneAppPerSuite with BeforeAndAfterAll with ScalaFutures {

  println("before inject override")
  override lazy val app = new GuiceApplicationBuilder()
                                  .overrides(bind[Hello].to[TestHello]).build()
  println("after inject override")

}

@DoNotDiscover()
class TestServiceSpec extends FreeSpec with Matchers with GeneratorDrivenPropertyChecks with ScalaFutures with ConfiguredApp with LazyLogging {

  implicit override val patienceConfig = PatienceConfig(timeout = Span(2, Minutes), interval = Span(5, Millis))

  println("injecting a new instance of controller")
  lazy val contr = app.injector.instanceOf[TestController1]

  "test bundle" - {

      println("test bundle constructor")
      "should add tasks when no matching tasks exists" in {
        println("before call")
        val s = contr.testInject()
        s should include("simple")
      }
  }
}
