package com.hcw.framework.design.pattern.chain;

import lombok.Data;
import lombok.Setter;

@Data
public abstract  class Handle {

    private Handle nextHandle;

    public  abstract void  handle(Request request);

}
