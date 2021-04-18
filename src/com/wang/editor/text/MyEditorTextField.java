package com.wang.editor.text;

import com.intellij.openapi.editor.EditorSettings;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.NotNull;

public class MyEditorTextField extends EditorTextField {

    public MyEditorTextField(@NotNull String text) {
        super(text);
    }

    @Override
    protected @NotNull
    EditorEx createEditor() {
        EditorEx editor = super.createEditor();
        editor.setVerticalScrollbarVisible(true);
        editor.setHorizontalScrollbarVisible(true);
        EditorSettings settings = editor.getSettings();
        settings.setLineNumbersShown(true);
        settings.setAutoCodeFoldingEnabled(true);
        settings.setFoldingOutlineShown(true);
        settings.setAllowSingleLogicalLineFolding(true);
        settings.setRightMarginShown(true);
        return editor;
    }
}
