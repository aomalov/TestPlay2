package modules

/**
  * Created by andrew.malov on 04/08/2016.
  */


import com.google.inject.{AbstractModule, ImplementedBy, Inject}

@ImplementedBy(classOf[EnglishHello])
trait Hello {
  def sayHello(name: String): String

//  println("hello created")
}

class EnglishHello extends Hello {
  def sayHello(name: String) = "Hello [en] " + name

  println("english created")
}

class TestHello extends Hello {
  override def sayHello(name: String): String = s"test hello $name"
}

class MyModule  extends AbstractModule {

  def configure() = {

    println("just startup")
  }

}