const getProducts = () => {
    return fetch("/api/products")
        .then(r => r.json())
}

const createHtmlEl = (productData) => {
    const template = `
        <div class="product">
            <h4>${productData.name}</h4>
            <img src="https://picsum.photos/id/237/200/300" />
            <div class="product__price">
                <span>${productData.price}</span>
                <button data-id="${productData.id}">Add to cart +</button>
            </div>
        </div>
    `
    const el = document.createElement("li");
    el.innerHTML = template.trim();

    return el;
}

(async () => {
    const productList = document.querySelector("#productList");

    getProducts()
        .then(productsAsJson => productsAsJson.map(createHtmlEl))
        .then(productsAsHtml => productsAsHtml.forEach(productEl => productList.appendChild(productEl)));
})();