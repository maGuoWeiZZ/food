package com.food.dao;

import com.food.po.Foods;

import java.util.List;

public interface FoodsDao {

    /**
     * @Description 查询所有餐饮信息
     * @author maGuoWei
     * @date 2021/11/23 22:46
     * @return: java.util.List<com.food.po.Foods>
     */
    List<Foods> selectAllFoods();

    /**
     * @Description 查询所有餐饮信息，并按销量排序
     * @author maGuoWei
     * @date 2021/11/26 20:30
     * @return: java.util.List<com.food.po.Foods>
     */
    List<Foods> selectAllFoodsWithCount();

    /**
     * @Description 按id查询餐饮信息
     * @author maGuoWei
     * @date 2021/11/23 22:46
     * @param id:
     * @return: com.food.po.Foods
     */
    Foods selectFoodsById(Integer id);

    /**
     * @Description 按名称查询餐饮信息
     * @author maGuoWei
     * @date 2021/11/24 12:49
     * @param name:
     * @return: com.food.po.Foods
     */
    Foods selectFoodsByName(String name);

    /**
     * @Description 添加餐饮信息
     * @author maGuoWei
     * @date 2021/11/23 22:47
     * @param foods:
     * @return: int
     */
    int addFood(Foods foods);

    /**
     * @Description 按id删除餐饮信息
     * @author maGuoWei
     * @date 2021/11/23 22:47
     * @param id:
     * @return: int
     */
    int deleteFoodById(Integer id);

    /**
     * @Description 修改餐饮信息
     * @author maGuoWei
     * @date 2021/11/23 22:48
     * @param foods:
     * @return: int
     */
    int updateFood(Foods foods);


}
