# Cryptosphere - Explore the World of Cryptocurrencies

Welcome to Cryptosphere! This application allows you to explore detailed information about your favorite cryptocurrencies, including prices, charts, and more.

## First Steps: Setting Up the API Key

To use Cryptosphere, you need to obtain a free API key from CoinGecko. Follow these steps:

1.  **Create a CoinGecko Account:** If you don't already have one, visit the CoinGecko website and create an account.
2.  **Get Your API Key:** Once logged in, follow the instructions provided in this link to set up and obtain your API key: [https://docs.coingecko.com/v3.0.1/reference/setting-up-your-api-key](https://docs.coingecko.com/v3.0.1/reference/setting-up-your-api-key)

## Local Configuration: The `local.properties` File

After obtaining your API key from CoinGecko, you need to configure it locally for your application build. Follow these steps:

1.  **Locate the `local.properties` File:** In the root directory of the Cryptosphere project (where the top-level `build.gradle` file is located), look for a file named `local.properties`. If it doesn't exist, create it.

2.  **Add Your API Key:** Open the `local.properties` file with a text editor and add your API key in the following format:

    ```properties
    coinGeckoApiKey=YOUR_COIN_GECKO_API_KEY
    ```

    Replace `YOUR_COIN_GECKO_API_KEY` with the API key you obtained from CoinGecko.

3.  **Important:** Ensure that the `local.properties` file is included in your `.gitignore` file. This will prevent you from accidentally committing your API key to the repository. Android Studio usually adds it by default.

4.  **Sync Gradle:** After modifying the `local.properties` file, synchronize your Gradle project in Android Studio (File > Sync Project with Gradle Files).

5. **Environments** Build application in debug(default)

## Multi-Module Architecture

Cryptosphere is structured as a multi-module application for better organization, scalability, and code maintainability. The main modules are:

* **`core`:** This module contains the low-level logic and dependencies shared across different features of the application. It includes:
    * Data definitions (models).
    * Interfaces for repositories and use cases.
    * Base implementations for network management, database handling, and other fundamental logic.
    * Low-level system dependencies.

* **`app`:** This is the main application module. It is responsible for navigation between different screens (features) and contains the application startup logic, such as the splash screen. It depends on other modules to access functionalities.

* **`feature`:** This module (or this directory containing multiple feature modules) contains the implementations of the various screens and functionalities of the application. Each feature (e.g., the cryptocurrency list, the detail screen) is ideally contained within a separate module. These modules depend on the `core` module for business logic and data.

## Architectural Pattern and Design Principles

Cryptosphere adopts the **MVI (Model-View-Intent)** architectural pattern and follows the principles of **Clean Architecture** in Android to ensure a robust, testable, and well-organized codebase.

* **MVI (Model-View-Intent):** This reactive pattern is based on a unidirectional data flow.
    * **Model:** Represents the immutable state of the View.
    * **View:** Displays the state and sends user intents.
    * **Intent:** Represents the user's intention to perform an action.

* **Clean Architecture:** This approach aims to separate concerns into different concentric layers. The inner layers (entities, use cases) are independent of the outer layers (UI, frameworks, database). This promotes testability, framework independence, and maintainability.

We hope you enjoy exploring the world of cryptocurrencies with Cryptosphere! If you have any questions or encounter any issues, please don't hesitate to consult the documentation or contact the development team.