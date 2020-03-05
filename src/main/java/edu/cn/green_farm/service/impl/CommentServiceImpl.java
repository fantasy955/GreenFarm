package edu.cn.green_farm.service.impl;

import edu.cn.green_farm.entity.Comment;
import edu.cn.green_farm.entity.FarmProduct;
import edu.cn.green_farm.entity.User;
import edu.cn.green_farm.mapper.CommentMapper;
import edu.cn.green_farm.mapper.FarmProductMapper;
import edu.cn.green_farm.mapper.UserMapper;
import edu.cn.green_farm.service.ICommentService;
import edu.cn.green_farm.service.exception.DeleteException;
import edu.cn.green_farm.service.exception.InsertException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private FarmProductMapper FarmProductMapper;
    @Resource
    private CommentMapper commentMapper;

    @Override
    public Integer add(Comment comment) throws InsertException {
        User user = userMapper.findById(comment.getUid());
        if (user == null) {
            throw new InsertException("评论失败！请先登录用户账号");
        }
        comment.setCreatedTime(new Date());
        if (comment.getProductId() == null) {
            throw new InsertException("评论失败！请设置评论的农产品Id！");
        }
        FarmProduct farmProduct = FarmProductMapper.findById(comment.getProductId());
        if (farmProduct == null) {
            throw new InsertException("评论失败！设置评论的农产品Id无效！");
        }
        if (comment.getContent() == null || comment.getContent().length() == 0) {
            throw new InsertException("评论失败！请输入评论的内容！");
        }
        return commentMapper.add(comment);
    }

    @Override
    public Comment findById(Integer id) {
        return commentMapper.findById(id);
    }

    @Override
    public List<Comment> findByProductId(Integer productId) {
        return commentMapper.findByProductId(productId);
    }

    @Override
    public List<Comment> findByUid(Integer uid) {
        return commentMapper.findByUid(uid);
    }

    @Override
    public Integer deleteById(Integer id) throws DeleteException {
        Integer rows = commentMapper.deleteById(id);
        if (rows == 0) {
            throw new DeleteException("删除评论失败！删除的评论不存在");
        }
        return rows;
    }

    @Override
    public Integer deleteByProductId(Integer productId) {
        return commentMapper.deleteByProductId(productId);
    }

    @Override
    public Integer deleteByUid(Integer uid) {
        return commentMapper.deleteByUid(uid);
    }
}
