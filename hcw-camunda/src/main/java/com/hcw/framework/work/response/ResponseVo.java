package com.hcw.framework.work.response;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {

    private int code = 0;
    private String message;
    private Object data;
}
