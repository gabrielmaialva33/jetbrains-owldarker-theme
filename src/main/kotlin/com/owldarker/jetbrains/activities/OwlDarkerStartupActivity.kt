package com.owldarker.jetbrains.activities

import com.owldarker.jetbrains.OwlDarkerMeta
import com.owldarker.jetbrains.notifications.OwlDarkerNotification
import com.owldarker.jetbrains.settings.OwlDarkerSettings
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity

class OwlDarkerStartupActivity : StartupActivity, DumbAware {
    override fun runActivity(project: Project) {
        val settings = OwlDarkerSettings.instance
        if (settings.version.isEmpty()) {
            settings.version = OwlDarkerMeta.currentVersion
            OwlDarkerNotification.notifyFirstlyDownloaded(project)
            return
        }
        if (OwlDarkerMeta.currentVersion != settings.version) {
            settings.version = OwlDarkerMeta.currentVersion
            OwlDarkerNotification.notifyReleaseNote(project)
        }
    }
}