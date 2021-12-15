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

# YouTube Demo:
https://youtu.be/jE_F7PKuTo0
