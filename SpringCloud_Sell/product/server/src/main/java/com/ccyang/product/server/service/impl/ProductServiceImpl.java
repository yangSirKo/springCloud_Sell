package com.ccyang.product.server.service.impl;

import com.ccyang.product.common.DecreaseStockInput;
import com.ccyang.product.common.ProductInfoOutput;
import com.ccyang.product.server.dataobject.ProductInfo;
import com.ccyang.product.server.enums.ProductStatusEnum;
import com.ccyang.product.server.enums.ResultEnum;
import com.ccyang.product.server.exception.ProductException;
import com.ccyang.product.server.repository.ProductInfoRepository;
import com.ccyang.product.server.service.ProductService;
import com.ccyang.product.server.utils.JsonUtil;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author ccyang
 * @date 2018/6/30 20:30
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e , output);
                    return output;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        // 发送 mq 消息
        List<ProductInfoOutput> productInfoOutputList = decreaseStockProcess(decreaseStockInputList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());

        amqpTemplate.convertAndSend("decreaseStockQueue", JsonUtil.toJson(productInfoOutputList));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for(DecreaseStockInput decreaseStockInput : decreaseStockInputList){
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            // 商品是否存在
            if(!productInfoOptional.isPresent())
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            ProductInfo productInfo = productInfoOptional.get();
            int result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            // 商品库存是否充足
            if(result < 0)
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
