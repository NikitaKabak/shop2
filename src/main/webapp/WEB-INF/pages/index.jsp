<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        function toggle_show(id) {
            document.getElementById(id).style.display = document.getElementById(id).style.display == 'none' ? 'block' : 'none';
        }
    </script>

</head>
<body>
<ul>
    <li>Название 1</li>
    <li onClick="toggle_show('bla-bla2')">Название 2
        <ul id="bla-bla2" style="display: none">
            <li>Бла Бла Бла</li>
            <li>Бла Бла Бла</li>
            <li>Бла Бла Бла</li>
        </ul>
    </li>
    <li>Название 3</li>
</ul>
</body>
<form >
    <button type="button" onclick='location.pathname="/shop"'>SHOP.by.Nikita</button>
</form>

</html>
