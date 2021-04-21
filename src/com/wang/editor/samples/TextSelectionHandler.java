package com.wang.editor.samples;

import com.intellij.codeInsight.editorActions.ExtendWordSelectionHandler;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TextSelectionHandler implements ExtendWordSelectionHandler {
    @Override
    public boolean canSelect(@NotNull PsiElement e) {
        return e.getText().equals("\"print\"");
    }

    @Override
    public @Nullable
    List<TextRange> select(@NotNull PsiElement e, @NotNull CharSequence editorText, int cursorOffset, @NotNull Editor editor) {
        final Document document = editor.getDocument();
        Caret primaryCaret = editor.getCaretModel().getPrimaryCaret();
        int start = primaryCaret.getSelectionStart();
        int end = primaryCaret.getSelectionEnd();

        Thread thread = new Thread(() -> {
            WriteCommandAction.runWriteCommandAction(editor.getProject(), () -> {
                document.replaceString(start, end, "editor_basics");
            });
        });
        thread.start();

        primaryCaret.removeSelection();
        return null;
    }
}
