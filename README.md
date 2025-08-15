# Quick Deal App

An Android application designed to help users discover and manage deals, discounts, and favorite products. This app features a bottom navigation for easy access to different sections like home, favorites, search, and cart. User authentication is handled via Firebase.

## Features and Functionality

*   **Home:** Displays promotional cards, a list of products with offers, and claimable discount items. Includes a search bar to find specific deals.
*   **Favorites:** Shows a grid of products marked as favorites, managed using a `FavoriteViewModel`.
*   **Search:** Presents verified deals and customer reviews. Clicking on specific items (e.g., "Cropped Blazer") navigates to discount details.
*   **Cart:** Displays a list of items in the cart with prices, discounts, and a summary of the total cost.
*   **User Authentication:** Implemented using Firebase Authentication, allowing users to sign up, sign in, reset passwords, and manage their profiles.
*   **User Profile:** Accessible through the user icon, allows users to view their name (or "Guest" if not signed in) and sign out.

## Technology Stack

*   **Android SDK:**  For building the Android application.
*   **Java:** The primary programming language.
*   **Gradle:** Build automation system.
*   **Android Jetpack:**
    *   `AppCompat`: For activity compatibility.
    *   `RecyclerView`: For displaying lists of items efficiently.
    *   `ViewModel`: For managing UI-related data in a lifecycle-conscious way (e.g., `FavoriteViewModel`).
    *   `LiveData`: For observable data that is lifecycle-aware.
    *   `EdgeToEdge`: For immersive UI.
*   **Firebase:**
    *   `Firebase Authentication`: For user authentication and management.
*   **View Binding:**  To easily access and interact with views.

## Prerequisites

*   Android Studio installed.
*   Android SDK configured.
*   Firebase project set up with Authentication enabled.
*   `google-services.json` file added to the `app/` directory.

## Installation Instructions

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/SeanSoulong/quick-deal-app.git
    ```

2.  **Open the project in Android Studio.**

3.  **Add `google-services.json`:**  Download the `google-services.json` file from your Firebase project and place it in the `app/` directory of your Android project.

4.  **Build and Run:** Click on "Build" > "Make Project" and then "Run" to install the app on an emulator or connected device.

## Usage Guide

1.  **Welcome Screen:** The app starts with a welcome screen (`welcome.java`) where users can sign up or sign in.
2.  **Sign Up:** Click the "Sign Up" button and fill in the required details in `singup.java`.  Ensure the email is valid, the password is at least 6 characters long, and the confirm password matches.
3.  **Sign In:** Enter your email and password in `welcome.java` and click the "Sign In" button.
4.  **Home Screen:**  After successful sign-in, you will be directed to the home screen (`HomeFragment.java`). Browse products, claim discounts, and use the search bar.
5.  **Navigation:** Use the bottom navigation bar in `MainActivity.java` to switch between different sections:
    *   **Home (R.id.nav_home):** Displays promotional content, product listings, and claimable deals.  The search bar in `HomeFragment.java` navigates to the Search fragment (`SearchFragment.java`) when "ten11" is entered.
    *   **Favorites (R.id.nav_favorit):** Shows a list of products marked as favorites, using `FavoriteFragment.java`. Products can be added to/removed from favorites through the heart icon displayed in `ProductAdapter.java`.
    *   **Search (R.id.nav_search):** Allows users to search for verified items, view reviews, and discover deals. Clicking "Cropped Blazer" in `SearchFragment.java` navigates to `DiscountFragment.java`. Clicking "Slim Cropped Tank Top" navigates to `DiscountFragment2.java`
    *   **Cart (R.id.nav_cart):**  Displays items added to the cart (`CartFragment.java`).
6.  **User Profile:** Tap the user icon on the top to access the user profile (`UserFragment.java`), where you can view your name and sign out.
7.  **Cart Management:**  The Cart Fragment (`CartFragment.java`) shows added items with the quantity, price, and total amount.
8.  **Password Reset:** If you forget your password, click the "Forgot Password" link on the welcome screen and follow the instructions in `forgetpassword.java` to reset it.

## API Documentation

This app utilizes Firebase Authentication. Refer to the official Firebase documentation for details on the available APIs for user management:

*   [Firebase Authentication](https://firebase.google.com/docs/auth)

## Contributing Guidelines

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix: `git checkout -b feature/your-feature-name`.
3.  Make your changes and commit them with descriptive messages.
4.  Push your changes to your fork: `git push origin feature/your-feature-name`.
5.  Create a pull request to the `main` branch of the original repository.

## License Information

No license has been specified for this project. All rights are reserved by the owner.

## Contact/Support Information

For questions or support, please contact Sean Soulong through GitHub.
