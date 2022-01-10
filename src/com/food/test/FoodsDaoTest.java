package com.food.test;


import com.food.dao.impl.FoodsDaoImpl;
import com.food.po.Foods;
import org.junit.Test;

import java.util.List;

public class FoodsDaoTest {

    private FoodsDaoImpl foodsDao = new FoodsDaoImpl();

    @Test
    public void selectAllFoods() {
        List<Foods> foods = foodsDao.selectAllFoods();
        System.out.println(foods);
    }

    @Test
    public void selectFoodsById() {
        Foods foods = foodsDao.selectFoodsById(1);
        System.out.println(foods);
    }

    @Test
    public void selectFoodsByName() {
        Foods foods = foodsDao.selectFoodsByName("可乐");
        System.out.println(foods);
    }

    @Test
    public void addFood() {
        Foods foods = new Foods(null, "2", "2", 2.00, "222", 2);
        int i = foodsDao.addFood(foods);
        if (i > 0) {
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void deleteFoodById() {
        int i = foodsDao.deleteFoodById(2);
        if (i > 0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void updateFood() {
        Foods foods = new Foods(3, "3", "3", 3.00, "3", 3);
        int i = foodsDao.updateFood(foods);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }


}
