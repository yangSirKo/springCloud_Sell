package com.ccyang.apigateway.utils;

import com.ccyang.apigateway.vo.ResultVO;
import com.ccyang.user.server.enums.ResultEnum;
import com.ccyang.user.server.vo.ResultVO;

/**
 * @author ccyang
 * @date 2018/7/10 20:01
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("success");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("success");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMessage(resultEnum.getMessage());
        return resultVO;
    }

}
