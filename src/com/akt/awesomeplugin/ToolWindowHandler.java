package com.akt.awesomeplugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolWindowHandler implements ToolWindowFactory {
    private JPanel toolWindowContent;
    private JTextField txtName;
    private JButton btnGo;
    private JLabel lblHello;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(toolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);

        StorageHelper storageHelper = StorageHelper.getInstance(project);
        StorageHelper.State mState = storageHelper.getState();

        txtName.setText(mState.name);
        lblHello.setText("Hello " + mState.name + " o/");

        btnGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                lblHello.setText("Hello " + name + " o/");
                mState.name = name;
            }
        });
    }
}
