<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Process Page</title>
        <link rel='stylesheet' type="text/css" href="docRoot/styles/stylsheet">
    </head>
    <body>
        <%@ taglib uri= "http://java.sun.com/jsp/jstl/core"
                   prefix="core" %>
        
        </p>
        
        <form method="post" action ='Controller'>
           
            <input type="submit" name="editButton"
                   value="Edit">
            
            
        </form>
        <form method="get" action ='Controller'>
           
            <input type="submit" name="editButton"
                   value="Start Over">
            
        </form>
        <hr>
        <table>
            
                <core:forEach var="row" items="${database}">
                <tr> Table 
                    <th>Athlete</th>
                    <td>${row.athlete}</td>
                </tr>
                <tr>
                    <th>Sport</th>
                    <td>${row.sport}</td>
                </tr><tr>
                    <th>Item</th>
                    <td>${row.item}</td>
                </tr><tr>
                    <th>Quantity</th>
                    <td>${row.quantity}</td>
                </tr><tr>
                    <th>Price</th>
                    <td>${row.price}</td>
                </tr>
                <tr>
                    <th>Extra
                    <td>
            <ul>
              <core:forEach var="extra" 
                            items="${row.extra}">
                <li>${extra}
              </core:forEach>
            </ul></tr>
            <tr>
                    <th>Quantity</th>
                    <td>${row.grade}</td>
                </tr>
                </core:forEach>
        </table>
    </body>
   </html>