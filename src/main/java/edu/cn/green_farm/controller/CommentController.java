package edu.cn.green_farm.controller;

import edu.cn.green_farm.entity.Comment;
import edu.cn.green_farm.service.ICommentService;
import edu.cn.green_farm.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    private ICommentService commentService;

    @PostMapping("/save")
    public ResponseResult<Void> add(Comment comment, HttpSession session) {
        try {
            comment.setUid(getUidFromSession(session));
        } catch (Exception e) {
            return new ResponseResult<>(500, "请先登录！");
        }
        commentService.add(comment);
        return new ResponseResult<>(SUCCESS);
    }

    @PostMapping("/findById/{id}")
    public ResponseResult<Comment> findById(@PathVariable("id") Integer id, HttpSession session) {
        Comment comment = commentService.findById(id);
        return new ResponseResult<Comment>(SUCCESS, comment);
    }

    @PostMapping("/findByProductId/{productId}")
    public ResponseResult<List<Comment>> findByProductId(@PathVariable("productId") Integer productId, HttpSession session) {
        List<Comment> commentList = commentService.findByProductId(productId);
        return new ResponseResult<List<Comment>>(SUCCESS, commentList);
    }

    @PostMapping("/findByUid/{uid}")
    public ResponseResult<List<Comment>> findByUid(@PathVariable("uid") Integer uid, HttpSession session) {
        List<Comment> commentList = commentService.findByUid(uid);
        return new ResponseResult<List<Comment>>(SUCCESS, commentList);
    }

    @PostMapping("/deleteById/{id}")
    public ResponseResult<Void> deleteById(@PathVariable("id") Integer id, HttpSession session) {
        commentService.deleteById(id);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/deleteByProductId/{productId}")
    public ResponseResult<Void> deleteByProductId(@PathVariable("productId") Integer productId, HttpSession session) {
        commentService.deleteByProductId(productId);
        return new ResponseResult<Void>(SUCCESS);
    }

    @PostMapping("/deleteByUid/{uid}")
    public ResponseResult<Void> deleteByUid(@PathVariable("uid") Integer uid, HttpSession session) {
        commentService.deleteByUid(uid);
        return new ResponseResult<Void>(SUCCESS);
    }
}
