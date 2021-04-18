package com.wang.action.persisting.component;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.wang.action.service.MyService;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Objects;

public class PersistingGetAction extends AnAction {


    public PersistingGetAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        MyService myService = MyService.getInstance();
        MyService.State state = myService.getState();

        Messages.showYesNoDialog(String.format("value form Persisting %s,datetime %s", Objects.requireNonNull(state).value, state.dateTime), "the value", Messages.getInformationIcon());
    }

    public void usePropertiesComponent(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        // 若不传入 project 则是程序级别，传入是此项目级别
        String hello = PropertiesComponent.getInstance(Objects.requireNonNull(project)).getValue("hello");
        Messages.showYesNoDialog(String.format("value form Persisting %s", hello), "the value", Messages.getInformationIcon());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        e.getPresentation().setEnabled(project != null);
    }
}
