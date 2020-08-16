package com.demo;

import com.taobao.api.internal.mapping.ApiField;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DingConfig {
    private String hookUrl;
    private String keyword;
    private String secret;

    private List<String> atMobiles;

    private Boolean isAtAll;


}
