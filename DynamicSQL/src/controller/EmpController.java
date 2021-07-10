package controller;

import com.alibaba.fastjson.JSONObject;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectTwo")
public class EmpController extends HttpServlet {

    private EmpService service = new EmpService();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> deptnoiList = service.selectAllDept();
        List<String> jobList = service.selectAllJob();
//        System.out.println(deptnoiList);
//        System.out.println("===");
//        System.out.println(jobList);
        JSONObject json = new JSONObject();
        json.put("deptList",deptnoiList);
        json.put("jobList",jobList);
        response.setCharacterEncoding("UTF-8");
        System.out.println("测试"+json);
        response.getWriter().write(json.toJSONString());

    }
}
