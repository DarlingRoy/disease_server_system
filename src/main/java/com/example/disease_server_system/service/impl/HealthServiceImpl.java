package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.entity.Health;
import com.example.disease_server_system.mapper.HealthDao;
import com.example.disease_server_system.service.HealthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 健康状况记录表(Health)表服务实现类
 *
 * @author makejava
 * @since 2020-05-23 10:47:43
 */
@Service("healthService")
public class HealthServiceImpl implements HealthService {
    @Resource
    private HealthDao healthDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Health queryById(Integer id) {
        return this.healthDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Health> queryAllByLimit(int offset, int limit) {
        return this.healthDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    @Override
    public Health insert(Health health) {
        this.healthDao.insert(health);
        return health;
    }

    /**
     * 修改数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    @Override
    public Health update(Health health) {
        this.healthDao.update(health);
        return this.queryById(health.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.healthDao.deleteById(id) > 0;
    }
}