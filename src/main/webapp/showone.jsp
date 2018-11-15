<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>AllCredits</title>
        <meta charset="utf-8">
        <style><%@include file="/style.css"%></style>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
    </head>
    <body>
        <header>
            <h1 class="logo">
                AllCredits
            </h1>
        </header>
        <div class="main-content credit-description">
            <h2>${bundle["credit.number"]}${credit.id}</h2>
            <h3>${bundle["bank.head"]}</h3> <span>${credit.bankName}</span>
            <h3>${bundle["target.head"]}</h3> <span>${credit.target.message}</span>
            <h3>${bundle["rate.head"]}</h3> <span>${credit.interestRate}%</span>
            <h3>${bundle["term.head"]}</h3> <span>${credit.creditTerm} ${bundle["months.label"]}</span>
            <h3>${bundle["credit.line.head"]}</h3> <span>${credit.creditLine} ₴</span>
            <h3>${bundle["increase.head"]}</h3> <span>
                                <c:choose>
                                    <c:when test="${credit.increaseCreditLine}">
                                      <i class="far fa-check-circle green"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="far fa-times-circle red"></i>
                                    </c:otherwise>
                                </c:choose></span>
            <h3>${bundle["close.head"]}</h3> <span>
                                <c:choose>
                                    <c:when test="${credit.earlyCreditRepayment}">
                                      <i class="far fa-check-circle green"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="far fa-times-circle red"></i>
                                    </c:otherwise>
                                </c:choose></span>
            <a  class="button" href="${context}${bundle["locale"]}/search">${bundle["back.to.search"]}</a>
        </div>
    </body>
</html>
