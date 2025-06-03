load("//tools/bzl:plugin.bzl", "gerrit_plugin")

gerrit_plugin(
    name = "my-plugin",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = glob(["resources/static/**"]),
    resource_strip_prefix = "plugins/my-plugin/resources/static",
)
