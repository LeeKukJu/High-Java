package board.main;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.DAO.BoardDaoImpl;
import board.VO.BoardVO;
import board.service.BoardServiceImpl;
import board.service.IBoardService;

/*
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 새글 작성			---> insert
		2. 글 삭제			---> delete
		3. 글 수정			---> update
		4. 전체 목록 출력    	---> select
		5. 글 검색                    ---> select
		6. 작업 끝.
	----------------------
	 
	전체 목록 출력, 새글작성, 수정, 삭제, 검색 
	   
	int board_no  -- 번호(자동증가)   int boardNo;        
    String board_title  -- 제목         String boardTitle;  
    String board_writer  -- 작성자     String boardWriter; 
    Date board_date   -- 작성날짜       LocalDateTime boardDate;     
    String board_content  -- 내용      String boardContent;

*/
public class BoadrMain {

	private Scanner scan = new Scanner(System.in);

	private IBoardService boService;

	public BoadrMain() {
		boService = BoardServiceImpl.getInstance();
	}

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 새 게시글 작성");
		System.out.println("  2. 게시글 삭제");
		System.out.println("  3. 게시글 수정");
		System.out.println("  4. 전체 게시글 조회");
		System.out.println("  5. 게시글 검색");
		System.out.println("  6. 프로그램 종료.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		
		try {
			// 1-1. xml설정파일 읽어오기
			Charset charset = Charset.forName("UTF-8"); // 한글처리를 위해
			Resources.setCharset(charset);
			
			Reader rd = 
					Resources.getResourceAsReader("mybatis-config.xml");
			
			// 1-2. Reader객체를 이용하여 SqlSessionFactory객체 생성하기
			BoardDaoImpl.sessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
			// 1-3. Reader 닫기
			rd.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			System.out.println();
			switch (choice) {
			case 1: // 게시글 작성
				insertBoard();
				break;
			case 2: // 게시글 삭제
				deleteBoard();
				break;
			case 3: // 게시글 수정
				updateBoard();
				break;
			case 4: // 전체 게시글 조회
				printAllBoard();
				break;
			case 5: // 게시글 검색
				searchBoard();
				break;
			case 6: // 작업 끝
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	private void searchBoard() {
		// 검색할 글 번호, 제목, 작성자를 입력하면
		// 입력한 정보만 사용하여 검색하는 기능을 구현.
		// 제목은 입력한 값이 포함만 되어도 검색되도록 한다.
		// 입력을 하지 않을 자료는 엔터키를 다음 입력으로 넘긴다.
		
		scan.nextLine();

		System.out.println();
		System.out.println("검색할 게시글을 입력하세요.");
		System.out.println("* 검색 정보 모르면 Enter입력시 다음 항목으로 넘어감\n* 제목 일부분만 검색 가능\n* All Enter입력시 전체 조회");
		System.out.println();
		
		System.out.print("게시글 번호 >> ");
//		int boardNo = Integer.parseInt(scan.nextLine());
		int boardNo = 0;
		String num = scan.nextLine();
		if(!num.equals("")) {
			boardNo = Integer.parseInt(num);
		}
		
		
		System.out.print("게시글 제목 >> ");
		String boardTitle = scan.nextLine();
		
		System.out.print("게시글 작성자 >> ");
		String boardWriter = scan.nextLine();
		
		BoardVO bv =  new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		
		List<BoardVO> boardList = boService.searchBoard(bv);
		if (boardList.size() == 0) {
			System.out.println(" 게시글이 존재하지 않습니다.");
		} else {
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println(" 글번호\t제목\t\t작성자\t작성일\t\t내용");
			System.out.println("------------------------------------------------------------------------------------------");
			
			//db에서 해당글 목록 조회해오기
			
			for (BoardVO bv2 : boardList) {

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
				String bvDate = simpleDateFormat.format(bv2.getBoardDate());
				
				System.out.println(" " 
						 	+ bv2.getBoardNo() + "\t" 
							+ bv2.getBoardTitle() + "\t\t" 
							+ bv2.getBoardWriter() + "\t" 
							+ bvDate + "\t"
							+ bv2.getBoardContent());
			}
		}
	}

	private void printAllBoard() {

		List<BoardVO> boardList = boService.printAllBoard();

		if (boardList.size() == 0) {
			System.out.println(" 게시글이 존재하지 않습니다.");
		} else {
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println(" 글번호\t제목\t\t작성자\t작성일\t\t내용");
			System.out.println("------------------------------------------------------------------------------------------");

			for (BoardVO bv : boardList) {
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
				String bvDate = simpleDateFormat.format(bv.getBoardDate());
				
				System.out.println(" " 
					 	+ bv.getBoardNo() + "\t" 
						+ bv.getBoardTitle() + "\t\t" 
						+ bv.getBoardWriter() + "\t" 
						+ bvDate + "\t"
						+ bv.getBoardContent());
			}
		}
	}

	private void updateBoard() {

		boolean isExist = false;
		int boardNo = 0;

		do {
			System.out.println();
			System.out.println("수정할 게시글 번호를 입력해주세요.");
			System.out.print("게시글 번호 >> ");

			boardNo = Integer.parseInt(scan.next());
			System.out.println();
			
			
			isExist = boService.checkBoard(boardNo);

			if (!isExist) {
				System.out.println("해당 게시글은 존재하지 않습니다.");
				System.out.println("다시 입력해 주세요.");
			}
		} while (!isExist);
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		
		scan.nextLine();
		System.out.println("수정 사항을 입력하세요.");
		System.out.print("게시글 제목 >> ");
		String boardTitle = scan.nextLine();
		
		System.out.print("작성자 >> ");
		String boardWriter = scan.nextLine();

//		scan.nextLine();

		System.out.print("내용 >>");
		String boardContent = scan.nextLine();
		
		BoardVO boardOne = boService.searchBoardOne(boardNo);

		if(boardTitle != null && !boardTitle.equals("")) {
			bv.setBoardTitle(boardTitle);
		}else {
			bv.setBoardTitle(boardOne.getBoardTitle());
		}
		
		if(boardWriter != null && !boardWriter.equals("")) {
			bv.setBoardWriter(boardWriter);
		}else {
			bv.setBoardWriter(boardOne.getBoardWriter());
		}
		
		if(boardContent != null && !boardContent.equals("")) {
			bv.setBoardContent(boardContent);
		}else {
			bv.setBoardContent(boardOne.getBoardContent());
		}

		int cnt = boService.modifyBoard(bv);

		if (cnt > 0) {
			System.out.println("게시글 수정 성공!");
		} else {
			System.out.println("게시글 수정 실패!");
		}
	}

	private void deleteBoard() {

		System.out.println();
		System.out.println("삭제할 게시글 정보를 입력해 주세요.");
		System.out.print("게시글 번호 >> ");

		int boardNo = Integer.parseInt(scan.next());

		int cnt = boService.removeBoard(boardNo);

		if (cnt > 0) {
			System.out.println("게시글 삭제 성공!");
		} else {
			System.out.println("게시글 삭제 실패!");
		}

	}

	/**
	 * 게시글 작성 메서드
	 */
	private void insertBoard() {

		String boardTitle = "";

		System.out.println();
		System.out.println("새 게시글을 작성합니다.");
		System.out.print("게시글 제목 입력 >> ");
		scan.nextLine();
		boardTitle = scan.nextLine();

		System.out.print("작성자 >> ");
		String boardWriter = scan.next();

		scan.nextLine();

		System.out.print("내용 >>");
		String boardContent = scan.nextLine();

		BoardVO bv = new BoardVO();
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		
		int cnt = boService.registBoard(bv);
		
		if (cnt > 0) {
			System.out.println(bv.getBoardWriter() + "님 게시글 등록 성공!");
			
		} else {
			System.out.println(bv.getBoardWriter() + "님 게시글 등록 실패!");
		}
		
	}

	public static void main(String[] args) {
		BoadrMain memObj = new BoadrMain();
		memObj.start();
	}

}
