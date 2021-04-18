package com.wang.action.persisting.component;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.wang.action.service.MyService;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.time.LocalDateTime;

public class PersistingSetAction extends AnAction {

    public PersistingSetAction(String text, String description, Icon icon) {
        super(text, description, icon);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String str = Messages.showInputDialog("请输入想要存储的内容", "请输入", Messages.getQuestionIcon());
        MyService myService = MyService.getInstance();
        MyService.State state = myService.getState();
        state.value = str;
        state.dateTime = LocalDateTime.now();
        myService.loadState(state);
    }

    public void usePropertiesComponent(@NotNull AnActionEvent e) {
        String str = Messages.showInputDialog("请输入想要存储的内容", "请输入", Messages.getQuestionIcon());
        PropertiesComponent.getInstance(e.getProject()).setValue("hello", str);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        e.getPresentation().setEnabled(project != null);
    }
}
