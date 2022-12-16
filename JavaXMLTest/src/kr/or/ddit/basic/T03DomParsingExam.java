package kr.or.ddit.basic;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * XML DOM을 이용한 XML문서 파싱 예제 (레시피 정보 조회 API)
 * 
 * @author PC-22
 *
 */
public class T03DomParsingExam {

	public void parse() throws Exception {

		String svcKey = "Grid_20150827000000000227_1"; // 레시피 재료 정보 조회 서비스
		String apiKey = "1df7e8571e8df3f8cbc9b87691ca7d3e4d04f03c593d477e52bf67b03f0b6e1c"; // 개인별 발급.
		String startIdx = "1"; // 레시피 재료 시작 순번
		String endIdx = "5"; // 레시피 재료 종료 순번
		String recipeId = "476"; // 래시피가 궁금한 음식 ID

		String url = "http://211.237.50.150:7080/openapi/" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/" + endIdx
				+ "?RECIPE_ID=" + recipeId;

//		System.out.println(url);

		// XML문서를 생성하기 위한 DocumentBuilder객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();

		// 파일로 부터 Document 객체 생성
		Document document = builder.parse(url);

		// Document 객체로 부터 루트 엘리먼트 가져오기
		Element root = document.getDocumentElement();

		// 전체 레시피 수 가져오기
		String totalCnt = root.getElementsByTagName("totalCnt").item(0).getTextContent();
		endIdx = totalCnt;
		
		url = "http://211.237.50.150:7080/openapi/" + apiKey + "/xml/" + svcKey + "/" + startIdx + "/" + endIdx
				+ "?RECIPE_ID=" + recipeId;

		// 파일로 부터 Document 객체 생성
		document = builder.parse(url);

		// Document 객체로 부터 루트 엘리먼트 가져오기
		root = document.getDocumentElement();
		
		String code = root.getElementsByTagName("code").item(0).getTextContent();
		
		if(code.equals("INFO-000")) {
			
			NodeList list = root.getElementsByTagName("row");
			
			for(int i=0; i<list.getLength(); i++) {
				Element el = (Element) list.item(i);
				
				String rowNum = el.getElementsByTagName("ROW_NUM").item(0).getTextContent();
				String irdntNm = el.getElementsByTagName("IRDNT_NM").item(0).getTextContent();
				String irdntCpcty = el.getElementsByTagName("IRDNT_CPCTY").item(0).getTextContent();
				String irdntTyNm = el.getElementsByTagName("IRDNT_TY_NM").item(0).getTextContent();
				
				System.out.printf("%3s %8s %10s %10s %8s\n", rowNum, recipeId, irdntTyNm, irdntNm, irdntCpcty);
				System.out.println("-----------------------------------------------------------------------");
				
			}
		}
	}

	public static void main(String[] args) throws Exception {

		new T03DomParsingExam().parse();
	}
}
