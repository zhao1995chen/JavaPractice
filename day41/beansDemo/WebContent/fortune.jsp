<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guess</title>
</head>
<body>
	<jsp:useBean id="fortune" class="domain.GuessGameLogic" scope="session">
		<% fortune.initialize(1, 10); %>
	</jsp:useBean>
	<%
		String guess = request.getParameter("number");
		int guessNum = Integer.parseInt(guess);
		if(fortune.isCorrectGuess(guessNum)) {
			session.invalidate();
	%>
	<jsp:forward page="bingo.jsp"></jsp:forward>
	<%
		} else {
			int remainder = fortune.getRemainder();
			if(remainder > 0) {
	%>
	The number <%= guess %> is not correct. <br>
	You still have <%= remainder %> chances. <br>
	<%= fortune.getHint() %> <br>
	<a href="guess.html">Try again</a>
	<%
			} else {
				session.invalidate();
	%>
	<jsp:forward page="noChances.jsp"></jsp:forward>
	<%
			}
		}
	%>
</body>
</html>