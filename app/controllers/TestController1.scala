package controllers

import com.google.inject.{Inject, Singleton}
import modules.Hello
import play.api.mvc._

/**
  * Created by andrew.malov on 25/07/2016.
  **/

@Singleton
class TestController1 @Inject() (hello:Hello) extends Controller {

  def action1(param: String) = Action { req =>
    println(req.path)
    Ok(s"testcontroller 1: $param")
  }

  def action2() = Action { req =>
    val s=hello.sayHello("world DI")
    Ok(s"testcontroller 2: $s")
  }

  def testInject() = hello.sayHello("simple")

  println(hello.sayHello("controller startup"))
}
