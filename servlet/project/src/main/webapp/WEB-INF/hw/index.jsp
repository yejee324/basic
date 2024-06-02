<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="vo.mberVo"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mber</title>
</head>
<body>
<h4>Mber 목록</h4>
<%	ArrayList<mberVo> mberList = (ArrayList<mberVo>)request.getAttribute("mberList"); %>
<%	for(int i=0; i<mberList.size(); i++) { %>
	<%=mberList.get(i).getMberSeq()%>
	<%=mberList.get(i).getId()%>
	<%=mberList.get(i).getName()%>
	<%=mberList.get(i).getBirh()%>
	<%=mberList.get(i).getGendCd()%>
	<%=mberList.get(i).getMptel()%>
	<%=mberList.get(i).getCreateDate()%><br/>
<%	} %>
</body>
</html>