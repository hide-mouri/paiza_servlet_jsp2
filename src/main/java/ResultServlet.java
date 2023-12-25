
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String article = request.getParameter("article");
		String userName = request.getParameter("userName");

		File file = new File(getServletContext().getRealPath("articles.txt"));
		FileWriter filewriter = new FileWriter(file, true);

		// 保存するファイルを指定する
		filewriter.write(article + "," + userName + System.getProperty("line.separator"));
		filewriter.close();

		request.setAttribute("article", article);
		request.setAttribute("userName", userName);
		request.setAttribute("message", "投稿しました！");

		String view = "/WEB-INF/views/result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
