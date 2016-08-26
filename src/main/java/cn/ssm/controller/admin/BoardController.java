package cn.ssm.controller.admin;

import cn.ssm.model.Board;
import cn.ssm.service.BoardService;
import cn.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/8/26.
 */

@RequestMapping(value ="/board")
@Controller
public class BoardController  extends BaseAdminController<Board, String>{

    @Autowired
    private BoardService boardService;


    @RequestMapping("updateEditor")
    public String updateEditor(Board board){
        this.boardService.updateEditor(board);

        return  "redirect:/board/selectTitleByPage";
    }

    @RequestMapping("showBoard")
    public String showBoard(Long id ,HttpServletRequest request){
        Board board = this.boardService.showBoard(id);
        request.setAttribute("Board" , board);
        return   "/Boards";
    }

    @RequestMapping("delete")
    public String deleteBoard(Long id){
        this.boardService.deleteByPrimaryKey(id) ;
        return "redirect:/board/selectTitleByPage" ;
    }

    @RequestMapping("showBoards")
    public String showBoards(Long id ,HttpServletRequest request){
        Board board = this.boardService.showBoard(id);
        request.setAttribute("Boards" , board);
        return   admin_dir + "admin/showBoards";
    }

    @RequestMapping("update")
    public String updateBoards(Long id ,HttpServletRequest request){
        Board board = this.boardService.showBoard(id);
        request.setAttribute("Boards" , board);
        return   admin_dir + "admin/updateBoard";
    }

    @RequestMapping("add")
    public String add(Board board) {
        this.boardService.add(board);
        return "redirect:/admin/themes";

    }



    @RequestMapping("/selectTitleByPage")
    public String selectTitleByPage(HttpServletRequest request, HttpServletResponse response) {

        Page<Board> pageList = null;


        pageList  = boardService.selectTitleByPage(request, response);

        request.setAttribute("pageList", pageList);

        request.setAttribute("url",  "selectTitleByPage");


        return  admin_dir + "admin/showBoard";
    }
}
