package com.wang.dialog.wrapper;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class SampleDialogWrapper extends DialogWrapper {
    public SampleDialogWrapper() {
        super(true);
        init();
        setTitle("Test DialogWrapper");
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("testing");
        label.setPreferredSize(new Dimension(100, 100));
        dialogPanel.add(label, BorderLayout.CENTER);
        return dialogPanel;
    }
}
