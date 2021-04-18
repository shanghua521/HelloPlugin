package com.wang.dialog.wrapper;

import com.intellij.json.JsonLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.wang.editor.text.MyEditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class JsonOutputDialog extends DialogWrapper {

    private JPanel panel = new JPanel(new BorderLayout());

    public JsonOutputDialog(Project project) {
        super(true);
        super.setOKActionEnabled(false);
        init();


        MyEditorTextField myEditorTextField = new MyEditorTextField("hello World");
        myEditorTextField.setOneLineMode(false);
        myEditorTextField.setPreferredSize(new Dimension(800, 600));

        myEditorTextField.setVisible(true);
        panel.add(myEditorTextField);
        myEditorTextField.setCaretPosition(0);
    }


    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        return panel;
    }
}
