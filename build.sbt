name := "TestPlay2"

version := "1.0"

lazy val `testplay2` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

//libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test )

libraryDependencies ++= {
  val PlayJson4sVersion = "0.5.0"
  val ScalaTest = "2.2.6"
  Seq(
    ws,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
    "org.json4s" %% "json4s-native" % "3.4.0",
    "com.github.tototoshi" %% "play-json4s-native" % PlayJson4sVersion,
    "org.mongodb.scala" %% "mongo-scala-driver" % "1.1.1",
    /* Test */
    "com.github.tototoshi" %% "play-json4s-test-native" % PlayJson4sVersion % "test" withSources(),
    "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0" % "test" withSources(),
    "org.scalacheck" %% "scalacheck" % "1.12.1" % "test",
    "org.scalatest" %% "scalatest" % ScalaTest % "test" withSources(),
    "org.perf4j" % "perf4j" % "0.9.16"
  )
}

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  