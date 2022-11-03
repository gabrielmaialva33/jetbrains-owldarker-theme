package com.owldarker.jetbrains.notifications

import com.owldarker.jetbrains.OwlDarkerMeta
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import org.intellij.lang.annotations.Language

object OwlDarkerNotification {

    @Language("HTML")
    private val whatsNew = """
        <ul>
            <li>Fix welcome window project color</li>
        </ul>
    """.trimIndent()

    @Language("HTML")
    private val footerMessage = """
        <p>Thank you for choosing OwlDarker.</p>
        <br>
        <p>
            <a href="https://github.com/gabrielmaialva33/jetbrains-owldarker-theme/blob/master/CHANGELOG.md">Changelog</a> | 
            <a href="https://github.com/gabrielmaialva33/jetbrains-owldarker-theme">GitHub</a>
        </p>
    """.trimIndent()

    @Language("HTML")
    private val releaseNote = """
        <div>
            <h3>What's New?</h3>
            <div>$whatsNew</div>
            <div>$footerMessage</div>
        </div>
    """.trimIndent()

    @Language("HTML")
    private val welcomeMessage = """
        <div>
            $footerMessage
        </div>
    """.trimIndent()

    private const val notificationGroupId = "Owl Darker Theme"

    @JvmField
    val notificationIcon = IconLoader.getIcon("/icons/owldarker-logo.svg", javaClass)

    fun notifyReleaseNote(project: Project) {
        val title = "Owl Darker Theme updated to v${OwlDarkerMeta.currentVersion}"
        val notification = NotificationGroupManager.getInstance().getNotificationGroup(notificationGroupId)
            .createNotification(title, releaseNote, NotificationType.INFORMATION)
        notification.icon = notificationIcon
        notification.notify(project)
    }

    fun notifyFirstlyDownloaded(project: Project) {
        val title = "Owl Darker Theme is installed"
        val notification = NotificationGroupManager.getInstance().getNotificationGroup(notificationGroupId)
            .createNotification(title, welcomeMessage, NotificationType.INFORMATION)
        notification.icon = notificationIcon
        notification.notify(project)
    }

}
