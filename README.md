This program is developed in java that is interactive, enabling input to explore different methods for generating random numbers and characters.
The application gives options for generating random integers within specified ranges, lowercase characters randomly, characters within user-defined ranges,
characters based on a starting character and an integer, and random special characters excluding letters and digits.

The program begins by presenting a menu with numbered options (1 to 5) corresponding to different random generation methods. Entering '0' exits the program.

Case 1 (nextInt(int low, int high)) prompts the user to input a low and high range, then generates and prints 30 random integers within that range.
Case 2 (nextChar()) generates and prints 30 random lowercase characters from 'a' to 'z'.
Case 3 (nextChar(char from, char to)) asks the user to input two characters defining a range and generates 30 random characters within that range.
Case 4 (nextChar(char from, int i)) requires a starting character and a positive integer as input. It then generates and prints 30 random characters based on the provided starting character and integer.
Case 5 (nextSpecialChar()) generates and prints 30 random special characters (non-alphanumeric) by excluding letters and digits. The program uses a do-while loop to ensure that special characters generated in option 5 are not letters or digits.

Exception handling is implemented to catch invalid inputs (non-numeric inputs for choices and non-integer inputs for numeric options).

The code is well-indented, following Java conventions, which makes it easy to read and understand the program's structure. The indentation enhances code efficiency.
