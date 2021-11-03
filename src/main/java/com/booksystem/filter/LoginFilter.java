package com.booksystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        //基于http
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取访问路径
        String path = request.getRequestURI();//项目路径/资源路径

        //指定页面放行
        if (path.contains("reader_login.jsp")){
            chain.doFilter(request,response);
            return;
        }
        if (path.contains("/user")){
            //得到用户行为
            String actionName = request.getParameter("actionName");
            //判断是否是登录操作
            if ("librarymanageLogin".equals(actionName)) {
                chain.doFilter(request, response);
                return;
            }
        }
        if (path.contains("login/systemmanage_login.jsp")){
            chain.doFilter(request,response);
            return;
        }


        if (path.contains("index.jsp")){
            chain.doFilter(request,response);
            return;
        }

        if (path.contains("/statics")){
            chain.doFilter(request,response);
            return;
        }

        //拦截请求，重定向跳转到登录页面
        request.setAttribute("changePage","login/reader_login.jsp");
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    public void destroy() {

    }
}
