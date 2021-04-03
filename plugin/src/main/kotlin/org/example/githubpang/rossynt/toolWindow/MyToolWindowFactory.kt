package org.example.githubpang.rossynt.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import org.example.githubpang.rossynt.services.BackendService


class MyToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        require(toolWindow.id == MyToolWindow.TOOL_WINDOW_ID)

        project.service<BackendService>() // Load backend service.

        val myToolWindow = MyToolWindow(project.messageBus)
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content = contentFactory.createContent(myToolWindow.content, "", false)
        toolWindow.contentManager.addContent(content)
    }
}
