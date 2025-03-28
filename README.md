# Date_structure
## Program can:
* Add dates
* Print last added date
* Find is date valid
* Update date
* Calculate difference between dates
* Sort dates in ascending order
## In the code there are Date class and DateStructure - main class.

## There is some examples of code working:

To run the program, you will need a Java Development Kit (JDK) installed on your system. Save the code as `DateStructure.java` and compile it using the command:

```bash
javac DateStructure.java
```

Start the program, and you will be prompted to enter the initial date.

Example 1: Adding a date and checking its validity
```
Enter the date in the format dd mm yyyy:
29 02 2024
1. Add another date
2. Check if the current date is valid
3. Update the current date
4. Get the day of the week
5. Calculate the difference between two dates
6. Print the current date
7. Sort dates
8. Exit
2
The current date is valid.
```
Example 2: Adding an invalid date
```
Enter the date in the format dd mm yyyy:
30 02 2023
Invalid date. Not added to the list.
Enter the date in the format dd mm yyyy:
```
Example 3: Adding multiple dates and printing the last added date (which is the 'current date' in the program)
```
Enter the date in the format dd mm yyyy:
15 03 2025
1. Add another date
...
6. Print the current date
...
6
March 15, 2025
```
Example 4: Updating a date
```
Enter the date in the format dd mm yyyy:
10 01 2024
1. Add another date
...
3. Update the current date
...
3
Enter the new date in the format dd mm yyyy:
20 01 2024
Date updated to 20/1/2024
```
Example 5: Calculating the difference between two dates
```
Enter the date in the format dd mm yyyy:
01 01 2023
1. Add another date
...
5. Calculate the difference between two dates
...
5
Enter the second date in the format dd mm yyyy:
05 01 2023
Difference between dates is 4 days
```
Example 6: Getting the day of the week
```
Enter the date in the format dd mm yyyy:
27 03 2025
1. Add another date
...
4. Get the day of the week
...
4
Day of the week: Thursday
```
Example 7: Adding multiple dates and sorting them
```
Enter the date in the format dd mm yyyy:
10 02 2023
1. Add another date
1
Enter the new date in the format dd mm yyyy:
05 01 2024
Date added successfully.
1
Enter the new date in the format dd mm yyyy:
20 12 2022
Date added successfully.
1. Add another date
...
7. Sort dates
...
7
Sorted dates:
December 20, 2022
February 10, 2023
January 5, 2024
March 10, 2025
```
Example 8: Exiting the program
```
Enter the date in the format dd mm yyyy:
01 01 2025
1. Add another date
...
8. Exit
```
