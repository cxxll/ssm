package cn.ssm.service.Impl;

import cn.ssm.dao.BoardMapper;
import cn.ssm.model.Board;
import cn.ssm.service.BoardService;
import cn.ssm.util.BaseMapper;
import cn.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
@Service
public class BoardServiceImpl extends BaseServiceImpl<Board>  implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int updateEditor(Board board) {
      return   this.boardMapper.updateEditor(board);
    }

    @Override
    public Board showBoard(Long id) {
        return  this.boardMapper.showBoard(id);
    }

    @Override
    public Page<Board> selectTitleByPage(HttpServletRequest request, HttpServletResponse response) {

        String pageNow = request.getParameter("pageNow");

        Page<Board> page = null;

        List<Board> titles = new ArrayList<Board>();

        int totalCount =  boardMapper.getTitleCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            titles = this.boardMapper.selectTitleByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            titles = this.boardMapper.selectTitleByPage(page.getStartPos(), page.getPageSize());
        }

        request.setAttribute("titles", titles);
        request.setAttribute("page", page);

        page.setRecordList(titles);

        return page;

    }

    @Override
    public int add(Board board) {
        board.setTitle(board.getTitle().trim());
        board.setTextarea(board.getTextarea().trim());
        return  this.boardMapper.insert(board);
    }

    @Override
    protected BaseMapper<Board> getBaseMapper() {
        return boardMapper;
    }
}
