package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public join() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("joinCode", "yes");
		
		//전달하는 방법1
		//RequestDispatcher disp = request.getRequestDispatcher("전달할 위치를 지정");
		//disp.forward(request, response);
		
		//전달하는 방법2
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
