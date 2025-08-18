<%--
  Created by IntelliJ IDEA.
  User: alych
  Date: 7/15/2025
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product Form</title>
    <style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
    <form action="save-product" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <label for="name">Product Name: </label>
            <input type="text" id="name" name="name" value=""
                   tabindex="1">
            <label for="description">Description: </label>
            <input type="text" id="description" name="description"
                   tabindex="2">
            <label for="price">Price: </label>
            <input type="text" id="price" name="price" tabindex="3">
            <div id="buttons">
                <label for="dummy"> </label>
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Product">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
VD 3.6: Trang ProductDetails.jsp

<!DOCTYPE html>
<html>
<head>
    <title>Save Product</title>
    <style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
    <h5>Details:</h5>
    Product Name: ${product.name}<br/>
    Description: ${product.description}<br/>
    Price: $${product.price}
    </p>
</div>
</body>
</html>
