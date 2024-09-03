package com.twofasapp.prefs.usecase

import android.content.Context
import com.twofasapp.prefs.internals.PreferenceString
import com.twofasapp.storage.Preferences

// Historically it was only saved in SecurePreferences, migrate at some point
class PinSecuredPreference(
    private val context: Context,
    private val preferences: Preferences
) : PreferenceString(preferences) {

    override val key: String = "pinSecured"
    override val default: String = ""

    override fun get(): String {
        return preferences.getString(key) ?: default
    }

    override fun put(model: String) {
        if (model.isBlank()) {
            preferences.delete(key)
        } else {
            preferences.putString(key, model)
        }
    }
}