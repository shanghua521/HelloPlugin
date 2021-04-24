package com.wang.controls;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ListAction extends AnAction {


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new ListDialogWrapper().showAndGet();
    }
}
