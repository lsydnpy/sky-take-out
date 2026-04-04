package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetMealDishMapper {

    /**
     * 根据菜品id来查询对应的套餐id
     * @param dishId
     * @return
     */
//    @Select("select setmeal_id from set_meal_dish where dish_id in #{dishId}")
    List<Long> getSetMealIdsByDishId(List<Long> dishId);

}
