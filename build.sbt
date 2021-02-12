val IntegrationTest = config("it").extend(Test)

val root = project
  .in(file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings)
