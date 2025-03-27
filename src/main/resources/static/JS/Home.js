




function handleCartAction(productId) {
    fetch(`/home/addToCart/${productId}`, {
        method: 'POST'
    });

    const button = document.getElementById('cartButton-' + productId);

    if (!button.dataset.cartAdded) {
        button.dataset.cartAdded = true; // Mark this button as added to cart
        button.textContent = 'Go to Cart'; // Change the button text
    } else {
        window.location.href = '/cart'; // Redirect to cart
    }
}
function updateQuantity() {
    var productId = document.querySelector('input[name="productId"]').value;
    var quantity = document.getElementById('quantityInput').value;

    var url = `/cart/update/${productId}/${quantity}`;

    var form = document.getElementById('updateForm');
    form.action = url;
    form.submit();
}
