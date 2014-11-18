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
        <p>
            You will be able to buy multiple items from different sports and
            different athletes all at once. As long as it's not a rare or 
            limited edition item you should be able to find it.
        <p>
            
            
            <strong>Total: ${attribute.bean.quantity * attribute.bean.price}</strong>
        </p>
        
        <form method="post" action ='Controller'>
           
            <input type="submit" name="editButton"
                   value="Edit">
            <input type="submit" name="viewButton"
                   value="View">
            
        </form>
        <form method="get" action ='Controller'>
           
            <input type="submit" name="editButton"
                   value="Start Over">
            
        </form>
         <hr>
        ${attribute.bean.athlete},
        ${attribute.bean.sport},
        ${attribute.bean.item},
        ${attribute.bean.quantity},
        ${attribute.bean.price}
    </body>
   </html>