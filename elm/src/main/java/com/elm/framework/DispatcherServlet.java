package com.elm.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private static final String BASE_PACKAGE = "com.elm.controller";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 中文编码处理
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");

        // 获取客户端请求路径
        String path = request.getServletPath();
        System.out.println("path:" + path);

        // 根据请求路径，解析 controller 组件类名与方法名
        String className = path.substring(1, path.lastIndexOf("/"));
        String methodName = path.substring(path.lastIndexOf("/") + 1);

        System.out.println("className:" + className);
        System.out.println("methodName:" + methodName);

        PrintWriter out = null;

        try {
            // 拼接完整的包路径并加载controller类的信息
            String fullClassName = BASE_PACKAGE + "." + className;
            Class<?> clazz = Class.forName(fullClassName);
            // 创建controller对象
            System.out.println("创建controller对象: " + fullClassName);
            Object controller = clazz.getDeclaredConstructor().newInstance();
            // 获取controller的方法
            Method method = clazz.getMethod(methodName, HttpServletRequest.class);
            // 调用controller中的方法
            Object result = method.invoke(controller, request);
            System.out.println("//调用controller中的方法:" + methodName);

            out = response.getWriter();
            ObjectMapper om = new ObjectMapper();
            out.print(om.writeValueAsString(result));
            System.out.println("//执行结果:" + om.writeValueAsString(result));

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out = response.getWriter();
            out.print("{\"error\": \"Internal Server Error\"}");
            System.out.println("DispatcherServlet信息：Servlet请求路径：" + path);
            System.out.println("DispatcherServlet信息：类名：" + className + "\t方法名：" + methodName);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
