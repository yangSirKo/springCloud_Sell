package com.ccyang.order.server.utils;

import com.ccyang.order.server.vo.ResultVO;

/**
 * @author ccyang
 * @date 2018/7/1 11:29
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMassage("success");
        resultVO.setData(object);
        return resultVO;
    }

}
