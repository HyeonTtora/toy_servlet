package com.httora.toy_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.httora.toy_servlet.beans.SurveyBeans;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polllistservlet")
public class Survey extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        SurveyBeans data = new SurveyBeans();

        PrintWriter pw = response.getWriter();
        String name = request.getParameter("user");
        String belong = request.getParameter("belong");
        String title = "poll List Servlet";

        String[] questionIds = data.getQuestionIds();
        HashMap<String, String> questions = data.getQuestion();
        HashMap<String, String> answers = data.getAnswer();
        ArrayList<String> possibleAnswer;

        pw.println("<!DOCTYPE html>");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("<link");
        pw.println("rel='stylesheet'");
        pw.println(" href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css'");
        pw.println(" />");
        pw.println("<title>Toy_servlet</title>");
        pw.println("</head>");
        pw.println(" <body>");
        pw.println("<div class='container'>");
        pw.println("<div class='fs-1 my-3'>" + title + "</div>");
        pw.println("<div class='fs-5 my-3'>Name : " + name + " Belong : " + belong + "</div>");

        for (int i = 0; i < questionIds.length; i++) {

            pw.println("<div class='my-3'>");
            // "Q1", "Q2", "Q3", "Q4", "Q5" - ID에 맞는 질문 Text 꺼내기
            String value = questions.get(questionIds[i]);
            
            pw.println("<div>" + (i + 1) + ". " + value + "</div>");

            // ID에 맞는 답변 가능한 항목 Answer ID 갖고오기
            possibleAnswer = data.getPossibleAnswer(questionIds[i]);

            pw.println("<div>");
            // Answer ID를 Text화
            for (int j = 0; j < possibleAnswer.size(); j++) {
                String answerText = answers.get(possibleAnswer.get(j));
                pw.println((j + 1) + ". " + answerText + " ");
            }
            pw.println("</div>");
        }
        pw.println("</div>");

        pw.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js");
        pw.println("'></script>");
        pw.println("</body>");
        pw.println("</html>");

    }
}
