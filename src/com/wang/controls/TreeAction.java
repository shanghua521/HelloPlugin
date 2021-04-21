package com.wang.controls;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class TreeAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new TreeDialogWrapper().showAndGet();
    }
}
