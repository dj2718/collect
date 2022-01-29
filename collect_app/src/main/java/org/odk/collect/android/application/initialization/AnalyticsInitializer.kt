package org.odk.collect.android.application.initialization

import org.odk.collect.analytics.Analytics
import org.odk.collect.android.configure.SettingsProvider
import org.odk.collect.android.version.VersionInformation
import org.odk.collect.settings.ProjectKeys

class AnalyticsInitializer(
    private val analytics: Analytics,
    private val versionInformation: VersionInformation,
    private val settingsProvider: SettingsProvider
) {

    fun initialize() {
        if (versionInformation.isBeta) {
            analytics.setAnalyticsCollectionEnabled(true)
        } else {
            val analyticsEnabled = settingsProvider.getUnprotectedSettings().getBoolean(ProjectKeys.KEY_ANALYTICS)
            analytics.setAnalyticsCollectionEnabled(analyticsEnabled)
        }

        Analytics.setInstance(analytics)
    }
}
