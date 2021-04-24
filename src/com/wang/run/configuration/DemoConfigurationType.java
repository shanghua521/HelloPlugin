package com.wang.run.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DemoConfigurationType implements ConfigurationType {


    @Override
    public @NotNull
    @Nls(capitalization = Nls.Capitalization.Title)
    String getDisplayName() {
        return "DemoRunConfiguration";
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence)
    String getConfigurationTypeDescription() {
        return "Demo run configuration desc";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @Override
    public @NotNull
    @NonNls
    String getId() {
        return "DemoRunConfiguration";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new DemoConfigurationFactory(this)};
    }
}
