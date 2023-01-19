package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardServiceImpl;
import service.IBoardService;
import vo.BoardVO;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Main() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("연결될 주소 jsp").forward(request, response);
//		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		
		System.out.println("page 번호 >> " + request.getParameter("page"));
		
		//게시글 조회 코드를 갖다 넣을 예정
		//===================================================board 정보(리스트 읽어오기)가져오기 START
		
		int currentPage = 1; //현재페이지
		//하드코딩 되어 있지만 currentPage값은 증가한다.
		currentPage = request.getParameter("page") ==null ? 1 : Integer.parseInt(request.getParameter("page")) ;
		
		//서비스 객체 - 메소드연결 - list데이터 가져오기
		IBoardService boardService = BoardServiceImpl.getInstance();
		
		//전체 글 갯수 가져오기
		int countList =  boardService.countList();	//20	
//		System.out.println("넘어온 글 갯수 : " + countList);
		
		//한 화면에 출력할 페이지 수 
		int perPage = 4;
		
		//★한 페이지에 출력할 글 갯수
		int perList = 5;
		
		//전체 페이지 수 = 전체 글 갯수/페이지 당 글 갯수
		int totalPage = (int)Math.ceil((double)countList/(double)perList);
//		System.out.println("전체 페이지 수 : " + totalPage);
		
		//페이지에 표시될 게시글 start ~ end 범위 값
		//start = (currentPage - 1) * perList +1;
		//1페이지 일때 : (1-1)*5+1 = 1  || 2페이지 일때 : (2-1)*5+1 = 6
		//3페이지 일때 : (3-1)*5+1 = 11 || 4페이지 일때 : (4-1)*5+1 = 16
		int start = (currentPage -1) * perList +1; //1
		
		//end = start + perList -1;
		//1페이지 일때 :  1+5-1 = 5   || 2페이지 일때 : 6+5-1 = 10
		//3페이지 일때 : 11+5-1 = 15 || 4페이지 일때 : 16+5-1 = 20
		//5페이지 일떄 : 21+5-1 =25
		int end = start + perList -1; //5
		if(end > countList) end = countList; //전체 글 갯수를 넘어서는 end값을 조절
		
		//★페이지 표시할 startPage ~ endPage 값★
		//startPage = ((currentPage -1) / perPage * perPage) + 1;
		//마지막에 1을 더해주는 것은 1페이지는 현재페이지가 0이 나오기 때문에 0 + 1 = 1로 계산하기 위해 더해줌
		//1페이지 일때 : ((1-1)/4*4)+1 = 1  || 4페이지 일때 : ((4-1)/4*4)+1 = 1
		//3페이지 일때 : ((7-1)/4*4)+1 = 5  || 12페이지 일떄 : ((12-1)/4*4)+1 = 9
		//=>페이지 시작 값이 4페이지 마다 바뀜
		for(int i=1; i<=10; i++) {
//			System.out.println("페이지 시작 값 : " + ((i-1)/ perPage * perPage + 1));
		}
		int startPage = ((currentPage -1) / perPage * perPage) + 1;   

		//endPage = startPage + perPage -1;
		for(int i=1; i<=10; i++) {
//			System.out.println("페이지 끝 값 : " + (startPage + perPage - 1));
		}
		int endPage = startPage + perPage -1;  //4
		
		Map<String, Object> map2 = new HashMap<String, Object>();

//		boardService.boardList(map); //start~end 범위의 리스트 목록 가져오기
		map2.put("start", start);
		map2.put("end", end);
		
		//start ~ end범위 값을 담ㅇ느 map 전달하기
		List<BoardVO> list = boardService.boardList(map2);
		
		//===================================================board 정보(리스트 읽어오기)가져오기 END
		
		//결과
		request.setAttribute("list", list);
        request.setAttribute("sPage", startPage);
        request.setAttribute("ePage", endPage);
        request.setAttribute("cPage", currentPage);
        request.setAttribute("ttPage", totalPage);
		
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
