package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Emp;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectEmp")
public class SelectEmpController extends HttpServlet {
    private EmpService service = new EmpService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String deptno = request.getParameter("deptnoselect");
        String job = request.getParameter("jobselect");
        List<Emp> empList = service.selectEmp(deptno, job);
        JSONObject json = new JSONObject();
        json.put("empList",empList);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJSONString());
    }
}
