<%-- 
    Document   : shcSubjectNumber
    Created on : Oct 30, 2016, 10:09:08 PM
    Author     : Rasel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/main.css">

    </head>
    <body style="color: black; text-align: center;background-color: #3e8f3e">
        <h1>Bangladesh</h1>
        <h2>Secondary School Certificate</h2>
        <h4>Academic Transcript</h4>
        <br />
        <br />
        <br />

        <form action=""class="navbar-form navbar-right" role="search">
            <div class="form-group">
                <input type="number" class="form-control" placeholder="Enter Your Roll Number">
               
            </div>
            
        </form>
        <table class="table table-info">
            <tr>
                <td>Roll No.</td>
                <td>${param.rollNo}</td>
                <td>Registration No.</td>
                <td>${param.regNo}</td>
            </tr>
            <tr>
                <td >Name of Student</td>
                <td>${param.studentN}</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td >Fathers Name</td>
                <td>${param.faName}</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td >Mothers Name</td>
                <td>${param.moName}</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td >Name of Institution</td>
                <td>${param.nIstitution}</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td >Group</td>
                <td >${param.group}</td>
                <td >Date of Birth</td>
                <td >${param.dob}</td>
            </tr>
        </table>
        <br />
        <br />
        <br />

        <table class="table table-active" style="background-color: #d9edf7">
            <thead>
                <tr>
                    <th>SI. No.</th>
                    <th>Name of Subjects</th>
                    <th>Letter Grade</th>
                    <th>Grade Point</th>
                    <th>GPA Letter</th>
                    <th>GPA</th>
                </tr>
            </thead>
            <tbody>


                <tr>
                    <td>1</td>
                    <td>Bangla</td>
                    <td>${requestScope.bangL}</td>
                    <td>${requestScope.bangP}</td>
                    <td rowspan="10">${requestScope.letterGPA}</td>
                    <td rowspan="10">${requestScope.gradeGPA}</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>English</td>
                    <td>${requestScope.engL}</td>
                    <td>${requestScope.engP}</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>General Mathematics</td>
                    <td>${requestScope.gMathL}</td>
                    <td>${requestScope.gMathP}</td>

                </tr>
                <tr>
                    <td>4</td>
                    <td>Religious Education</td>
                    <td>${requestScope.religiousEL}</td>
                    <td>${requestScope.religiousEP}</td>

                </tr>

                <tr>
                    <td>5</td>
                    <td>Social Science</td>
                    <td>${requestScope.socialSL}</td>
                    <td>${requestScope.socialSP}</td>

                </tr>
                <tr>
                    <td>6</td>
                    <td>Physics</td>
                    <td>${requestScope.physicsSL}</td>
                    <td>${requestScope.physicsSP}</td>

                </tr>
                <tr>
                    <td>7</td>
                    <td>Chemistry</td>
                    <td>${requestScope.chemistrySL}</td>
                    <td>${requestScope.chemistrySP}</td>

                </tr>
                <tr>
                    <td>8</td>
                    <td>Higher Mathematics</td>
                    <td>${requestScope.hMathL}</td>
                    <td>${requestScope.hMathP}</td>
                </tr>
                <tr>
                    <td>9</td>
                    <td>Biology</td>
                    <td>${requestScope.biologySL}</td>
                    <td>${requestScope.biologySP}</td>
                </tr>
                <tr>
                    <td>10</td>
                    <td>Computer Studies</td>
                    <td>${requestScope.computerSL}</td>
                    <td>${requestScope.computerSP}</td>
                </tr>



            </tbody>
        </table>
        <table class="table table-active">

            <c:forEach var="row1" items="${requestScope.table1}" >
                <tr>
                    <c:forEach var="row" items="${row1}" >
                        <td>${row}</td>
                    </c:forEach>
                </tr>
            </c:forEach>

        </table>

        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
