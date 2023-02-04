package util;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @Creator: 阿昇
 * @CreateTime: 2023-01-23 20:33
 * @LastEditTime: 2023-01-23 20:33
 */

public class ResultMap extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultMap(){
        put("code",200);
        put("msg","操作成功");
    }
    public static ResultMap error() {
        return error(201, "操作失败");
    }

    public static ResultMap error(String msg) {
        return error(500, msg);
    }

    public static ResultMap error(int code, String msg) {
        ResultMap resultMap = new ResultMap();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }

    public static ResultMap error(String code, String msg) {
        ResultMap resultMap = new ResultMap();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }

    public static ResultMap ok(String msg) {
        ResultMap resultMap = new ResultMap();
        resultMap.put("msg", msg);
        return resultMap;
    }

    public static ResultMap ok(Map<String, Object> map) {
        ResultMap resultMap = new ResultMap();
        resultMap.putAll(map);
        return resultMap;
    }

    public static ResultMap ok() {
        return new ResultMap();
    }

    @Override
    public ResultMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
