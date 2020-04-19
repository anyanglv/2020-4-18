package entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/4/18
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class ReturnResult implements Serializable {

    private Integer code;     //是否成功
    private boolean flag;     //返回码
    private String message;   //返回消息
    private Object data;      //返回查询结果

    public ReturnResult(Integer code, boolean flag, String message) {
        this.code = code;
        this.flag = flag;
        this.message = message;
    }

    public ReturnResult(Integer code, boolean flag, String message, Object data) {
        this.code = code;
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public ReturnResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReturnResult{" +
                "code=" + code +
                ", flag=" + flag +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
