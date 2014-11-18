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
            ${attribute.info.getMessage}
        </p>

        <form action="Controller">
            <input type="hidden" name="athlete"
                   value="${attribute.info.athlete}">
            <input type="hidden" name="sport"
                   value="${attribute.info.sport}">
            <input type="hidden" name="item"
                   value="${attribute.info.item}">
            <input type="submit" name="editButton"
                   value="Edit">
            <input type="submit" name="processButton"
                   value="Process">
            <input type="submit" name="wishlistButton"
                   value="Wish List">
        </form>


    </body>
</html>