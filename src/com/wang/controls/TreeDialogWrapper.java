package com.wang.controls;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.TreeSpeedSearch;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class TreeDialogWrapper extends DialogWrapper {

    private Tree tree;
    private DefaultTreeModel model;

    public TreeDialogWrapper() {
        super(true);
        init();
        setTitle("Tree");
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        DefaultMutableTreeNode child1Leaf1 = new DefaultMutableTreeNode();
        child1Leaf1.setUserObject("child1Leaf1");

        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode();
        child1Leaf1.add(child1);
        child1.setUserObject("child1");

        DefaultMutableTreeNode child1Leaf2 = new DefaultMutableTreeNode();
        child1Leaf2.setUserObject("child1Leaf2");

        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode();
//        child2.add(child1Leaf2);
        child1Leaf2.add(child2);
        child2.setUserObject("child2");

        DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        root.setUserObject("root");
        root.add(child1Leaf1);
        root.add(child1Leaf2);

        model = new DefaultTreeModel(root);
        tree = new Tree(model);
        tree.setDragEnabled(true);
        tree.setExpandableItemsEnabled(true);

        new TreeSpeedSearch(tree);
        ColoredTreeCellRenderer coloredTreeCellRenderer = new ColoredTreeCellRenderer() {
            @Override
            public void customizeCellRenderer(@NotNull JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                append(value + "-suffix");
            }
        };

        tree.setCellRenderer(coloredTreeCellRenderer);

        ToolbarDecorator toolbarDecorator = ToolbarDecorator.createDecorator(tree);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(toolbarDecorator.createPanel(), BorderLayout.CENTER);
        return panel;
    }
}
