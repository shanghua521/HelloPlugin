package com.wang.splitter;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class JBSplitterAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        new JBSplitterDialogWrapper().showAndGet();
    }
}
