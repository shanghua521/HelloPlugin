package com.wang.run.configuration;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DemoSettingsEditor extends SettingsEditor<DemoRunConfiguration> {
    private JPanel panel;
    private LabeledComponent<TextFieldWithBrowseButton> scriptName;

    private void createUIComponents() {
        scriptName = new LabeledComponent<>();
        scriptName.setComponent(new TextFieldWithBrowseButton());
    }

    @Override
    protected void resetEditorFrom(@NotNull DemoRunConfiguration s) {

    }

    @Override
    protected void applyEditorTo(@NotNull DemoRunConfiguration s) throws ConfigurationException {

    }

    @Override
    protected @NotNull
    JComponent createEditor() {
        return panel;
    }
}
