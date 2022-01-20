package com.amazon.core;

import com.amazon.common.CommonConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan
@Import(CommonConfig.class)
public class CoreConfig {
}
