package com.food.service.impl;

import com.food.dao.impl.FoodsDaoImpl;
import com.food.po.Foods;
import com.food.service.FoodsService;

import java.util.List;

public class FoodsServiceImpl implements FoodsService {

    private FoodsDaoImpl foodsDao = new FoodsDaoImpl();

    @Override
    public List<Foods> selectAllFoods() {
        List<Foods> foods = foodsDao.selectAllFoods();
        return foods;
    }

    @Override
    public List<Foods> selectAllFoodsOrderByCount() {
        List<Foods> foods = foodsDao.selectAllFoodsWithCount();
        return foods;
    }

    @Override
    public Foods selectFoodsById(Integer id) {
        Foods foods = foodsDao.selectFoodsById(id);
        return foods;
    }

    @Override
    public Foods selectFoodsByName(String name) {
        Foods foods = foodsDao.selectFoodsByName(name);
        return foods;
    }

    @Override
    public int addFoods(Foods foods) {
        int i = foodsDao.addFood(foods);
        return i;
    }

    @Override
    public int ModifyFoods(Foods foods) {
        int i = foodsDao.updateFood(foods);
        return i;
    }

    @Override
    public int deleteFoodsById(Integer id) {
        int i = foodsDao.deleteFoodById(id);
        return i;
    }
}
