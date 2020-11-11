package com.xs.micro.es.domain.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangqiuipeng
 * @desc user
 * @date 2020年06月15日17:09:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private Long createTime;
}
