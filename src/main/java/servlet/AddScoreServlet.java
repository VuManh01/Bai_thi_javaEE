package servlet;

import dao.ScoreDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Score;

import java.io.IOException;
import java.sql.SQLException;

// servlet/AddScoreServlet.java
@WebServlet("/addScore")
public class AddScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Score score = new Score();
        score.setStudentId(Integer.parseInt(req.getParameter("student_id")));
        score.setSubjectId(Integer.parseInt(req.getParameter("subject_id")));
        score.setScore1(Double.parseDouble(req.getParameter("score1")));
        score.setScore2(Double.parseDouble(req.getParameter("score2")));
        try {
            new ScoreDAO().addScore(score);
        } catch (SQLException e) { e.printStackTrace(); } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("studentInfo");

    }
}
