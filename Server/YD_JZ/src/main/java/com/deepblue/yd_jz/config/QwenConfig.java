package com.deepblue.yd_jz.config;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.multimodalconversation.MultiModalConversation;
import com.alibaba.dashscope.aigc.multimodalconversation.MultiModalConversationParam;
import com.alibaba.dashscope.aigc.multimodalconversation.MultiModalConversationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.MultiModalMessage;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.exception.UploadFileException;
import com.deepblue.yd_jz.utils.QwenBean;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rockyshen
 * @date 2025/2/14 22:51
 * 通义千问配置类，返回一个QwenBean，具备调用AI的能力
 * API-Key通过yml配置文件的方式传递
 */
@Configuration
@ConfigurationProperties(prefix = "qwen.client")
@Data
public class QwenConfig {
    private String apiKey;

    @Bean
    public QwenBean qwenBean() {
        QwenBean qwenBean = new QwenBean(apiKey);
        return qwenBean;
    }
}

