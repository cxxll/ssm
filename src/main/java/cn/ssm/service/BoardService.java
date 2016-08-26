package cn.ssm.service;

import cn.ssm.model.Board;
import cn.ssm.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/26.
 */
public interface BoardService  extends BaseService<Board>{

    int updateEditor(Board board);

    Board showBoard(Long id);

    Page<Board> selectTitleByPage(HttpServletRequest request, HttpServletResponse response);

    int add(Board board);
}
