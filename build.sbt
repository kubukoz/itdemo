val IntegrationTest = config("it").extend(Test)

val core = project
  .configs(IntegrationTest)
  .settings(
    inConfig(IntegrationTest) {
      Defaults.testSettings
    }
  )

val root = project
  .in(file("."))
  .configs(IntegrationTest)
  .settings(
    inConfig(IntegrationTest) {
      Defaults.testSettings
    },
    libraryDependencies ++= Seq(
      // Visible in all scopes
      "org.typelevel" %% "cats-core" % "2.4.0",
      // Visible in tests *and* integration tests transitively
      "dev.zio" %% "zio" % "1.0.4-2" % "test",
      // Visible in tests *and* integration tests directly
      "org.scalatest" %% "scalatest" % "3.2.3" % "test,it",
      // Visible in integration tests only
      "org.typelevel" %% "cats-effect" % "3.0.0-M5" % "it"
    )
  )
  // Sources from each configuration in core are visible in the same config in root`
  .dependsOn(core % "compile->compile;test->test;it->it")
