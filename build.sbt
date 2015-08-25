name := "osm-data"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  Seq(
    "com.thoughtworks.xstream" % "xstream" % "1.4.8",
    "org.mongodb" % "casbah-core_2.11" % "2.8.2"
  )
}

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "2.2.5" % "test"
  )
}

