package com.deepblue.yd_jz.service;

import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.exception.UploadFileException;
import com.deepblue.yd_jz.dto.FlowAddRequestDto;
import com.deepblue.yd_jz.exception.BusinessException;
import com.deepblue.yd_jz.utils.QwenUtils;
import com.deepblue.yd_jz.utils.StatusCodeEnum;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rockyshen
 * @date 2025/2/13 13:12
 */

@Service
public class AiAnalysisServiceImpl implements AiAnalysisService {
    @Autowired
    private QwenUtils qwenUtils;

    // controller接受图片，调用阿里通义大模型，分析账单，封装成flowAddRequest实体类
    @Override
    public List<FlowAddRequestDto> analyzeFlowByAi(String filePath) throws NoApiKeyException, UploadFileException, InputRequiredException {
        String flowInfo = null;
        flowInfo = qwenUtils.ocrConversationCall(filePath);
        GenerationResult result = qwenUtils.callWithMessage(flowInfo);
        // 从响应结果中，解析处JSON，然后解析成FlowAddRequestDto对象
        String content = result.getOutput().getChoices().get(0).getMessage().getContent();
        // 根据Ai答复结果，提取JSON
        String json = extractJson(content);
        // json解析成
        Gson gson = new Gson();
        Type listType = new TypeToken<List<FlowAddRequestDto>>(){}.getType();
        return gson.fromJson(json, listType);
    }

    public String extractJson(String input) {
        // 定义匹配 JSON 数组的正则表达式
        String jsonArrayPattern = "\\[\\s*\\{.*?\\}\\s*\\]";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(jsonArrayPattern, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);

        // 寻找匹配部分并返回
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null; // 如果没有找到 JSON，则返回 null 或其他提示信息
        }
    }


}
