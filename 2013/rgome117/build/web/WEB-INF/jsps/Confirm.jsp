<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Confirm Page</title>
        <link rel='stylesheet' type="text/css" href="docRoot/styles/stylsheet">
    </head>
    <body>
        <p>
            You will also be able to view multiple items from your favorite 
            athletes in the same page, instead of going to a shoe website to buy 
            their shoes and then to a sporting goods website to buy their 
            equipment.
        <p>
            
        <ol>
            <li>${attribute.bean.athlete}
            <li>${attribute.bean.sport}
            <li>${attribute.bean.item}
            <li>${attribute.bean.quantity}
            <li>${attribute.bean.price}   
            <li>Extras:
                <ol>
                    <core:forEach var="extra" items="${attribute.bean.extra}">
                        <li>${extra}
                    </core:forEach>
                </ol>
             <li>Grade: ${attribute.bean.grade}
        </ol>
           
        </p>

        <form method="post" action ='Controller'>
           
            <input type="submit" name="editButton"
                   value="Edit">
            <input type="submit" name="processButton"
                   value="Process">
            <input type="submit" name="wishlistButton"
                   value="Wish List">
        </form>


    </body>
</html>