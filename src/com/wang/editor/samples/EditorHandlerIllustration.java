package com.wang.editor.samples;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class EditorHandlerIllustration extends AnAction {

    static {
        final EditorActionManager actionManager = EditorActionManager.getInstance();
        final TypedAction typedAction = actionManager.getTypedAction();
        typedAction.setupHandler(new MyTypedHandler());
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        final EditorActionManager actionManager = EditorActionManager.getInstance();
        final EditorActionHandler actionHandler = actionManager.getActionHandler(IdeActions.ACTION_EDITOR_CLONE_CARET_BELOW);
        actionHandler.execute(editor, editor.getCaretModel().getPrimaryCaret(), e.getDataContext());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Project project = e.getProject();
        final Editor editor = e.getData(CommonDataKeys.EDITOR);

        boolean menuAllowed = false;
        if (editor != null && project != null) {
            menuAllowed = !editor.getCaretModel().getAllCarets().isEmpty();
        }
        e.getPresentation().setEnabledAndVisible(menuAllowed);
    }
}
