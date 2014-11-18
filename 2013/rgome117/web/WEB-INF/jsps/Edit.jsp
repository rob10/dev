<!doctype html>
<html>
   <head>
      <meta charset="utf-8">
      <title>Edit</title>
      <link rel='stylesheet' type="text/css" href="docRoot/styles/stylsheet">
   </head>
   <body>
      <form method="post" action ='Controller'>
         <p>
           Instead of going to various websites for different equipment and 
           merchandise for different and different athletes you can just search
           and find them all here.
         <p>
           <table cols="112 112 112">
               <tr>
               <td>Athlete</td> 
               <td><input type="text" name="athlete"
                           value="${attribute.bean.athlete}"></td>
               <td>${attribute.errors.athlete}</td>
               </tr>
               <tr>
               <td>Sport</td> 
               <td> <input type="text" name="sport"
                           value="${attribute.bean.sport}"></td>
               <td>${attribute.errors.sport} </td>
               </tr>
                <tr>
               <td>Item(Ball, Shoe, Jersey)</td> 
               <td> <input type="text" name="item"
                           value="${attribute.bean.item}"></td>
               <td>${attribute.errors.item}</td>
               </tr><tr>
               <td>Quantity(1-10)</td> 
               <td><input type="text" name="quantity"
                           value="${attribute.bean.quantity}"></td>
               <td> ${attribute.errors.quantity}</td>
               </tr><tr>
               <td>Price</td> 
               <td><input type="text" name="price"
                           value="${attribute.bean.price}"></td>
               <td>${attribute.errors.price}</td>
               </tr>
           </table>
               
               <BR>
            Preferred Extras: ${attribute.bean.extra}
            <INPUT type="checkbox" name="extra" value="sprinkles" 
                ${attribute.bean.extra["sprinkles"]}>Chocolate Sprinkles
            <INPUT type="checkbox" name="extra" value="fudge" 
                ${attribute.bean.extra["fudge"]}>Hot Fudge
            <INPUT type="checkbox" name="extra" value="cream" 
                ${attribute.bean.extra["cream"]}>Whipped Cream
            
            <BR>
            Grade 
            <SELECT name="grade"> 
                <OPTION value="4.00" ${attribute.bean.grade["4.0"]}>A 
                <OPTION value="3.67" ${attribute.bean.grade["3.67"]}>A- 
                <OPTION value="3.33" ${attribute.bean.grade["3.33"]}>B+ 
                <OPTION value="3.00" ${attribute.bean.grade["3.0"]}>B 
                <OPTION value="2.67" ${attribute.bean.grade["2.67"]}>B- 
                <OPTION value="2.33" ${attribute.bean.grade["2.33"]}>C+ 
                <OPTION value="2.00" ${attribute.bean.grade["2.0"]}>C 
            </SELECT> 
           
           <br>
           <input type="submit" name="confirmButton"
                           value="Confirm">
           
         
             
         
      </form>
   </body>
</html