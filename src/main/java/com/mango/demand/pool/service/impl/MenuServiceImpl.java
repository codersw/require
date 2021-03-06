package com.mango.demand.pool.service.impl;

import com.mango.demand.pool.mapper.MenuMapper;
import com.mango.demand.pool.entity.pojo.Menu;
import com.mango.demand.pool.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public String findUserPermissions(Integer userId) {
        List<Menu> menus = baseMapper.getMenus(userId);
        return menus.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
