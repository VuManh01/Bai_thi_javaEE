package dao;

import model.Score;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class ScoreDAO {
    public void addScore(Score score) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO student_score_t (student_id, subject_id, score1, score2) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, score.getStudentId());
        stmt.setInt(2, score.getSubjectId());
        stmt.setDouble(3, score.getScore1());
        stmt.setDouble(4, score.getScore2());
        stmt.executeUpdate();
        conn.close();
    }

    public List<Score> getScoresByStudentId(int studentId) throws SQLException, ClassNotFoundException {
        List<Score> scores = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM student_score_t WHERE student_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, studentId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Score sc = new Score();
            sc.setStudentId(rs.getInt("student_id"));
            sc.setSubjectId(rs.getInt("subject_id"));
            sc.setScore1(rs.getDouble("score1"));
            sc.setScore2(rs.getDouble("score2"));
            scores.add(sc);
        }
        conn.close();
        return scores;
    }
}