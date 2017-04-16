<%@page import="indi.group.pcss.controller.LoginController"%>
<%@ page contentType="image/jpeg"%>
<jsp:useBean id="image" class="indi.group.pcss.services.impl.MakeCertPicServicesImpl" />

<%
	String str = image.getCerPic(0, 0, response.getOutputStream());
	LoginController.safecode=str;
	out.clear();
	out = pageContext.pushBody();
	session.setAttribute("certCode", str);
%>
