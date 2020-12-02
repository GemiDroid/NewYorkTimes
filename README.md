# This is NewYork Times Article App:

# Technologies and pattern:

1- Applying Clean architecture-> Dividing code to (data layer, domain layer(UseCases) and presentation layer).
2- MVVM: Model-View-ViewModel-> For dealing with data layer and presentation layer.
3- LiveData: as Observing on changes in data.
4- Kotlin Coroutines-> For asynchronous operations
5- Retrofit-> For dealing with webServices and OkHTTP requests.
6- Koin: for injecting modules and provide them across app within scopes.
7- UI Testing-> By using Espresso, I applied some test on UI.
8- Unit Testing-> By using JUnit, I created test case and made assertion to test.
9- CICD: Conitious Integration/Conitious Delivery-> For building, validating and releasing by using CircleCI.

# How to test UI test:

1- Navigate to src/androidTest.
2- Navigate to java, then open com.gemidroid.newyorktimearticles.presentation.ui.
3- Run 2 UI tests.

# How to test unit test:

1- Navigate to src/test.
2- Navigate to java, then open com.gemidroid.newyorktimearticles.presentation.
3- Run 1 Unit test.
