package com.wang.run.configuration;

import com.intellij.execution.configurations.ConfigurationTypeBase;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GradleExternalTaskConfigurationType extends ConfigurationTypeBase {

    public GradleExternalTaskConfigurationType(@NotNull String id, @Nls @NotNull String displayName, @Nls @Nullable String description, @Nullable Icon icon) {
        super("com.wang.run.configuration.GradleExternalTaskConfigurationType", "test run", "Test Run Configuration", icon);
    }
}
