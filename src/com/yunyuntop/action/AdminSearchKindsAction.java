package com.yunyuntop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunyuntop.domain.Kinds;
import com.yunyuntop.service.KindsService;


public class AdminSearchKindsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ktext=request.getParameter("ktext");
		KindsService ks=new KindsService();
		List<Kinds> list=ks.findKindsText(ktext);
		if(list!=null&&list.size()>=1){
			int index=0;
			response.getWriter().print("[");
			for (Kinds kinds : list) {
						
				response.getWriter().print("{\"name\":\""+kinds.getKtext()+"\",\"kid\":\""+kinds.getKid()+"\"}");
				index++;
				response.getWriter().print(index!=list.size()?",":"");
			}
			response.getWriter().print("]");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
