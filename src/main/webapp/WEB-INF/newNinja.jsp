<!-- prettier-ignore -->
<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8" %>
<!-- prettier-ignore -->
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prettier-ignore -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- prettier-ignore -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Insert title here</title>
        <link
            rel="stylesheet"
            href="/webjars/bootstrap/css/bootstrap.min.css"
        />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <form:form
                action="/createNinja"
                method="post"
                modelAttribute="ninja"
            >
                <div>
                    <form:label path="dojo">rating</form:label>
                    <form:select path="dojo">
                        <c:forEach items="${dojos}" var="dojo">
                            <form:option value="${dojo.id} "
                                >${dojo.name}</form:option
                            >
                        </c:forEach>
                    </form:select>
                </div>
                <div>
                    <form:label path="firstName">firstName</form:label>
                    <form:errors path="firstName" />
                    <form:input path="firstName" />
                </div>
                <div>
                    <form:label path="lastName">lastName</form:label>
                    <form:errors path="lastName" />
                    <form:input path="lastName" />
                </div>
                <div>
                    <form:label path="age">age</form:label>
                    <form:errors path="age" />
                    <form:input path="age" />
                </div>
                <input type="submit" value="Submit" />
            </form:form>
        </div>
    </body>
</html>
