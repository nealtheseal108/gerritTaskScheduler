load("//tools/bzl:plugin.bzl", "gerrit_plugin")

gerrit_plugin(
    name = "my-plugin",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = glob(["resources/static/**"]),
    resource_strip_prefix = "resources/static",
    manifest_entries = {
        "Gerrit-PluginName": "my-plugin",
        "Gerrit-Module": "com.example.myplugin.MyPluginModule",
        "Gerrit-ApiType": "PLUGIN",
        "Gerrit-UiPlugin": "my-plugin.html"
    },
    deps = [
        "@maven//:com_google_code_gson_gson",
    ],
)
