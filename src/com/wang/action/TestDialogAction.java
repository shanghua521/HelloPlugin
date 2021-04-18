package com.wang.action;

import com.intellij.credentialStore.CredentialAttributes;
import com.intellij.credentialStore.CredentialAttributesKt;
import com.intellij.credentialStore.Credentials;
import com.intellij.ide.passwordSafe.PasswordSafe;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vcs.vfs.AbstractVcsVirtualFile;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.ui.components.JBList;
import com.wang.dialog.wrapper.JsonOutputDialog;
import com.wang.dialog.wrapper.ListDialogWrapper;
import com.wang.dialog.wrapper.SampleDialogWrapper;
import com.wang.editor.text.MyEditorTextField;
import com.wang.file.FileChooserDialogWrapper;
import com.wang.file.MyFileChooser;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class TestDialogAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        // 项目不为空并且打开了一个文件才会启这个 AnAction
        Project project = e.getProject();
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        e.getPresentation().setEnabledAndVisible(project != null && editor != null);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        VirtualFile data = e.getData(PlatformDataKeys.VIRTUAL_FILE);
    }

    public void dialog(AnActionEvent e) {
        String name = Objects.requireNonNull(e.getProject()).getName();
        Project project = e.getData(PlatformDataKeys.PROJECT);
        Messages.showInputDialog(project, String.format("What is your %s?", name), "Input Your Name", Messages.getQuestionIcon());
    }

    public void messageCheckBox(AnActionEvent e) {

    }

    public void notifier(AnActionEvent e) {
        MyNotifier.notifyUser(e.getProject(), "你好啊姚畅");
    }

    public void fileChoose(AnActionEvent e) {
        MyFileChooser.useTreeFileChooser(e.getProject());
    }

    public void editorTest(AnActionEvent e) {
        new JsonOutputDialog(e.getProject()).showAndGet();
    }

    public void jbList(AnActionEvent e) {
        new ListDialogWrapper().showAndGet();
    }
}
