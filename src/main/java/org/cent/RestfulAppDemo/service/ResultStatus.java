package org.cent.RestfulAppDemo.service;

/**
 * 结果状态码及描述枚举类
 * @author cent
 * @version 1.0
 */
public enum ResultStatus {
    // 成功状态
    SUCCESS(0, "请求成功！"),
    ERROR(-1, "非法：无效数字。"),
    WARN(-2, "无效：数值小于0。"),
    MISS(-3, "非法：缺少请求参数"),
    UNKNOWN(-4, "未知异常，请稍后再试！");

    private int code;
    private String msg;

    /**
     * 构造结果状态码及描述
     * @param code 状态码
     * @param msg 结果描述
     */
    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
