package com.ccyang.product.server.utils;

import com.ccyang.product.server.vo.ResultVO;

/**
 * @author ccyang
 * @date 2018/6/30 21:55
 */
public class ResultVOUtil {

    /**
     * 商品查询成功
     * @param object
     * @return
     */
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("success");
        resultVO.setData(object);
        return resultVO;
    }

}
