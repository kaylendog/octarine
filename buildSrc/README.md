# `buildSrc/`

This directory contains the build logic for the entire repository. It, very cumbersomely, applies the necessary gradle plugins to each project and configures them.

At the moment, this is using a full pre-compiled plugin, and it would be far nicer if we could do this in a single script as per the [Gradle documentation](https://docs.gradle.org/current/userguide/custom_plugins.html#sec:precompiled_plugins), but I am too stupid to work out how to do this.
