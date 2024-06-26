<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   --%>

<%@include file="../common/common.jsp" %>
 
web-inf\album\albumDetail.jsp<br>
<h2 align = "center">상품 상세 화면</h2>
<table border=1 width="400" height="400" align = "center" style = "border-collapse: collapse;">
	<tr>
		<th width="100">번호</th> 
		<td>${album.num }</td>
	</tr>
	 
	<tr>
		<th>노래 제목</th>
		<td>${album.title }</td>
	</tr>
	
	<tr>
		<th>가수명</th>
		<td>${album.singer }</td>
	</tr>
	
	<tr>
		<th>가격</th>
		<td><fmt:formatNumber value="${album.price}" pattern="#,###원" /></td>
	</tr>
	
	<tr>
		<th>발매일</th>
		<td>
			<fmt:parseDate value="${album.day}" var="dayFmt" pattern="yyyy-MM-dd"/>
			<fmt:formatDate value="${dayFmt}" pattern="yyyy-MM-dd"/>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<a href = "list.ab">앨범 리스트 화면으로 돌아감</a> <br>
		</td>
	</tr>
</table>