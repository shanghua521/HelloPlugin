package com.wang.editor.samples;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.actionSystem.TypedActionHandler;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class MyTypedHandler implements TypedActionHandler {
    @Override
    public void execute(@NotNull Editor editor, char charTyped, @NotNull DataContext dataContext) {
        final Document document = editor.getDocument();
        final Project project = editor.getProject();
        Runnable runnable = () -> document.insertString(0, String.valueOf(charTyped));
        WriteCommandAction.runWriteCommandAction(project, runnable);
    }
}
