# Expose products to UI

In order to expose catalog to customers, lets create some HTML / JS and load our products
Ensure it works as expected with E2E test

### ToDoes
- Write E2E tests to verify the functionality of your frontend and backend integration.
- Test the homepage to ensure it loads without errors and displays expected elements.
- Test the product catalog API endpoint to verify it returns the correct product data.
- Simulate product loading and ensure the listing page displays products correctly.

## Essential Intellij shortcuts:

* Extend selection ``Ctrl + W``
* Extract/Assign result to variable ``Ctrl + Alt + V``

### E2E test

Check if application works as expected by simulating real-world user scenarios

[HTTP Status codes](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

`pl.jkanclerz.ecommerce.HomepageHttpTest`
`pl.jkanclerz.ecommerce.catalog.CatalogHttpTest`

### E2E tests VS Integration tests VS Unit tests

* Complexity: `E2E > Integration > Unit`
* Time: `E2E > Integration > Unit`
* Resources `E2E > Integration > Unit`


## Files
* [pom.xml](../pom.xml)
* [src/test/java/pl/jkanclerz/ecommerce/HomepageHttpTest.java](../src/test/java/pl/jkanclerz/ecommerce/HomepageHttpTest.java)
* [src/test/java/pl/jkanclerz/ecommerce/catalog/CatalogHttpTest.java](../src/test/java/pl/jkanclerz/ecommerce/catalog/CatalogHttpTest.java)

