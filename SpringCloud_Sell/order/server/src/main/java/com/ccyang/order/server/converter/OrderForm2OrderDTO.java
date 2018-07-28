package com.ccyang.order.server.converter;

import com.ccyang.order.server.dataobject.OrderDetail;
import com.ccyang.order.server.dto.OrderDTO;
import com.ccyang.order.server.enums.ResultEnum;
import com.ccyang.order.server.exception.OrderException;
import com.ccyang.order.server.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccyang
 * @date 2018/7/1 11:07
 */
@Slf4j
public class OrderForm2OrderDTO {

    /**
     * orderForm -> OrderDTO
     * @param orderForm
     * @return
     */
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        }catch (Exception e){
            log.error("【json 转换错误】，string = {}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

}
