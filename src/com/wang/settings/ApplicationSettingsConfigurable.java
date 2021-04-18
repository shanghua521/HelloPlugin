package com.wang.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ApplicationSettingsConfigurable implements Configurable {

    private AppSettingsComponent mySettingComponent;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "SDK: Application Setting Example";
    }

    @Override
    public @Nullable
    JComponent createComponent() {
        mySettingComponent = new AppSettingsComponent();
        return mySettingComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        boolean modified = !mySettingComponent.getUserNameText().equals(settings.userId);
        modified |= mySettingComponent.getIdeaUserStatus() != settings.ideaStatus;
        return modified;
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingComponent.getPreferredFocusedComponent();
    }

    @Override
    public void apply() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.userId = mySettingComponent.getUserNameText();
        settings.ideaStatus = mySettingComponent.getIdeaUserStatus();
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        mySettingComponent.setUserNameText(settings.userId);
        mySettingComponent.setIdeaUserStatus(settings.ideaStatus);
    }

    @Override
    public void disposeUIResources() {
        mySettingComponent = null;
    }
}
