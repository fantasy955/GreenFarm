package edu.cn.green_farm.mapper;

import edu.cn.green_farm.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 添加评论
     *
     * @param comment 待保存的评论
     * @return 受影响的行数
     */
    public Integer add(Comment comment);

    /**
     * 通过id查找评论
     *
     * @param id 评论id
     * @return 评论
     */
    public Comment findById(Integer id);

    /**
     * 查找农产品的所有评论
     *
     * @param productId 农产品id
     * @return 该农产品的所有评论
     */
    public List<Comment> findByProductId(Integer productId);

    /**
     * 通过uid查找用户的评论
     *
     * @param uid 用户的id
     * @return 评论
     */
    public List<Comment> findByUid(Integer uid);

    /**
     * 通过评论id删除评论
     *
     * @param id 农产品id
     * @return 受影响的行数
     */
    public Integer deleteById(Integer id);

    /**
     * 删除农产品的所有评论
     *
     * @param productId 农产品id
     * @return 受影响的行数
     */
    public Integer deleteByProductId(Integer productId);

    /**
     * 删除用户的所有评论
     *
     * @param uid 用户的id
     * @return 评论
     */
    public Integer deleteByUid(Integer uid);
}
