package com.boot.my.thumbsup;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.my.thumbsup.domains.Board.domain.BoardEntity;
import com.boot.my.thumbsup.domains.Board.domain.BoardRepository;
import com.boot.my.thumbsup.domains.Board.service.BoardService;

@Controller
public class TestController {
	@Autowired
	public BoardService boardService;
	@Autowired
	public BoardRepository boardRepository;
	
    @GetMapping("/test")
    public String test(Model model) {
    	return "common/test";
    }
    
    /*
     * 관리자페이지 index
     */
    @GetMapping("/index")
    public String index(
    		Model model) {
    	boardRepository.deleteAll();
    	boardService.save(new BoardEntity("Ramesh", "Fadatare", "ramesh@gmail.com"));
    	boardService.save(new BoardEntity("Tom", "Cruise", "tom@gmail.com"));
    	boardService.save(new BoardEntity("John", "Cena", "john@gmail.com"));
    	boardService.save(new BoardEntity("tony", "stark", "stark@gmail.com"));


        //List <BoardEntity> boards = boardService.findAll();
        //boards.forEach(employee -> System.out.println(employee.toString()));
        
    	Iterable <BoardEntity> boardList = boardRepository.findAll();
    			
			for(BoardEntity i : boardList ){
				System.out.println(i.toString());
			}

        model.addAttribute("board_list",boardRepository.findAll());
    	model.addAttribute("test","test");
    	return "index";
    }

    @GetMapping("/ui-buttons")
    public String uiButtons(Model model) {
    	return "ui-buttons";
    }
    @GetMapping("/ui-badges")
    public String uiBadges(Model model) {
    	return "ui-badges";
    }
    @GetMapping("/ui-tabs")
    public String uiTabs(Model model) {
    	return "ui-tabs";
    }
    @GetMapping("/ui-cards")
    public String uiCards(Model model) {
    	return "ui-cards";
    }
    @GetMapping("/ui-alerts")
    public String uiAlerts(Model model) {
    	return "ui-alerts";
    }
    @GetMapping("/ui-progressbar")
    public String uiProgressbar(Model model) {
    	return "ui-progressbar";
    }
    @GetMapping("/ui-modals")
    public String uiModals(Model model) {
    	return "ui-modals";
    }
    @GetMapping("/ui-switches")
    public String uiSwitches(Model model) {
    	return "ui-switches";
    }
    @GetMapping("/ui-grids")
    public String uiGrids(Model model) {
    	return "ui-grids";
    }
    @GetMapping("/ui-typgraphy")
    public String uiTyypgraphy(Model model) {
    	return "ui-typgraphy";
    }
    @GetMapping("/tables-basic")
    public String tablesBasic(Model model) {
    	return "tables-basic";
    }
    @GetMapping("/tables-data")
    public String tablesData(Model model) {
    	return "tables-data";
    }
    @GetMapping("/forms-basic")
    public String formsBasic(Model model) {
    	return "forms-basic";
    }
    @GetMapping("/forms-advanced")
    public String formsAdvanced(Model model) {
    	return "forms-advanced";
    }
    @GetMapping("/font-fontawesome")
    public String fontFontawesome(Model model) {
    	return "font-fontawesome";
    }
    @GetMapping("/font-themify")
    public String fontThemify(Model model) {
    	return "font-themify";
    }
    @GetMapping("/charts-chartjs")
    public String chartsChartjs(Model model) {
    	return "charts-chartjs";
    }
    @GetMapping("/charts-flot")
    public String chartsFlot(Model model) {
    	return "charts-flot";
    }
    @GetMapping("/charts-peity")
    public String chartsPeity(Model model) {
    	return "charts-peity";
    }
    @GetMapping("/maps-gmap")
    public String mapsGmap(Model model) {
    	return "maps-gmap";
    }
    @GetMapping("/maps-vector")
    public String mapsVector(Model model) {
    	return "maps-vector";
    }
    @GetMapping("/page-login")
    public String pageLogin(Model model) {
    	return "page-login";
    }
    @GetMapping("/page-register")
    public String pageRegister(Model model) {
    	return "page-register";
    }
    @GetMapping("/pagesForget")
    public String pagesForget(Model model) {
    	return "pages-forget";
    }
    @GetMapping("/widgets")
    public String widgets(Model model) {
    	return "widgets";
    }
    
    
}
