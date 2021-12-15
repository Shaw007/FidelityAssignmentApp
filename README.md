# FidelityAssignmentApp 

Note: This app was developed on an Intel based macbook. It may or may not compile and build on a Silicon based macbook

This app shows a list of seasons fetched from a REST API. It saves the result into the local database for caching. Only the seasons shown on the Home screen are saved in the local database, whereas, on the Search screen, the seasons are always fetched from the network. This app uses a Shared ViewModel approach. 

This app uses MVVM architecture along with the following libraries:

- Navigation Component
- Hilt for Dependency Injection
- Room
- Retrofit with Gson
- Kotlin Flows
- Coil for image loading
- ViewModel and LiveData
- Material Design Library

![ezgif com-gif-maker](https://user-images.githubusercontent.com/6193968/146120294-18418cb4-c2a9-44ff-bb26-1e287f9fcad2.gif)
