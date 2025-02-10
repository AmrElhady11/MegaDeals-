




function handleCartAction(productId) {
    const button = document.getElementById('cartButton-' + productId);

    if (!button.dataset.cartAdded) {
        button.dataset.cartAdded = true; // Mark this button as added to cart
        button.textContent = 'Go to Cart'; // Change the button text
    } else {
        window.location.href = '/cart'; // Redirect to cart
    }
}
