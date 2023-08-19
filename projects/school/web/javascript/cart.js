ready();
function ready() {
    var removeCartItemButtons = document.getElementsByClassName('remove');
    for (var i = 0; i < removeCartItemButtons.length; i++) {
        var button = removeCartItemButtons[i];
        button.addEventListener('click', removeCartItem);
    }
    var quantityInputs = document.getElementsByClassName('quantity');
    for (var i = 0; i < quantityInputs.length; i++) {
        var input = quantityInputs[i];
        input.addEventListener('change', quantityChanged);
    }
    var addToCartButtons = document.getElementsByClassName('button');
    for (var i = 0; i < addToCartButtons.length; i++) {
        var button = addToCartButtons[i];
        button.addEventListener('click', addToCartClicked);
    }
    document.getElementsByClassName('btnPurchase')[0].addEventListener('click', purchaseClicked);
}

function purchaseClicked() {
    var price = document.getElementsByClassName('totalPrice')[0];
    var value = parseFloat(price.innerText.replace('RM', ''));
    if(value > 0){
        if (confirm("Are sure that you would like to submit the book order?") == 1){
        alert("Please proceed to payment");
        var cartItems = document.getElementsByClassName('cart-items')[0];
        while (cartItems.hasChildNodes()) {
            cartItems.removeChild(cartItems.firstChild);
        }
        localStorage.clear();
        updateCartTotal();
        window.open("payment.html","_self");                        
      }
    } else {
        alert("Total Amount is invalid");
    }    
    
}
function removeCartItem(event) {
    var buttonClicked = event.target;
    buttonClicked.parentElement.parentElement.remove();
    updateCartTotal();
}

function quantityChanged(event) {
    var input = event.target;
    if (isNaN(input.value) || input.value <= 0) {
        input.value = 1;
    }
    if(input.value > 3){
        input.value = 3;
    }
    updateCartTotal();
}
function addToCartClicked(event){
    var button = event.target;
    var shopItem = button.parentElement.parentElement.parentElement;
    var title = shopItem.getElementsByClassName('title')[0].innerText;
    localStorage.setItem("Title", title);
    var price = shopItem.getElementsByClassName('price')[0].innerText;
    localStorage.setItem("Price", price);
    addItemToCart();
    updateCartTotal();
}
function addItemToCart() {
    var title = localStorage.getItem("Title");
    var price = localStorage.getItem("Price");
    var cartRow = document.createElement('div');
    cartRow.classList.add('cart-row');
    var cartItems = document.getElementsByClassName('cart-items')[0];
    var cartItemNames = cartItems.getElementsByClassName('cart-item-title');
    for (var i = 0; i < cartItemNames.length; i++) {
        if (cartItemNames[i].innerText == title) {
            alert('This item is already added to the cart');
            return;
        }
    }
    var cartRowContents = `
        <div class="cart-item">
            <span class="cart-item-title">${title}</span>
        </div>
        <div class="cart-price">
            <span class="cart-price-value">${price}</span>
        </div>
        <div class="cart-quantity">
            <input class="quantity" type="number" value="1">
            <button class="remove" type="button">REMOVE</button>
        </div>`;
    cartRow.innerHTML = cartRowContents;
    cartItems.append(cartRow);
    cartRow.getElementsByClassName('remove')[0].addEventListener('click', removeCartItem);
    cartRow.getElementsByClassName('quantity')[0].addEventListener('change', quantityChanged);
}

function updateCartTotal() {
    var cartItemContainer = document.getElementsByClassName('cart-items')[0];
    var cartRows = cartItemContainer.getElementsByClassName('cart-row');
    var total = 0;
    for (var i = 0; i < cartRows.length; i++) {
        var cartRow = cartRows[i];
        var priceElement = cartRow.getElementsByClassName('cart-price-value')[0];
        var quantityElement = cartRow.getElementsByClassName('quantity')[0];
        var price = parseFloat(priceElement.innerText.replace('RM', ''));
        var quantity = quantityElement.value;
        total = total + (price * quantity);
    }
    total = total.toFixed(2);
    document.getElementsByClassName('totalPrice')[0].innerText = 'RM' + total;
}