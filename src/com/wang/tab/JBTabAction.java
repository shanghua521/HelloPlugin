package com.wang.tab;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class JBTabAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new JBTabDialogWrapper(e.getProject()).showAndGet();
    }
}
