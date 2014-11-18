<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Process Page</title>
        <link rel='stylesheet' type="text/css" href="docRoot/styles/stylsheet">
    </head>
    <body>
        <p>
            You will be able to buy multiple items from different sports and
            different athletes all at once. As long as it's not a rare or 
            limited edition item you should be able to find it.
        <p>
            The athlete's name is <strong>${attribute.info.athlete}</strong>. They play 
            <strong>${attribute.info.sport}</strong>. The item requested was 
            a <strong>${attribute.info.item}</strong>
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
            
        </form>
        
    </body>
   </html>