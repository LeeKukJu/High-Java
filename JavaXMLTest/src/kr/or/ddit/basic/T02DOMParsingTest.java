package kr.or.ddit.basic;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class T02DOMParsingTest {

	public void parse() throws Exception {
		
		// XML문서를 생성하기 위한 DocumentBuilder객체 생성하기
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbf.newDocumentBuilder();

		// 파일로 부터 Document 객체 생성
		Document document = builder.parse(new File("./src/new_book.xml"));
		
		// Document 객체로 부터 루트 엘리먼트 가져오기
		Element root = document.getDocumentElement();
		System.out.println("루트 엘리먼트 태그명: " + root.getTagName());
		
		// 하위 엘리먼트 접근 방법1 : getElementByTagName() 메서드 이용
		NodeList bookNodeList = root.getElementsByTagName("book");
		Node firstBookNode = bookNodeList.item(0);
		Element firstBookElement = (Element) firstBookNode;
		
		// 속성 접근 방법1 : 엘리먼트 객체의 getAttribute() 이용
		System.out.println("엘리먼트 객체의 getAttribute() 이용 => " 
							+ firstBookElement.getAttribute("isbn"));
		
		// 속성 접근 방법2 : 노드 객체의 getAttributes() 이용 (속성노드 접근하기)
		NamedNodeMap nodeMap = firstBookNode.getAttributes();
		System.out.println("노드객체의 getAttributes() 이용 => " 
							+ nodeMap.getNamedItem("isbn").getNodeValue());
		
		
		// 전체 출력하기
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%8s %8s %15s %10s %8s\n", "SIBN", "분류", "제목", "저자", "가격");
		System.out.println("----------------------------------------------------------------------");
		
		for(int i=0; i<bookNodeList.getLength(); i++) {
			Element element = (Element) bookNodeList.item(i);
			
			String isbn = element.getAttribute("isbn");
			String kind = element.getAttribute("kind");
			String title = element.getElementsByTagName("title").item(0).getTextContent().trim();
			String author = element.getElementsByTagName("author").item(0).getTextContent().trim();
			String price = element.getElementsByTagName("price").item(0).getTextContent().trim();
			
			System.out.printf("%8s %8s %15s %10s %8s\n", isbn, kind, title, author,price);
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		new T02DOMParsingTest().parse();
		
	}
}
