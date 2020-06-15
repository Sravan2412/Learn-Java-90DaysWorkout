Feature: BigBasket Shopping

Scenario Outline: Adding Juices to cart in BigBasket website

Given Go to link https://www.bigbasket.com
And click on Address 
And Select Chennai as City, <Area> as Area and click Continue 
And mouse over on to Shop by Category 
And Go to Beverages and Fruit juices & Drinks
And Click on JUICES
And click Tropicana and Real under Brand
And Check count of the products from each Brands and total count
And Check whether the products is availabe with Add button.
And Add the First listed available product
And Mouse over on My Basket print the product name. count and price.
When Click View Basket & Checkout
Then Click the close button

Examples:

|Area|
|T Nagar|
|Vadapalani|
|Redhills|
