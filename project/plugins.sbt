resolvers += "Era7 maven releases" at "http://releases.era7.com.s3.amazonaws.com"

resolvers += "Celtra" at "http://files.celtra.com/maven"

addSbtPlugin("ohnosequences" % "sbt-s3-resolver" % "0.13.1")
