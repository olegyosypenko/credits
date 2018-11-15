<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>AllCredits</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
        <style><%@include file="/style.css"%></style>
    </head>
    <body>
        <header>
            <h1 class="logo">
                AllCredits
            </h1>
        </header>
        <div class="main-content">
            <table class="table">
                <thead>
                    <tr>
                        <th>${bundle["bank.head"]}</th>
                        <th>${bundle["target.head"]}</th>
                        <th>${bundle["rate.head"]}, %</th>
                        <th>${bundle["term.head"]}, ${bundle["months.label"]}</th>
                        <th class="center">${bundle["increase.head"]}</th>
                        <th class="center">${bundle["close.head"]}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${credits}" var="credit">
                        <tr onclick="window.location='${context}${bundle["locale"]}/credit/${credit.id}';">
                            <td>${credit.bankName}</td>
                            <td>${credit.target.message}</td>
                            <td>${credit.interestRate}</td>
                            <td>${credit.creditTerm}</td>
                            <td class="center">
                                <c:choose>
                                    <c:when test="${credit.increaseCreditLine}">
                                      <i class="far fa-check-circle green"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="far fa-times-circle red"></i>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td class="center">
                                <c:choose>
                                    <c:when test="${credit.earlyCreditRepayment}">
                                      <i class="far fa-check-circle green"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="far fa-times-circle red"></i>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
                    
            <a href="${context}${bundle["locale"]}/search" class="button">${bundle["back.to.search"]}</a>
        </div>
    </body>
</html>
