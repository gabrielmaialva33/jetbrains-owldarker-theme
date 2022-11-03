package com.owldarker.jetbrains

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.extensions.PluginId

object OwlDarkerMeta {
    val currentVersion: String
        get() = PluginManagerCore.getPlugin(PluginId.getId("com.mrootx.idea"))?.version ?: ""
}