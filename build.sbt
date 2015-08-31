name := """play-java-spring-jinq"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  filters,
  javaCore,
  javaWs % "test",
  "javax.inject" % "javax.inject" % "1",
  "org.jinq" % "jinq-jpa" % "1.8.4",
  "com.h2database" % "h2" % "1.4.188",
  "org.springframework" % "spring-context" % "4.2.0.RELEASE",
  "org.springframework" % "spring-orm" % "4.2.0.RELEASE",
  "org.springframework" % "spring-jdbc" % "4.2.0.RELEASE",
  "org.springframework" % "spring-tx" % "4.2.0.RELEASE",
  "org.springframework" % "spring-expression" % "4.2.0.RELEASE",
  "org.springframework" % "spring-aop" % "4.2.0.RELEASE",
  "org.springframework" % "spring-test" % "4.2.0.RELEASE" % "test",
  "org.hibernate" % "hibernate-entitymanager" % "5.0.0.Final"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)
