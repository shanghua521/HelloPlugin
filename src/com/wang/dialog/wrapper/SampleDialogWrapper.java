package com.wang.dialog.wrapper;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.ValidationInfo;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SampleDialogWrapper extends DialogWrapper {
    private JTextField inputTextField;

    private DialogWrapperExitAction exitAction;
    private CustomOkAction okAction;

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
        inputTextField = new JTextField();
        dialogPanel.add(inputTextField, BorderLayout.NORTH);
        return dialogPanel;
    }

    @Override
    protected @Nullable
    ValidationInfo doValidate() {
        String text = inputTextField.getText();
        return StringUtils.isNotBlank(text) ? null : new ValidationInfo("校验不通过");
    }

    @Override
    protected Action[] createActions() {
        exitAction = new DialogWrapperExitAction("自定义 cancel 按钮", CANCEL_EXIT_CODE);
        okAction = new CustomOkAction();
        okAction.putValue(DialogWrapper.DEFAULT_ACTION, true);
        return new Action[]{okAction, exitAction};
    }


    protected class CustomOkAction extends DialogWrapperAction {

        protected CustomOkAction() {
            super("自定义ok按钮");
        }

        @Override
        protected void doAction(ActionEvent e) {
            ValidationInfo validationInfo = doValidate();
            if (validationInfo != null) {
                Messages.showMessageDialog(validationInfo.message, "校验不通过", Messages.getInformationIcon());
            } else {
                close(CANCEL_EXIT_CODE);
            }
        }
    }
}
