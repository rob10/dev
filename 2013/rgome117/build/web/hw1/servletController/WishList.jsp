<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Process Page</title>
        <link rel='stylesheet' type="text/css" href="docRoot/styles/stylsheet">
    </head>
    <body>
        <p>
            This page shows you items that you wish to buy in the future, you
            can keep an eye on items you are saving up to by through here. Once 
            you are ready to buy you will be able to check out these items.
        <p>
            The athlete's name is <strong>${attribute.info.athlete}</strong>. They play 
            <strong>${attribute.info.sport}</strong>. The item requested was 
            a <strong>${attribute.info.item}</strong>
        </p>
        
        <form action="Controller">
            <input type="hidden" name="athlete"
                   value="${attribute.info.athlete}">
            <input type="hidden" name="team"
                           value="${attribute.info.sport}">
            <input type="hidden" name="item"
                           value="${attribute.info.item}">
            <input type="submit" name="editButton"
                   value="Edit">
            <input type="submit" name="confirmButton"
                   value="Confirm">
            
        </form>
    </body>
</html>