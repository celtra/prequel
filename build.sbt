import ohnosequences.sbt.SbtS3Resolver._

name := "prequel"

version := "0.3.10"

organization := "com.celtra"

scalaVersion := "2.10.3"

scalacOptions ++= Seq(
    "-Xmax-classfile-name", "140"
)

// Runtime Dependencies
libraryDependencies ++= Seq(
    "commons-pool" % "commons-pool" % "1.5.5",
    "commons-dbcp" % "commons-dbcp" % "1.4",
    "commons-lang" % "commons-lang" % "2.6",
    "joda-time" % "joda-time" % "2.6",
    "org.joda" % "joda-convert" % "1.7"
)

// Test Dependencies
libraryDependencies ++= Seq(
    "org.hsqldb" % "hsqldb" % "2.2.4" % "test",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

// Release publishing stuff
S3Resolver.defaults

publishTo := Some(s3resolver.value("Celtra S3 bucket", s3("files.celtra-test.com/maven")) withIvyPatterns)

s3credentials := file(System.getProperty("user.home")) / ".sbt" / ".s3credentials"

pomIncludeRepository := { _ => false }

publishMavenStyle := false

credentials += Credentials( Path.userHome / ".ivy2" / ".credentials" )

pomExtra :=
  <url>http://github.com/celtra/prequel</url>
  <licenses>
    <license>
      <name>wtfpl</name>
      <url>http://www.wtfpl.net/txt/copying/</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/celtra/prequel.git</url>
    <connection>scm:git:https://github.com/celtra/prequel.git</connection>
  </scm>
  <developers>
    <developer>
      <id>jpersson</id>
      <name>Johan Persson</name>
      <url>http://github.com/jpersson</url>
    </developer>
  </developers>
