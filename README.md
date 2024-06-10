# PracticumWeatherAppST10459491
START SplashActivity
    DISPLAY logo, app name, developer info, start button, exit button

    IF start button is clicked THEN
        NAVIGATE to MainActivity
    END IF

    IF exit button is clicked THEN
        EXIT app
    END IF

    DELAY for 2 seconds
    NAVIGATE to MainActivity automatically
END SplashActivity
START MainActivity
    DEFINE daysOfWeek = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
    DEFINE minTemperatures = [25, 15, 20, 18, 16, 10, 12]
    DEFINE maxTemperatures = [29, 25, 27, 23, 21, 18, 16]
    SET totalTemp = 0

    LOOP from i = 0 to length(daysOfWeek) - 1
        CALCULATE averageDailyTemp = (minTemperatures[i] + maxTemperatures[i]) / 2
        ADD averageDailyTemp to totalTemp
    END LOOP

    CALCULATE averageTemp = totalTemp / length(daysOfWeek)
    DISPLAY "Average Temperature: " + averageTemp + "°C"

    IF detailedViewButton is clicked THEN
        NAVIGATE to DetailActivity
    END IF

    IF exitButton is clicked THEN
        EXIT app
    END IF
END MainActivity
START DetailActivity
    FOR each day in daysOfWeek
        DISPLAY day
        DISPLAY "Min Temperature: " + minTemperatures[day]
        DISPLAY "Max Temperature: " + maxTemperatures[day]
        DISPLAY "Weather Condition: " + weatherCondition[day]
    END FOR

    IF backButton is clicked THEN
        NAVIGATE to MainActivity
    END IF
END DetailActivity
FUNCTION calculateAverageTemperature(minTemps, maxTemps)
    SET totalTemp = 0
    SET numDays = length(minTemps)
    
    FOR i = 0 to numDays - 1
        SET dailyAverage = (minTemps[i] + maxTemps[i]) / 2
        ADD dailyAverage to totalTemp
    END FOR

    RETURN totalTemp / numDays
END FUNCTION

FUNCTION navigateTo(screen)
    IF screen == "MainActivity" THEN
        LOAD MainActivity
    ELSE IF screen == "DetailActivity" THEN
        LOAD DetailActivity
    END IF
END FUNCTION

FUNCTION handleInputErrors(data)
    IF data is invalid THEN
        DISPLAY errorMessage
        RETURN false
    END IF
    RETURN true
END FUNCTION

FUNCTION exitApp()
    CLOSE app
END FUNCTION
FUNCTION validateInput(data)
    IF data is empty THEN
        DISPLAY "Input cannot be empty."
        RETURN false
    ELSE IF data is not a number THEN
        DISPLAY "Invalid input. Please enter a number."
        RETURN false
    ELSE IF data is out of range THEN
        DISPLAY "Temperature out of realistic range."
        RETURN false
    END IF
    RETURN true
END FUNCTION

TRY
    GET user input
    IF validateInput(user input) THEN
        PROCEED with processing
    ELSE
        DISPLAY error message
    END IF
CATCH exception
    DISPLAY "An unexpected error occurred."
END TRY
