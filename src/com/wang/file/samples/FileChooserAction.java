package com.wang.file.samples;

import com.intellij.ide.util.TreeFileChooser;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.apache.commons.collections.CollectionUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class FileChooserAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true, true, true, true, true, true);
        chooseTreeFile(e);
    }

    public void chooseFileSingle(FileChooserDescriptor chooserDescriptor, AnActionEvent e) {
        VirtualFile virtualFile = FileChooser.chooseFile(chooserDescriptor, e.getProject(), null);
        if (virtualFile != null) {
            Messages.showMessageDialog(virtualFile.getName(), "获取到的文件名称", Messages.getInformationIcon());
        } else {
            Messages.showMessageDialog("文件名成为空", "文件名称为空", Messages.getInformationIcon());
        }
    }

    public void chooseTreeFile(AnActionEvent e) {
        TreeFileChooserFactory instance = TreeFileChooserFactory.getInstance(e.getProject());
        TreeFileChooser.PsiFileFilter fileFilter = file -> file.getName().endsWith(".java");
        TreeFileChooser javaFileChooser = instance.createFileChooser("java文件选择器", null, null, fileFilter);
        javaFileChooser.showDialog();
        PsiFile selectedFile = javaFileChooser.getSelectedFile();
        if (selectedFile != null) {
            Messages.showMessageDialog(selectedFile.getVirtualFile().getPath(), selectedFile.getVirtualFile().getName(), Messages.getInformationIcon());
        }
    }

    public void chooseFileMultiple(FileChooserDescriptor chooserDescriptor, AnActionEvent e) {
        VirtualFile toSelect = LocalFileSystem.getInstance().findFileByPath(File.separator + "Users" + File.separator + "shanghua" + File.separator + "swagger-html" + File.separator);
        FileChooser.chooseFiles(chooserDescriptor, null, toSelect, virtualFiles -> {
            if (CollectionUtils.isNotEmpty(virtualFiles)) {
                for (VirtualFile file : virtualFiles) {
                    Messages.showMessageDialog(file.getPath(), file.getName(), Messages.getInformationIcon());
                }
            }
        });
    }
}
