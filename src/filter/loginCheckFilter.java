package filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "loginCheckFilter")
public class loginCheckFilter implements Filter {
    private String sessionKey;
    private String redirectUrl;
    private String uncheckedUrls;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        //1.获取请求URL
        String servletPath = httpRequest.getServletPath();
        System.out.println("dofilter "+servletPath);

        //2.检测1中获取的servletPath是否为css js文件或者是不需要检测的URl中的一个.若是,放行

        if(servletPath.contains(".css")||servletPath.contains(".js")||servletPath.contains(".jpg")||servletPath.contains(".png")||servletPath.contains(".gif")){
            if(!servletPath.contains(".jsp")){
                chain.doFilter(httpRequest, httpResponse);
                System.out.println("dofilter check css js and more");
                return;
            }
        }
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        if (urls.contains(servletPath)) {
            chain.doFilter(httpRequest, httpResponse);
            System.out.println("dofilter check url");
            return;
        }

        //3.从session中获取SessionKey对应值,若值不存在,则重定向到redirectUrl
        Object user = httpRequest.getSession().getAttribute(sessionKey);
        if ((user == null)) {
            System.out.println("dofilter check login");
            httpResponse.sendRedirect(httpRequest.getContextPath() + redirectUrl);
            return;
        }

        //4.若存在,则放行
        chain.doFilter(httpRequest, httpResponse);

    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        //获取XML文件中配置参数
        sessionKey = servletContext.getInitParameter("userSessionKey");
        //System.out.println("sessionKey======" + sessionKey);//调试用
        redirectUrl = servletContext.getInitParameter("redirectPage");
        //System.out.println("redirectPage======" + redirectUrl);
        uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
        //System.out.println("uncheckedUrls=====" + uncheckedUrls);

    }

}
