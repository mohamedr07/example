package com.example.microservices.metadata.i18n;

import com.broadleafcommerce.common.extension.i18n.MessagesDefaultBasenameAddingPostProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.Set;

public class I18nAutoConfiguration {
    @Bean
    public MessagesDefaultBasenameAddingPostProcessor vfeMessageSourcePostProcessor() {
        return new VFEMessagesDefaultBasenameAddingPostProcessor();
    }

    @RequiredArgsConstructor
    protected static class VFEMessagesDefaultBasenameAddingPostProcessor extends MessagesDefaultBasenameAddingPostProcessor {
        @Override
        protected void addMessagesDefaultBasenames(Set<String> basenames) {
            basenames.add("messages/process-info");
        }
    }
}
