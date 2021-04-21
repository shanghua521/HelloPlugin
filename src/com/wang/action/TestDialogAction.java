package com.wang.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.wang.controls.TreeDialogWrapper;
import com.wang.dialog.wrapper.JsonOutputDialog;
import com.wang.controls.ListDialogWrapper;
import com.wang.file.MyFileChooser;
import org.jetbrains.annotations.NotNull;

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
        jbList(e);
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
//        new ListDialogWrapper().showAndGet();
        new TreeDialogWrapper().showAndGet();
    }
}
