package controllers

import org.perf4j.slf4j.Slf4JStopWatch
import play.api.mvc.{Action, AnyContent, Request, Result}
/**
  * @author maciek_r
  *
  * simplest perf4j action wrapper that sets off stopwatch
  */
trait Perf4j {
  def ProfiledAction(tag: String)(f: Request[AnyContent] => Result): Action[AnyContent] = {
    Action { request =>
      val stopWatch = new Slf4JStopWatch()
      stopWatch.start(tag)
      try {
        f(request)
      } finally {
        stopWatch.stop()
      }
    }
  }
}