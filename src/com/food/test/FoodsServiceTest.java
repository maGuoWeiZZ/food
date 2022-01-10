package com.food.test;

import com.food.po.Foods;
import com.food.service.impl.FoodsServiceImpl;
import org.junit.Test;

import java.util.List;

public class FoodsServiceTest {

    private FoodsServiceImpl foodsService = new FoodsServiceImpl();

    @Test
    public void selectAllFoods() {
        List<Foods> foods = foodsService.selectAllFoods();
        System.out.println(foods);
    }

    @Test
    public void selectFoodsById() {
        Foods foods = foodsService.selectFoodsById(1);
        System.out.println(foods);
    }

    @Test
    public void selectFoodsByName() {
        Foods foods = foodsService.selectFoodsByName("蛋炒饭");
        System.out.println(foods);
    }

    @Test
    public void addFoods() {
        Foods foods = new Foods(null, "兰州牛肉面", "主食", 7.0, "已下架", 0);
        int i = foodsService.addFoods(foods);
        if (i > 0) {
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }

    @Test
    public void ModifyFoods() {
        Foods foods = new Foods(5, "宫保鸡丁", "菜品", 39.8, "在售", 65);
        int i = foodsService.ModifyFoods(foods);
        if (i > 0) {
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }

    @Test
    public void deleteFoodsById() {
        int i = foodsService.deleteFoodsById(7);
        if (i > 0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void selectAllFoodsOrderByCount() {
        List<Foods> foodsList = foodsService.selectAllFoodsOrderByCount();
        for (Foods foods : foodsList) {
            System.out.println(foods);
        }
    }
}
