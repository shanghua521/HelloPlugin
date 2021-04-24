package com.wang.editor.samples;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class EditorAreaIllustration extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        final CaretModel caretModel = editor.getCaretModel();
        final Caret primaryCaret = caretModel.getPrimaryCaret();
        LogicalPosition logicalPos = primaryCaret.getLogicalPosition();
        VisualPosition visualPos = primaryCaret.getVisualPosition();
        int caretOffset = primaryCaret.getOffset();

        String report = logicalPos + "\n" + visualPos + "\n" + "Offset" + caretOffset;
        Messages.showInfoMessage(report, "Caret Parameters Inside The Editor");
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Project project = e.getProject();
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        e.getPresentation().setEnabledAndVisible(project != null && editor != null);
    }
}
