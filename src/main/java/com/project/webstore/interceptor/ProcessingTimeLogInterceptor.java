package com.project.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/***
 * CONFIG INTERCEPTOR TO LOG THE TIME OF HTTP REQUEST
 * @author hien
 *
 */
public class ProcessingTimeLogInterceptor implements HandlerInterceptor {
   
    private static final Logger LOGGER = Logger.getLogger(ProcessingTimeLogInterceptor.class);
 

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
    		// get the current time
    		long startTime = System.currentTimeMillis();
    		req.setAttribute("startTime", startTime);// get the starttime
    		return true;
    		
    }
 

    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) {
    		String queryString= req.getQueryString() == null?"":"?"+ req.getQueryString();
    		String path = req.getRequestURL()+queryString;
    		
    		// start time 
    		long startTime = (Long)req.getAttribute("startTime");
    		
    		// end time 
    		long endTime = System.currentTimeMillis();
    		LOGGER.info(String.format("%s millisecond taken to process the request %s.",(endTime - startTime), path));
    		
    		
    	
    }
 
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exceptionIfAny){
       // NO operation. 
    }
}
