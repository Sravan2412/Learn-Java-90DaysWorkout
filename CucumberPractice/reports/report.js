$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Carwale.feature");
formatter.feature({
  "name": "CarWale",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Lowest KM Car",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Go to https://www.carwale.com/",
  "keyword": "Given "
});
formatter.match({
  "location": "CarWaleLowestKMCar.goToHttpsWwwCarwaleCom()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Used",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.clickOnUsed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select the City as Chennai",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.selectTheCityAsChennai()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select budget min 9L and max 12L and Click Search",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.selectBudgetMinLAndMaxLAndClickSearch()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Cars with Photos under Only Show Cars With",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.selectCarsWithPhotosUnderOnlyShowCarsWith()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Manufacturer as BMW --\u003e 3-Series",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.selectManufacturerAsBMW()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Fuel Type as Diesel",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.selectFuelTypeAsDiesel()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Best Match as KM: Low to High",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.selectBestMatchAs()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the Cars are listed with KMs Low to High",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.validateTheCarsAreListedWithKMsLowToHigh()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add the least KM ran car to Wishlist",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.addTheLeastKMRanCarToWishlist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Go to Wishlist and Click on More Details",
  "keyword": "And "
});
formatter.match({
  "location": "CarWaleLowestKMCar.goToWishlistAndClickOnMoreDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Print all the details under Overview in the Same way as displayed in application",
  "keyword": "When "
});
formatter.match({
  "location": "CarWaleLowestKMCar.printAllTheDetailsUnderOverviewInTheSameWayAsDisplayedInApplication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "CarWaleLowestKMCar.closeTheBrowser()"
});
formatter.result({
  "status": "passed"
});
});