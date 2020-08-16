package com.demo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DingConfig {
    private String hookUrl;
    private String keyword;
    private String secret;
}
