Documentation: Creating an Android Application with Basic Activity

Introduction:
This document will guide you through creating an Android application using the Basic Activity project template. 
You will use different resources and widgets to display text and customise the appearance of the app. 
You will also learn how to handle user interactions, import data from one class into another class using inheritance,
display pop-up windows, create, store and decode JSON strings, handle exceptions, write and retrieve data from a file internally,
allow users to customise the app using the Settings Activity and utilise readymade themes from Material Design.

Prerequisites:
Before starting this tutorial, you should have a basic understanding of Java and Android Studio. 
You should also have the Android Studio installed on your computer.

Steps to create an Android application:

Create a new project in Android Studio using the Basic Activity template. This will generate a
default layout for your app, including a toolbar and a floating action button.



1- Use string, colour and theme resources to display text and customise the appearance of the app. 
In the res/values folder, you can define strings, colours and themes that can be referenced in the XML files. 
You can use the @string, @color and @style syntax to reference these resources in your layouts.



2- Build a user interface layout using widgets such as Button, EditText, TextView and RecyclerView. 
You can add these widgets to your layout by dragging and dropping them from the palette in the Layout Editor.
You can also set properties such as text, colour and size in the Properties panel.



3- Register onClick listeners and respond to user interactions with widgets and menu items.
You can register onClick listeners for buttons and menu items using the android: onClick attribute in the XML file.
You can then define the method that should be called when the button or menu item is clicked.



4- Explore a principle of object-oriented programming called inheritance to import the data 
from one class into another class. 



5- Inheritance allows you to create a new class that is a modified
version of an existing class. You can use inheritance to create a subclass that inherits properties
and methods from the parent class. This can be useful for importing data from one class into another class.



6- Use the DialogFragment and AlertDialog classes to display a pop-up window. DialogFragment is a 
subclass of Fragment that can be used to display a dialog window. AlertDialog is a pre-built dialog window 
that can be used to display a message or ask the user for confirmation.



7- Create, store and decode JSON strings. JSON is a lightweight data interchange format that is easy to read and write.
You can create a JSON string by constructing a JSONObject or JSONArray object and then calling the toString() method. 
You can store a JSON string in a file using the FileWriter class. You can decode a JSON string by creating a 
JSONObject or JSONArray object and then calling the appropriate getter methods.



8- Intercept exceptions that might otherwise cause the app to crash. Exceptions are errors that occur during 
runtime that can cause the app to crash. You can catch and handle exceptions using the try-catch block. 
This allows you to gracefully handle errors and prevent the app from crashing.



9- Write and retrieve data from a file internally within the app. You can use the FileOutputStream and 
FileInputStream classes to write and read data from a file in the internal storage of the app. 
This allows you to store data that should not be accessible by other apps.



10- Utilise a Settings Activity to allow the user to customise the app based on their preferences.
A Settings Activity is a pre-built activity that allows the user to modify preferences such as font size,
background colour and notification settings. You can define the preferences in an XML file and then 
read and write them using the SharedPreferences class.



11- Import readymade themes from Material Design and customise the colours used


Conclusion:
In this tutorial, we have learned how to create an Android application using the Basic Activity project template. 
We have used various resources and widgets to display text and customise the appearance of the app. 
We have also learned how to handle user interactions, import data from one class into another class 
using inheritance, display pop-up windows, create, store and decode JSON strings, handle exceptions, 
write and retrieve data from a file internally, allow users to customise the app using the Settings 
Activity and utilise readymade themes from Material Design.

By following these steps, you can create a basic Android application with a user interface that 
responds to user interactions and customisation. With the knowledge gained from this tutorial, 
you can continue to explore and develop your Android programming skills.