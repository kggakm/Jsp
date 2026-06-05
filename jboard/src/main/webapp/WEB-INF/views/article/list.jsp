<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글목록</title>
    <link rel="stylesheet" href="/jboard/css/style.css"/>
</head>
<body>
    <div id="wrapper">
        <%@ include file="./_head.jsp" %>
        <main id="article">
            <section class="list">
                <nav>
                    <h1>
                        전체 글목록
                        <span>${total}건</span>
                    </h1>
                    <form action="/jboard/article/search.do">
                        <select name="searchType">
                    		<option value="title">제목</option>
                    		<option value="content">내용</option>
                    		<option value="writer">글쓴이</option>
                    	</select>
                        <input type="text" name="keyword" placeholder="검색 키워드 입력">
                        <input type="submit" value="검색">
                    </form>
                </nav>
                                
                <table border="0">                    
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>
                    <c:forEach var="dto" items="${dtoList}"> <!-- 'requestScope.dtoList'에서 requestScope 생략 가능 -->                    
	                    <tr>
	                        <td>${pageStart}</td>
	                        <td><a href="/jboard/article/view.do?page=${currentPage}&ano=${dto.ano}">${dto.title}[${dto.comment}]</a></td>
	                        <td>${dto.nick}</td>
	                        <td>${dto.wdate}</td><!--  dto.getWdate() 호출 -->
	                        <td>${dto.hit}</td>
	                    </tr>
	                    <c:set var="pageStart" value="${pageStart-1}"/>
                    </c:forEach>
                </table>

                <div class="page">
                	<c:if test="${pageGroupDTO.start > 1}">
                    	<a href="/jboard/article/list.do?page=${pageGroupDTO.start - 1}" class="prev">이전</a>
                    </c:if>
                    <c:forEach var="i" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end}">
                    	<a href="/jboard/article/list.do?page=${i}" class="num ${currentPage == i ? 'current' : ''}">${i}</a>
					</c:forEach>
					<c:if test="${pageGroupDTO.end < lastPageNum }">
                    	<a href="/jboard/article/list.do?page=${pageGroupDTO.end + 1}" class="next">다음</a>
                    </c:if>
                </div>

                <a href="/jboard/article/write.do" class="btn btnWrite">글쓰기</a>
                
            </section>
        </main>
        <%@ include file="./_tail.jsp" %>
    </div>    
</body>
</html>