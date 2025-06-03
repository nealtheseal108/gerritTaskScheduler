load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_jvm_external",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/refs/tags/4.4.zip",
    strip_prefix = "rules_jvm_external-4.4",
    sha256 = "c9a3f14b79b03abf05a9db46960e0f7f21dd3f181c5d8b73c2277e16f2a782c2",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.google.code.gson:gson:2.8.9",
    ],
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)
