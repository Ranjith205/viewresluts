<!-- <html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
</body>
</html> -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">
 
       
 
        <table id="table" border=1>
            <tr> <th> RNo </th> <th> Name </th><th> Cousre</th> <th> Marks</th> <th>Grade</th><th> Remarks </th> </tr>
         
        </table>
             
     
    <script type="text/javascript">
    data = "";
    load = function(){ 
        $.ajax({
            url:'http://localhost:8080/viewresults/webapi/getmarks',
            type:'GET',
            success: function(response){
                    data = response.data;
                    alert("hello "+response.length);
                    $('.tr').remove();
                    for(i=0; i<response.length; i++){  
                    	//alert(response[i].rno);
                        $("#table").append(
                                "<tr class='tr'> <td> "+response[i].rno
                                +" </td> <td> "+response[i].student_name
                                +" </td><td> "+response[i].course_name
                                +" </td> <td> "+response[i].marks
                                +" </td><td> "+response[i].grade
                                +" </td> <td> "+response[i].remarks+"</td> </tr>");
                    }          
            }              
        });
         
    }
         
    </script>
     
</body>
</html>
