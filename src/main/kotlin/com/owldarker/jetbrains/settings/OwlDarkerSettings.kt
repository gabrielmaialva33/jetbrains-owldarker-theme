package com.owldarker.jetbrains.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "OwlDarkerSetting", storages = [Storage("owldarker-theme.xml")])
class OwlDarkerSettings : PersistentStateComponent<OwlDarkerState> {
    companion object {
        val instance: OwlDarkerSettings
            get() = ApplicationManager.getApplication().getService(OwlDarkerSettings::class.java)
    }

    private var myState = OwlDarkerState()

    var version: String
        get() = myState.version
        set(value) {
            myState.version = value
        }

    override fun getState(): OwlDarkerState {
        return myState
    }

    override fun loadState(state: OwlDarkerState) {
        myState = state
    }

}
