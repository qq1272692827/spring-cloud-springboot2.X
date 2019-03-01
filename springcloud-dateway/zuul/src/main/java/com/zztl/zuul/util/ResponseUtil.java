package com.zztl.zuul.util;



import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title:
 * @Package: ph.infinity.zuul.util
 * @Description:
 * @Author dandi
 * @Date 2018/3/21 15:30
 */
public class ResponseUtil {


    /**
     * 返回信息
     */
    public synchronized static void responseOutput(HttpServletResponse response, int statusCode, String message) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(0);
        ServletOutputStream out = null;
        try {
//            Message mess = new Message(statusCode, message, null);
//            JSONObject json = (JSONObject) JSON.toJSON(mess);
//            out = response.getOutputStream();
//            out.print(json.toJSONString());

            out = response.getOutputStream();
            out.print(message);
        } catch (Exception e) {
            try {
                response.sendError(0);
            } catch (IOException e1) {
                e.printStackTrace();
            }
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
