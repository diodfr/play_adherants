name := "play_adherants"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "fr.diod.searchAdherants" % "ExcelSearch" % "0.0.3-SNAPSHOT",
  "org.apache.poi" % "poi-ooxml" % "3.11-beta3"
)

play.Project.playJavaSettings
