<!doctype html>
<html>
   <head>
      <meta charset="utf-8">
      <title>Edit</title>
      <link rel='stylesheet' type="text/css" href="docRoot/styles/stylsheet">
   </head>
   <body>
      <form action ='Controller'>
         <p>
           Instead of going to various websites for different equipment and 
           merchandise for different and different athletes you can just search
           and find them all here.
         <p>
           Athlete: <input type="text" name="athlete"
                           value="${attribute.info.athlete}">
           <br>
           Sport: <input type="text" name="sport"
                           value="${attribute.info.sport}">
           <br>
           Item: <input type="text" name="item"
                           value="${attribute.info.item}">
           <br>
           <input type="submit" name="confirmButton"
                           value="Confirm">
      </form>
   </body>
</html