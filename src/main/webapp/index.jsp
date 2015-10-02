<%@ taglib prefix="ex" uri="/WEB-INF/tld/Json.tld" %>
<html>
<head>
    <style>
        div.tab {
            padding-left: 1cm;
        }
    </style>
    <title>A sample custom tag</title>
</head>
<body>
Valid JSON example:
<div>
    <ex:json>
        {"widget": {
        "debug": "on",
        "window": {
        "title": "Sample Konfabulator Widget",
        "name": "main_window",
        "width": 500,
        "height": 500
        },
        "image": {
        "src": "Images/Sun.png",
        "name": "sun1",
        "hOffset": 250,
        "vOffset": 250,
        "alignment": "center"
        },
        "text": {
        "data": "Click Here",
        "size": 36,
        "style": "bold",
        "name": "text1",
        "hOffset": 250,
        "vOffset": 100,
        "alignment": "center",
        "onMouseUp": "sun1.opacity = (sun1.opacity / 100) * 90;"
        }
        }}
    </ex:json>
</div>
Invalid JSON example:
<div>
    <ex:json>
        {"employees": [{ "firstName":"John" ,, "lastName":"Doe\" }]}
    </ex:json>
</div>
</body>
</html>

