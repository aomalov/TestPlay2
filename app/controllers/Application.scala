package controllers

import com.google.inject.Inject
import play.api.mvc._

class Application @Inject() (testController1: TestController1) extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def test1(param:Int, rp:Option[String], rp1: Option[Int]) =
    testController1.action1(param+" "+rp.getOrElse("no param rp")+" "+rp1.getOrElse("no param rp1"))


}