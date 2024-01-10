package com.github.selfmadeboy.aihelper.window;

import com.github.selfmadeboy.aihelper.MyBundle;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class AIHelperWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        MyToolWindow myToolWindow = new MyToolWindow(toolWindow);
        Content content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), "111", true);
        toolWindow.getContentManager().addContent(content);
        List<AnAction> actionList = new ArrayList<>();

        actionList.add(new DumbAwareAction(() -> "设置",AllIcons.General.Settings) {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                ShowSettingsUtil.getInstance().showSettingsDialog(e.getProject());
            }
        });
        toolWindow.setTitleActions(actionList);
    }


    public class MyToolWindow {


        public MyToolWindow(ToolWindow toolWindow) {

        }

        public JComponent getContent() {
            JBPanel<JBPanel<?>> panel = new JBPanel<>();
            JBLabel label = new JBLabel(MyBundle.message("randomLabel", "?"));

            panel.add(label);
            JButton button = new JButton(MyBundle.message("shuffle"));
            button.addActionListener(e -> {
                // 假设 MyProjectService 类提供了 getRandomNumber() 方法来获取随机数。
                label.setText(MyBundle.message("randomLabel", System.currentTimeMillis()));
            });
            panel.add(button);

            return panel;
        }
    }

}
