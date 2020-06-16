This is NewYork Times Article App:

# Technologies and pattern:
1- Applying Clean architecture-> Dividing code to (data layer, domain layer(UseCases) and presentation layer).
2- MVP: Model-View-Presenter-> For dealing with data layer and presentation layer.
3- RxJava & RxAndroid-> For asynchronous operations 
4- Retrofit-> For dealing with webServices and OkHTTP requests.
5- UI Testing-> By using Espresso, I applied some test on UI.
6- Unit Testing-> By using JUnit, I created test case and made assertion to test.
7- CICD: Conitious Integration/Conitious Delivery-> For building, validating and releasing by using CircleCI.

# How to test UI test:
1- Navigate to src/androidTest.
2- Navigate to java, then open com.example.newyorktimearticles.presentation.ui.
3- Run 2 UI tests.

#How to test unit test:
1- Navigate to src/androidTest.
2- Navigate to java, then open com.example.newyorktimearticles.presentation.presenter.
3- Run 1 Unit test.

#According to coroutines:
1-It's used by Kotlin not Java.
2-Resource: https://play.kotlinlang.org/.
