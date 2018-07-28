package com.ccyang.product.server.controller;

import com.ccyang.product.common.DecreaseStockInput;
import com.ccyang.product.common.ProductInfoOutput;
import com.ccyang.product.server.dataobject.ProductCategory;
import com.ccyang.product.server.dataobject.ProductInfo;
import com.ccyang.product.server.vo.ProductInfoVO;
import com.ccyang.product.server.service.CategoryService;
import com.ccyang.product.server.service.ProductService;
import com.ccyang.product.server.utils.ResultVOUtil;
import com.ccyang.product.server.vo.ProductVO;
import com.ccyang.product.server.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 * create by ccyang
 * 2018-6-30 16:54:32
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type的列表
     * 3. 从数据库查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //1. 获取所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type的列表
        // lambda表达式  取出 productInfoList中的CategoryType 并重新放到一个list中
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        // 3.从数据库查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 4.构造数据: 根据 api文档构造
        List<ProductVO> resultVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            // 一个类目
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            // 遍历出属于某一类目的所有商品
            for(ProductInfo productInfo : productInfoList){
                // 这个 productInfo 是否属于这个 productCategory.getCategoryType() 类目
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVo = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVOList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            resultVOList.add(productVO);
        }
        return ResultVOUtil.success(resultVOList);
    }

    /**
     * 返回商品信息列表( 给订单服务用的 )
     * @param productIdList
     * 注意：参数中使用 @RequestBody， 则必须用 @PostMapping
     */
    @PostMapping("/getProductList")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList){
        log.info("productIdList -------> {} ",productIdList);
        List<ProductInfoOutput> list = productService.findList(productIdList);
        log.info("ProductInfoOutputList ----------> {}", Arrays.toString(list.toArray()));
        return list;
    }

    /**
     * 扣库存
     */
    @PostMapping("/productDecreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productService.decreaseStock(decreaseStockInputList);
    }
}
