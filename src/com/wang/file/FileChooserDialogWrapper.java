package com.wang.file;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.*;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileChooserDialogWrapper extends DialogWrapper {

    private TextFieldWithBrowseButton textFieldWithBrowseButton;

    private JTextField fileTextFiled;

    public FileChooserDialogWrapper() {
        super(true);
        init();
        setTitle("文件选择对话框");
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        JPanel panel = new JPanel();
        textFieldWithBrowseButton = new TextFieldWithBrowseButton();
        fileTextFiled = new JTextField();
        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true, true, true, true, true, true);
        TextBrowseFolderListener listener = new TextBrowseFolderListener(chooserDescriptor);
        textFieldWithBrowseButton.addBrowseFolderListener(listener);
        textFieldWithBrowseButton.setText(File.separator + "User" + File.separator);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(400, 40));
        panel.add(textFieldWithBrowseButton, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected @Nullable
    ValidationInfo doValidate() {
        String filePath = textFieldWithBrowseButton.getText();
        VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(filePath);
        if (virtualFile != null) {
            Messages.showInputDialog(virtualFile.getPath(), virtualFile.getName(), Messages.getInformationIcon());
        }
        return null;
    }
}
