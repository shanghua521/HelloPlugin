package com.wang.file;

import com.intellij.ide.util.TreeFileChooser;
import com.intellij.ide.util.TreeFileChooserFactory;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

public class MyFileChooser {

    public static void choseFile(Project project) {
        useTreeFileChooser(project);
    }

    public static void useFileChooser(Project project) {
        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(true, true, true, true, true, false);
        VirtualFile virtualFile = FileChooser.chooseFile(chooserDescriptor, project, null);
        if (virtualFile != null) {
            Messages.showMessageDialog(virtualFile.getName(), "获取到的文件名称", Messages.getInformationIcon());
        } else {
            Messages.showMessageDialog("文件名称为空", "文件名称为空", Messages.getInformationIcon());
        }
    }

    public static void useTreeFileChooser(Project project) {
        TreeFileChooserFactory instance = TreeFileChooserFactory.getInstance(project);
        TreeFileChooser.PsiFileFilter fileFilter = file -> true;
        TreeFileChooser javaFileChooser = instance.createFileChooser("java文件选择器", null, null, fileFilter);
        javaFileChooser.showDialog();
        PsiFile selectedFile = javaFileChooser.getSelectedFile();
        if (selectedFile != null) {
            Messages.showMessageDialog(selectedFile.getVirtualFile().getPath(), selectedFile.getVirtualFile().getName(), Messages.getInformationIcon());
        }
    }
}
