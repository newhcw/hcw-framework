package cn.hcw.dubbo.provider.component;

import lombok.Data;

@Data
public class UserSession {

    private String api_version;
    private int terminal_type=0;
    private String client_id;



}
