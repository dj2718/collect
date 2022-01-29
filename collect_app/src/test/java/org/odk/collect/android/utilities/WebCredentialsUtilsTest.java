package org.odk.collect.android.utilities;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.odk.collect.android.logic.PropertyManager;
import org.odk.collect.settings.ProjectKeys;
import org.odk.collect.shared.Settings;

public class WebCredentialsUtilsTest {

    @Test
    public void saveCredentialsPreferencesMethod_shouldSaveNewCredentialsAndReloadPropertyManager() {
        Settings generalSettings = mock(Settings.class);
        WebCredentialsUtils webCredentialsUtils = new WebCredentialsUtils(generalSettings);
        PropertyManager propertyManager = mock(PropertyManager.class);

        webCredentialsUtils.saveCredentialsPreferences("username", "password", propertyManager);

        verify(generalSettings, times(1)).save(ProjectKeys.KEY_USERNAME, "username");
        verify(generalSettings, times(1)).save(ProjectKeys.KEY_PASSWORD, "password");
        verify(propertyManager, times(1)).reload();
    }
}
