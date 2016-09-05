name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-core" % "5.1.0.Final",
  "org.postgresql" % "postgresql" % "9.4-1204-jdbc4"
)

PlayKeys.externalizeResources := false
