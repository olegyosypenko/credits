<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>AllCredits</title>
        <meta charset="utf-8">
        
        <style><%@include file="/style.css"%></style>
    </head>
    <body>
        <header>
            <h1 class="logo">
                AllCredits
            </h1>
            <c:set var="loc" value='${bundle["locale"]}'/>
            <c:choose>
                <c:when test="${loc.equals('/en')}">
                    <a href="${context}/search" class="language"><span>ua</span><span class="active">en</span></a>
                </c:when>
                <c:otherwise>
                    <a href="${context}/en/search" class="language"><span class="active">ua</span><span>en</span></a>
                </c:otherwise>
            </c:choose>
            
        </header>
        <div class="main-content">
            <form action="${context}${bundle["locale"]}/credits" method="get">
                <div class="select">
                    <select name="bank-name">
                        <option selected value="">${bundle["choose.bank"]}</option>
                        <option value='${bundle["privat.bank"]}'>${bundle["privat.bank"]}</option>
                        <option value='${bundle["oschad.bank"]}'>${bundle["oschad.bank"]}</option>
                        <option value='${bundle["aliance.bank"]}'>${bundle["aliance.bank"]}</option>
                    </select>
                    
                </div>
                <div class="select">
                    <select name="target-name">
                        <option selected value="any">${bundle["choose.target"]}</option>
                        <option value="mortgage">${bundle["mortgage"]}</option>
                        <option value="car">${bundle["car"]}</option>
                        <option value="study">${bundle["study"]}</option>
                        <option value="renovation">${bundle["renovation"]}</option>
                    </select>
                </div>      
                <div class="check-boxes">
                    <input class="check" type="checkbox" name="increase-able" value="true"> <span>${bundle["increase"]}</span> <br>
                    <input class="check" type="checkbox" name="close-able" value="true"> <span>${bundle["close"]}</span>
                </div>
                <div><input class="button" type="submit" value="${bundle["search"]}"></div>
            </form>
        </div>
            
    </body>
</html>
