package com.wang.run.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class DemoConfigurationFactory extends ConfigurationFactory {

    private static final String FACTORY_NAME = "Demo configuration factory";

    protected DemoConfigurationFactory(@NotNull ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull
    RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new DemoRunConfiguration(project, this, "Demo");
    }

    @Override
    public @NotNull
    @Nls
    String getName() {
        return FACTORY_NAME;
    }

    @Override
    public @NotNull
    @NonNls
    String getId() {
        return FACTORY_NAME;
    }
}
