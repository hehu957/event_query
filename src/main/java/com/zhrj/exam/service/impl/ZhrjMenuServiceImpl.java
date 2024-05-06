package com.zhrj.exam.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhrj.exam.entity.ZhrjMenu;
import com.zhrj.exam.mapper.ZhrjMenuMapper;
import com.zhrj.exam.service.IZhrjMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author zhrj
 * @since 2023-03-14
 */
@Service
public class ZhrjMenuServiceImpl extends ServiceImpl<ZhrjMenuMapper, ZhrjMenu> implements IZhrjMenuService {

}
