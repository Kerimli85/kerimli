var selectedProductId = 0;
var API_URL = "http://localhost:8585";

var productNameInput = document.getElementById('product-name');
var productDescriptionInput = document.getElementById('product-description');
var productQuantityInput = document.getElementById('product-quantity');
var productCostInput = document.getElementById('product-cost');
var productPriceInput = document.getElementById('product-price');

var productsTbodyElement = document.getElementById('products-tbody');
var headerTextElement = document.getElementById('header-text');


function onSaveProduct(event) {
    event.preventDefault();
    var productName = productNameInput.value;
    var productDescription = productDescriptionInput.value;
    var productQuantity = productQuantityInput.value;
    var productCost = productCostInput.value;
    var productPrice = productPriceInput.value;

    var productObject = {};
    productObject.id = selectedProductId;
    productObject.name = productName;
    productObject.description = productDescription;
    productObject.quantity = productQuantity;
    productObject.cost = productCost;
    productObject.price = productPrice;


    var http = new XMLHttpRequest();

    http.onload = function () {
        selectedProductId = 0;
        setHeaderText('Yeni Aksesuar Qeydiyyati');
        loadAllProducts();
    }

    http.open("POST", API_URL + "/products", true);
    http.setRequestHeader("Content-Type", "application/json");
    http.send(JSON.stringify(productObject));

}
function loadAllProducts() {

    var http = new XMLHttpRequest();

    http.onload = function () {
        var response = this.responseText;
        var productsArray = JSON.parse(response);
        fillProductsTable(productsArray);
    }

    http.open("GET", API_URL + "/products", true);
    http.send();
}
function fillProductsTable(products) {

    var productsTbodyHtml = "";
    for (var i = 0; i < products.length; i++) {
        var product = products[i];
        productsTbodyHtml += "<tr><td>" + product.id + "</td>";
        productsTbodyHtml += "<td>" + product.name + "</td>";
        productsTbodyHtml += "<td>" + product.description + "</td>";
        productsTbodyHtml += "<td>" + product.quantity + "</td>";
        productsTbodyHtml += "<td>" + product.cost + "</td>";
        productsTbodyHtml += "<td>" + product.price + "</td>";



        productsTbodyHtml += "<td><button class = 'btn btn-danger btn-sm' onclick = 'onDeleteProduct("
            + product.id + ")' >Sil</button> ";
        productsTbodyHtml += "<button class = 'btn btn-primary btn-sm' onclick = 'onEditProduct("
            + product.id + ")'>Redaktə</button></td></tr>";
    }
    productsTbodyElement.innerHTML = productsTbodyHtml;
}

loadAllProducts();

function onDeleteProduct(productId) {
    if (confirm('silmeye eminsiniz ?')) {
        var http = new XMLHttpRequest();
        http.onload = function () {
            loadAllProducts();
        }
        http.open("DELETE", API_URL + "/products/" + productId, true);
        http.send();
    }
}

function onEditProduct(productId) {
    selectedProductId = productId;
    setHeaderText('Aksesuar Redaktesi, id = ' + productId);
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var productObject = JSON.parse(response);
        productNameInput.value = productObject.name;
        productDescriptionInput.value = productObject.description;
        productQuantityInput.value = productObject.quantity;
    }
    http.open("GET", API_URL + "/products/" + productId, true);
    http.send();
}

function setHeaderText(text) {
    headerTextElement.innerHTML = text;
}

setHeaderText('Yeni Aksesuar Qeydiyyati');