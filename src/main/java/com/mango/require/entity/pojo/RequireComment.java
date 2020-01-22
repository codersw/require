package com.mango.require.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * <p>
 * 需求评论
 * </p>
 *
 * @author swen
 * @since 2020-01-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_require_comment")
@ApiModel(value="RequireComment对象", description="需求评论")
public class RequireComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论信息")
    @TableId("comment_id")
    private Integer commentId;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "创建人id")
    @TableField("create_user_id")
    private Integer createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("modify_user_id")
    private Integer modifyUserId;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "需求id")
    @TableField("require_id")
    private Integer requireId;

    @ApiModelProperty(value = "是否删除 0未删除 1以删除")
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


}
