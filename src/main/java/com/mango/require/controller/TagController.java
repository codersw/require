package com.mango.require.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import com.mango.require.service.ITagService;
import com.mango.require.model.Tag;
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import com.mango.require.model.common.PageResponse;
import javax.annotation.Resource;

/**
 * <p>
 * 标签信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Api(value = "标签信息接口", tags = {"标签信息接口"})
@Slf4j
@RestController
@RequestMapping("/tag")
public class TagController {

     @Resource
     private ITagService tagService;

     /**
      * 标签信息列表
      * @param tag 标签信息
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "标签信息列表", notes = "标签信息列表")
     @PreAuthorize("hasAuthority('tag:view')")
     @GetMapping
     public Result list(Tag tag, PageRequest pageRequest) {
          QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
          //TODO 设置查询条件

          //排序
          if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
               queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
          }
          Page<Tag> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
          IPage<Tag> tagPage = tagService.page(page, queryWrapper);
          return ResultGenerator.genSuccessResult(PageResponse.<Tag>builder().list(tagPage.getRecords()).total(tagPage.getTotal()).build());
     }

     /**
      * 标签信息新增
      * @param tag 标签信息
      * @return Result
      */
     @ApiOperation(value = "标签信息新增", notes = "标签信息新增")
     @PreAuthorize("hasAuthority('tag:add')")
     @PostMapping
     public Result add(Tag tag) {
          return ResultGenerator.genSuccessResult(tagService.save(tag));
     }

     /**
      * 标签信息删除
      * @param id 标签信息主键
      * @return Result
      */
     @ApiOperation(value = "标签信息删除", notes = "标签信息删除")
     @PreAuthorize("hasAuthority('tag:delete')")
     @DeleteMapping("/{id: \\d+}")
     public Result delete(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(tagService.removeById(id));
     }

     /**
      * 标签信息修改
      * @param tag 标签信息
      * @return Result
      */
     @ApiOperation(value = "标签信息修改", notes = "标签信息修改")
     @PreAuthorize("hasAuthority('tag:update')")
     @PutMapping
     public Result update(Tag tag) {
          return ResultGenerator.genSuccessResult(tagService.updateById(tag));
     }

     /**
      * 标签信息详情
      * @param id 标签信息主键
      * @return Result
      */
     @ApiOperation(value = "标签信息详情", notes = "标签信息详情")
     @PreAuthorize("hasAuthority('tag:view')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
          return ResultGenerator.genSuccessResult(tagService.getById(id));
     }
}