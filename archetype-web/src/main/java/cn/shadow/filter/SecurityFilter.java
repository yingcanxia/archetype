package cn.shadow.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.shadow.archetype.entity.Teller;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//登录时首先按照操作员id查询该操作员有什么可以使用的借口查出list
		//将list进行遍历查看时候有改可执行的内容
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		HttpServletResponse httpServleResponse = (HttpServletResponse)response;
		HttpSession session = httpServletRequest.getSession(false);
		String requestURL=httpServletRequest.getRequestURI();
		String contextPath = httpServletRequest.getContextPath();
		requestURL=requestURL.replaceAll(contextPath, "");
		System.out.println(requestURL+"\n"+contextPath);
		if(requestURL.equals("/main/login.do")) {
			//正常登陆
			chain.doFilter(request, response);
		}else {
			if(session == null){
				httpServleResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
				return;
			}
			Teller user=(Teller) session.getAttribute("user");
			if(user==null) {
				httpServleResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
				return;
			}
			List<String> powerList=(List<String>) session.getAttribute("powerList");
			if(powerList==null) {
				httpServleResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
				return;
			}
			boolean flag=false; 
			for(String power:powerList) {
				if(requestURL.equals(power)) {
					flag=true;
				}
			}
			
			// pass the request along the filter chain
			if(flag) {
				chain.doFilter(request, response);
			}else {
				httpServleResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");
				throw new RuntimeException("您没有权限执行该条操作");
			}
		}
		/*chain.doFilter(request, response);*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
