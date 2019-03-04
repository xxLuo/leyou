package com.leyou.service.service;

import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author bystander
 * @date 2018/9/15
 */
public interface CategoryService {


    List<Category> queryCategoryByPid(Long pid);

    List<Category> queryCategoryByIds(List<Long> ids);

    List<Category> queryAllByCid3(Long id);
    /**
     * 保存
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 删除
     * @param id
     */
    void deleteCategory(Long id);

    /**
     * 更新
     * @param category
     */
    void updateCategory(Category category);
    /**
     * 查询当前数据库中最后一条数据
     * @return
     */
    List<Category> queryLast();

}
