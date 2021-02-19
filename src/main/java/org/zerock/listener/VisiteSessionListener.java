package org.zerock.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zerock.service.restaurant.RestaurantService;
import org.zerock.service.visit.VisitService;

/**
 * Application Lifecycle Listener implementation class VisiteSessionListener
 *
 */
@WebListener
public class VisiteSessionListener implements HttpSessionListener {
	private VisitService service;
	
    /**
     * Default constructor. 
     */
    public VisiteSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
	public void sessionCreated(HttpSessionEvent arg0)  {
		if(arg0.getSession().isNew()) {
		
		try {
			//전체 방문자 수 증가
			service.insert();
			
			int total = service.getTotal();
			int today = service.getToday();
			
			System.out.println("*****total ********" +total);
			System.out.println("*****today ********" +today);
			
			HttpSession session = arg0.getSession();
			session.setAttribute("totalCnt", total);
			session.setAttribute("todayCnt", today);


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		

    }

		

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
