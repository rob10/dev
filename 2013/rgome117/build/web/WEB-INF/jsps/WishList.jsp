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
            The athlete's name is <strong>${attribute.bean.athlete}</strong>. They play 
            <strong>${attribute.bean.sport}</strong>. The item requested was 
            a <strong>${attribute.bean.item}</strong> The amount you want is: <strong>${attribute.bean.quantity}</strong>
            and price for each item is <strong>${attribute.bean.price}</strong>.
        </p>
        
        <form method="post" action ='Controller'>
            
            <input type="submit" name="editButton"
                   value="Edit">
            <input type="submit" name="confirmButton"
                   value="Confirm">
            
        </form>
    </body>
</html>