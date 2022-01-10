package com.food.service;

import com.food.po.Foods;

import java.util.List;

public interface FoodsService {

    /**
     * @Description 查询所有餐饮商品信息
     * @author maGuoWei
     * @date 2021/11/24 11:36
     * @return: java.util.List<com.food.po.Foods>
     */
    List<Foods> selectAllFoods();

    /**
     * @Description 查询所有餐饮商品信息,并按月销量排序
     * @author maGuoWei
     * @date 2021/11/26 20:38
     * @return: java.util.List<com.food.po.Foods>
     */
    List<Foods> selectAllFoodsOrderByCount();

    /**
     * @Description 按id查询餐饮商品信息
     * @author maGuoWei
     * @date 2021/11/24 12:36
     * @param id:
     * @return: com.food.po.Foods
     */
    Foods selectFoodsById(Integer id);

    /**
     * @Description 按名称查询餐饮商品信息
     * @author maGuoWei
     * @date 2021/11/24 12:46
     * @param name:
     * @return: com.food.po.Foods
     */
    Foods selectFoodsByName(String name);

    /**
     * @Description 添加餐饮商品信息
     * @author maGuoWei
     * @date 2021/11/25 20:17
     * @param foods:
     * @return: int
     */
    int addFoods(Foods foods);

    /**
     * @Description 修改餐饮商品信息
     * @author maGuoWei
     * @date 2021/11/26 15:30
     * @param foods:
     * @return: int
     */
    int ModifyFoods(Foods foods);

    /**
     * @Description 根据id删除餐饮商品信息
     * @author maGuoWei
     * @date 2021/11/26 16:26
     * @param id:
     * @return: int
     */
    int deleteFoodsById(Integer id);

}
