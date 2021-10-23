<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 9/21/2021
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

    <title>StudentsPage</title>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <!--<link rel="stylesheet" type="text/css" href="page-css.css">-->
    <style type="text/css">
        body{
            overflow: hidden;
            /*border: 5px solid black;*/
            position: absolute;
            height: 100%;
            width: 100%;
            padding-right: 1%;
            padding-left: 1%;
            padding-bottom: 0.5%;
        }

        div.first{
            /*border: 5px solid blue;*/
            position: relative;
            height: 18%;
        }

        div.second{
            /*border: 5px solid red;*/
            margin-top: 0.5%;
            box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;
            border-radius: 10px;
            position: relative;
            /*height: 80%;
            height: 842px;*/
            height: 4.5%;
            max-height: 40.5em;
            overflow: hidden;
            margin-left: 3%;
            margin-right: 3%;
            /*overflow-y: auto;*/
        }

        tbody {
            /*border: 5px solid blue;*/
            position: absolute;
            /*margin-top: auto;*/
            overflow-y: auto;
            max-height: 94%;
        }

        thead, table tbody tr {
            display: table;
            width: 100%;
            table-layout: fixed;
        }

        ::-webkit-scrollbar{width: 20px;}
        ::-webkit-scrollbar-track{
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
            border-radius: 10px;
        }
        ::-webkit-scrollbar-thumb{
            border-radius: 10px;
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<div class="first">
    <div style="position: absolute; right: 3.5%; bottom: 0">
    <a  class="btn btn-primary" href="/AddStudent">Add Student</a>
    </div>
    <div style="position: absolute; right: 0;">
    <a class="btn btn-danger" href="/logout">Logout</a>
    </div>
</div>
<script>
    var cruentHieght = 0;
    var countLoop = 1;
    var flag = true;
</script>
<div>
<div class="second" id="forTable">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Date</th>
            <th scope="col">Is Active</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Students}" var="stud">
            <tr>
                <th scope="row">${stud.id}</th>
                <td>${stud.firstName}</td>
                <td>${stud.lastName}</td>
                <td>${stud.date}</td>
                <td>${stud.isActive}</td>
                <td> <a href="delete/<c:out value='${stud.id}'/>" class="btn btn-danger"> Delete </a>
                    <a href="edit-student?id=<c:out value='${stud.id}'/>"  class="btn btn-success">Edit</a> </td>

            </tr>
            <script>
                cruentHieght = document.getElementById("forTable").clientHeight;
                /*if(document.getElementById("forTable").clientHeight <= 237){*/
                    if(countLoop == 1)
                        cruentHieght += 70;
                    else
                        cruentHieght += 60;
                    document.getElementById("forTable").style.height = String(cruentHieght) + "px";
                    countLoop++;

                    //alert(countLoop + " " + ${Students.size()});
                /*}else if(flag){
                    flag = false;
                    cruentHieght += 3;
                    document.getElementById("forTable").style.height = String(cruentHieght) + "%";
                }*/
            </script>
        </c:forEach>


        </tbody>
    </table>
    <script>
        //alert(document.getElementById("forTable").clientHeight);
    </script>
</div>
<div class="container">
    <!--${Students}-->
</div>
</div>
</body>
</html>