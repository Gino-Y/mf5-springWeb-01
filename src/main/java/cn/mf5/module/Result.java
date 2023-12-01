package cn.mf5.module;

// 该类的作用是用来封装返回的结果，统一返回的格式
public class Result {
    private Integer code; // 状态码 1表示成功，0表示失败

    private String msg; // 提示信息

    private Object data; // 返回的数据

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // 请求成功无返回值参数的方法
    public static Result success(){
        return new Result(1,"",null);
    }

    // 请求成功有返回值参数的方法
    public static Result success(Object data){
        return new Result(1,"",data);
    }

    // 请求失败的方法
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
