package com.wuda.web.model.constant;

/**
 * 路径常量.
 *
 * @author wuda
 */
public class PathConstant {

    /**
     * 禁止实例化.
     */
    private PathConstant() {

    }

    /**
     * rest接口的path context.
     */
    public final static String PATH_CONTEXT_REST = "/rest";
    /**
     * mvc接口的path context.
     */
    public final static String PATH_CONTEXT_MVC = "/controller";

    public final static String MVC_SYSTEM_CONTROLLER = "/system";
    public final static String MVC_SYSTEM_CONTROLLER_PING = PATH_CONTEXT_MVC + MVC_SYSTEM_CONTROLLER + "/ping";
    public final static String MVC_SYSTEM_CONTROLLER_PING_MYSQL = PATH_CONTEXT_MVC + MVC_SYSTEM_CONTROLLER + "/ping/mysql";

    public final static String REST_SYSTEM_CONTROLLER = "/system";
    public final static String REST_SYSTEM_CONTROLLER_PING = PATH_CONTEXT_REST + REST_SYSTEM_CONTROLLER + "/ping";
    public final static String REST_SYSTEM_CONTROLLER_PING_MYSQL = PATH_CONTEXT_REST + REST_SYSTEM_CONTROLLER + "/ping/mysql";

}
