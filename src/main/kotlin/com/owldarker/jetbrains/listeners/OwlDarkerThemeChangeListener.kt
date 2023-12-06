package com.owldarker.jetbrains.listeners

import com.owldarker.jetbrains.enums.OwlDarkerVariant
import com.intellij.ide.ui.LafManager
import com.intellij.ide.ui.LafManagerListener
import com.intellij.openapi.editor.colors.EditorColorsManager

class OwlDarkerThemeChangeListener : LafManagerListener {

    private val editorColorsManager = EditorColorsManager.getInstance()

    private var previousUI = LafManager.getInstance().currentLookAndFeel.name

    override fun lookAndFeelChanged(lafManager: LafManager) {
        val currentUI = lafManager.currentLookAndFeel.name
        if (previousUI != currentUI) {
            if (currentUI == OwlDarkerVariant.OwlDarker.label || currentUI == OwlDarkerVariant.OwlDarkerColorful.label || currentUI == OwlDarkerVariant.OwlDarkerMocha.label) {
                editorColorsManager.globalScheme = editorColorsManager.getScheme("_@user_$currentUI")
            }
        }
        previousUI = currentUI
    }

}