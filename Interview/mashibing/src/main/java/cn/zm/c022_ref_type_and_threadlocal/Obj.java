package cn.zm.c022_ref_type_and_threadlocal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Obj {

    @Override
    protected void finalize() throws Throwable {
        log.info("Obj instance finalize");
    }
}
