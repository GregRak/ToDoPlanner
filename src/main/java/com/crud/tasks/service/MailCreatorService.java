package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.AppInfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private AppInfoConfig appInfoConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("app_name", appInfoConfig.getInfoAppName());
        context.setVariable("company_name", appInfoConfig.getInfoCompanyName());
        context.setVariable("company_email", appInfoConfig.getInfoCompanyEmail());
        context.setVariable("company_phone", appInfoConfig.getInfoCompanyPhone());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
